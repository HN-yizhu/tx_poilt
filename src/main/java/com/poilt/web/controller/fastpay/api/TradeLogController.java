package com.poilt.web.controller.fastpay.api;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.poilt.exception.Result;
import com.poilt.model.PayMessage;
import com.poilt.model.PayMoney;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.model.fastpay.TradeLog;
import com.poilt.service.fastpay.CardService;
import com.poilt.service.fastpay.MerchService;
import com.poilt.service.fastpay.TradeLogService;
import com.poilt.utils.Serialnumber;
import com.poilt.utils.TradeHttpRequestExecute;

@Controller
public class TradeLogController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MerchService merchService;

	@Autowired
	private CardService cardService;

	@Autowired
	private TradeLogService tradeLogService;

	@Autowired
	private TradeHttpRequestExecute tradeExecute;
	
	@Value("${fastpay.rateCode}")
	private String rateCode;

	@ResponseBody
	@RequestMapping("/fastpay_start_pay")
	public Result<String> startPay(@RequestBody TradeLog trade, HttpSession httpSession) {
		// String openId = httpSession.getAttribute("openId") == null ? "" :
		// httpSession.getAttribute("openId").toString();
		// String openId = httpSession.getAttribute("openId").toString();
		String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
		logger.info("Session openId：" + openId);
		String[] bankCodes = trade.getBankCode().split(",");
		Merch merch = merchService.findByOpenId(openId);
		trade.setOpenId(openId);
		String tradeNo = Serialnumber.getSerial();
		/*记录交易流水号*/
		httpSession.setAttribute("tradeNo", tradeNo);
		trade.setTradeNo(tradeNo);
		trade.setOrderNo(tradeNo);
		trade.setUserName(merch.getName());
		trade.setIdCard(merch.getIdCard());
		trade.setBankCode(bankCodes[0]);
		trade.setBankAbbr(bankCodes[1]);
		trade.setStatus("0");
		tradeLogService.insert(trade);
		/*
		 * 是否绑卡 如果有绑卡记录，看下卡状态是否开通成功
		 */
		Card card = cardService.findByCardNo(openId, trade.getPayCardNo());
		if (card == null) {
			card = new Card();
			card.setOpenId(openId);
			card.setIdCard(merch.getIdCard());
			card.setPhone(merch.getPhone());
			card.setCardNo(trade.getPayCardNo());
			card.setCardType("2");// 信用卡
			card.setCardName(merch.getName());
			card.setBankCode(bankCodes[0]);
			card.setBankAbbr(bankCodes[1]);
			card.setBankName(trade.getBankName());
			cardService.insert(card);
			return new Result<String>("1");
		}else{
			if(!"2".equals(card.getCardStatus())){
				return new Result<String>("1");
			}else{
				return new Result<String>("0");
			}
		}
	}

	/**
	 * 支付短信
	 */
	@ResponseBody
	@RequestMapping("/fastpay_pay_sms")
	public Result<String> paySms(HttpSession httpSession) {
		// String openId = httpSession.getAttribute("openId") == null ? "" :
		// httpSession.getAttribute("openId").toString();
		// String openId = httpSession.getAttribute("openId").toString();
		String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
		logger.info("Session openId：" + openId);
		Merch merch = merchService.findByOpenId(openId);
		String tradeNo = httpSession.getAttribute("tradeNo").toString();
		logger.info("交易短信流水：" + tradeNo);
		TradeLog tradeLog = tradeLogService.findByTradeNo(openId, tradeNo);
		PayMessage message = new PayMessage();
		message.setTranType("PAYMSG");// 交易码
		message.setMerNo(merch.getMerNo());// 合作商户编号
		message.setMerTrace(tradeNo);// 商户流水
		message.setOrderId(tradeNo);// 支付订单号
		message.setOrderAmount(tradeLog.getTradeAmt()*100 + "");// 订单金额(分)
		message.setRateCode(rateCode);// 费率编号
		message.setCardNo(tradeLog.getPayCardNo());// 银行卡卡号
		message.setAccountName(tradeLog.getUserName());// 银行卡姓名
		message.setCardType("2");// 银行卡类型(1、借记卡，2、信用卡)
		message.setBankCode(tradeLog.getBankCode());// 银行代码
		message.setBankAbbr(tradeLog.getBankAbbr());// 银行代号
		message.setPhoneno(merch.getPhone());// 预留手机
		message.setCertType("01");// 01、身份证
		message.setCertNo(merch.getIdCard());// 证件号码
		JSONObject result = tradeExecute.tradeHttpReq(JSONObject.toJSONString(message));
		return new Result<String>(result.toJSONString());
	}
	
	@ResponseBody
	@RequestMapping("/fastpay_pay")
	public Result<String> pay(HttpSession httpSession) {
		// String openId = httpSession.getAttribute("openId") == null ? "" :
		// httpSession.getAttribute("openId").toString();
		// String openId = httpSession.getAttribute("openId").toString();
		String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
		Merch merch = merchService.findByOpenId(openId);
		String tradeNo = httpSession.getAttribute("tradeNo").toString();
		TradeLog tradeLog = tradeLogService.findByTradeNo(openId, tradeNo);
		
		PayMoney payMoney = new PayMoney();
		payMoney.setTranType("CONPAY");
		payMoney.setMerNo(merch.getMerNo());// 合作商户编号
		payMoney.setMerTrace(tradeNo);//商户流水号
		payMoney.setOrderId(tradeNo);// 支付订单号 
		payMoney.setPayNo(tradeNo);//支付流水号
		payMoney.setPayAmount(tradeLog.getTradeAmt()*100+"");// 支付金额(分)
		payMoney.setRateCode(rateCode);// 合作商户费率编号 
		payMoney.setCardNo(tradeLog.getPayCardNo());//银行卡卡号
		payMoney.setAccountName(tradeLog.getUserName());// 银行卡姓名 
		payMoney.setCardType("2");//银行卡类型
		payMoney.setBankCode(tradeLog.getBankCode());// 银行代码 
		payMoney.setBankAbbr(tradeLog.getBankAbbr());//银行代号
		payMoney.setPhoneno(merch.getPhone());// 预留手机
		payMoney.setCertType("01");// 证件类型(01:身份证)
		payMoney.setCertNo(merch.getIdCard());// 证件号码
		payMoney.setSmsCode("");//雉验证码
		payMoney.setProductName("天下第一品");// 购买商品名称
		payMoney.setProductDesc("天下第一品");// 购买商品描述
		payMoney.setNotifyUrl("https://pay.masduo.com/fastpay_pay_notify");// 后台通知URL JSONObject result =
		JSONObject result = tradeExecute.tradeHttpReq(JSONObject.toJSONString(payMoney));
		return new Result<String>(result.toJSONString());
	}

	@RequestMapping("/fastpay_trade_list")
	public String tradeList(HttpSession httpSession, Model model) {
		// String openId = httpSession.getAttribute("openId") == null ? "" :
		// httpSession.getAttribute("openId").toString();
		//String openId = httpSession.getAttribute("openId").toString();
		String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
		logger.info("Session openId：" + openId);
		List<TradeLog> list = tradeLogService.select(1, 20, openId);
		model.addAttribute("tradeList", list);
		return "/tradeList";
	}

	@ResponseBody
	@RequestMapping("/fastpay_json_list")
	public List<TradeLog> jsonList(int pageNum, int pageSize, HttpSession httpSession, Model model) {
		logger.info(pageNum + "========" + pageSize);
		// String openId = httpSession.getAttribute("openId") == null ? "" :
		// httpSession.getAttribute("openId").toString();
		//String openId = httpSession.getAttribute("openId").toString();
		String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
		logger.info("Session openId：" + openId);
		List<TradeLog> list = tradeLogService.select(pageNum, pageSize, openId);
		return list;
	}

}
