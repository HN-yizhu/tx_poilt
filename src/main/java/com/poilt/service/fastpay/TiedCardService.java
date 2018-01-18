package com.poilt.service.fastpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.model.MerchRegister;
import com.poilt.model.TiedCard;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.utils.Serialnumber;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class TiedCardService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TradeHttpRequestExecute tradeExecute;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private MerchService merchService;
	
	@Value("${fastpay.rateCode}")
	private String rateCode;
	
	@Value("${fastpay.pageReturnUrl}")
	private String pageReturnUrl;
	
	@Value("${fastpay.cardNotifyUrl}")
	private String cardNotifyUrl;
	
	/**
	 * 绑结算卡
	 * @param param
	 * @return
	 * @throws JsonException 
	 * @throws Exception 
	 */
	@Transactional(rollbackFor=Exception.class)
	public void tiedCard(Card card) throws JsonException {
		/*获取用户信息*/
		Merch user = merchService.findByOpenId(card.getOpenId());
		/*是否已经绑过卡*/
		Card existsCard = cardService.findByCardNo(user.getOpenId(), card.getCardNo());
		if(existsCard == null){
			/*记录结算卡信息*/
			String[] codes = card.getBankCode().split(",");
			card.setBankCode(codes[0]);
			card.setBankAbbr(codes[1]);
			card.setIdCard(user.getIdCard());
			card.setPhone(user.getPhone());
			card.setCardName(user.getName());
			card.setCardType("1");//借记卡
			card.setUseType("1");//结算卡
			cardService.insert(card);
			/*接口商户注册*/
			MerchRegister merchRegister = new MerchRegister();
			merchRegister.setTranType("MERREG");//交易码
			merchRegister.setMerTrace(Serialnumber.getSerial());//商户流水
			merchRegister.setMerName(user.getMerName());//商户名称
			merchRegister.setMerAbbr(user.getMerName());//商户简称
			merchRegister.setRateCode(rateCode);//合作商户费率编号
			merchRegister.setIdCardNo(user.getIdCard());//身份证
			merchRegister.setBankAccNo(card.getCardNo());//银行卡卡号
			merchRegister.setPhoneno(user.getPhone());//银行预留手机
			merchRegister.setBankAccName(user.getName());//银行卡户名
			merchRegister.setBankAccType("2");//银行卡类型(2对私)
			merchRegister.setBankName(card.getBankName());//银行名称
			merchRegister.setBankSubName("上海嘎吱");//支行名称
			merchRegister.setBankCode(card.getBankCode());//银行代码
			merchRegister.setBankAbbr(card.getBankAbbr());//银行代号
			merchRegister.setBankChannelNo("66666");//银行联行号
			merchRegister.setBankProvince("上海");//银行所属省
			merchRegister.setBankCity("上海");//银行所属市
			merchRegister.setDebitRate(user.getCreditRate().toString());//借记卡费率
			merchRegister.setDebitCapAmount("99999900");//借记卡封顶
			merchRegister.setCreditRate(user.getCreditRate().toString());//信用卡费率
			merchRegister.setCreditCapAmount("99999900");//信用卡封顶
			merchRegister.setWithdRate(user.getCreditRate().toString());//提现费率
			merchRegister.setWithdSgFee(user.getCreditFee()*100+"");//单笔提现手续费
			JSONObject result = tradeExecute.tradeHttpReq(JSONObject.toJSONString(merchRegister));
			if(!"000000".equals(result.getString("respCode"))){
				logger.error(StatusCode.SYS_MSG_TIED_CARD.toString()+"["+result.toJSONString()+"]");
				throw new JsonException(StatusCode.SYS_MSG_TIED_CARD);
			}else{
				/*更改用户绑卡状态*/
				Merch merch = new Merch();
				merch.setOpenId(card.getOpenId());
				merch.setTiedCard("Y");
				merch.setMerNo(result.getJSONObject("result").getString("merNo"));
				merch.setMerchUuid(result.getJSONObject("result").getString("merchantUuid"));
				merchService.updateByOpenId(merch);
			}
		}
	}
	
	/**
	 * 信用卡
	 * @param card
	 * @return
	 */
	public JSONObject tiedCreditCard(String openId, String cardNo) {
		/*获取用户信息*/
		Merch user = merchService.findByOpenId(openId);
		/*获取卡信息*/
		Card cardInfo = cardService.findByCardNo(openId, cardNo);
		String orderNo = Serialnumber.getSerial();
		TiedCard card = new TiedCard();
		card.setTranType("POPNCD");
		card.setMerNo(user.getMerNo());
		card.setMerTrace(orderNo);
		card.setOrderId(orderNo);
		card.setRateCode(rateCode);
		card.setCardNo(cardNo);
		card.setAccountName(user.getName());
		card.setCardType(cardInfo.getCardType());
		card.setBankCode(cardInfo.getBankCode());
		card.setBankAbbr(cardInfo.getBankAbbr());
		card.setPhoneno(user.getPhone());
		card.setCvn2("666");
		card.setExpired("6666");
		card.setCertType("01");
		card.setCertNo(user.getIdCard());
		card.setPageReturnUrl(pageReturnUrl);
		card.setOfflineNotifyUrl(cardNotifyUrl);
		/*更新卡片绑卡流水号及订单号*/
		Card updateCard = new Card();
		updateCard.setTraceNo(orderNo);
		updateCard.setOrderNo(orderNo);
		updateCard.setOpenId(openId);
		updateCard.setCardNo(cardNo);
		updateCard.setCardStatus("1");//等等签约中
		cardService.update(updateCard);
		/*发送报文绑卡*/
		JSONObject result = tradeExecute.tradeHttpReq(JSONObject.toJSONString(card));
		return result;
	}
	
}
