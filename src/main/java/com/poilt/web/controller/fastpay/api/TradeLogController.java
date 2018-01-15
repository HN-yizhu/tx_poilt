package com.poilt.web.controller.fastpay.api;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.poilt.exception.Result;
import com.poilt.model.PayMessage;
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

	@ResponseBody
	@RequestMapping("/fastpay_pay")
	public Result<String> pay(@RequestBody TradeLog trade, HttpSession httpSession) {
		// String openId = httpSession.getAttribute("openId") == null ? "" :
		// httpSession.getAttribute("openId").toString();
		// String openId = httpSession.getAttribute("openId").toString();
		String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
		logger.info("Session openId：" + openId);
		Merch merch = merchService.findByOpenId(openId);
		/* 交易记录 */
		trade.setOpenId(openId);
		String tradeNo = Serialnumber.getSerial();
		/*记录交易流水号*/
		httpSession.setAttribute("tradeNo", tradeNo);
		trade.setTradeNo(tradeNo);
		trade.setUserName(merch.getName());
		trade.setIdCard(merch.getIdCard());
		trade.setStatus("0");
		tradeLogService.insert(trade);
		/*
		 * 是否绑卡 如果有绑卡记录，看下卡状态是否开通成功
		 */
		Card card = cardService.findByCardNo(openId, trade.getPayCardNo());
		String[] bankCodes = trade.getBankCode().split(",");
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
		/* 发起支付短信 */
		/*
		 * PayMessage message = new PayMessage();
		 * message.setTranType("PAYMSG");//交易码 message.setMerNo("");//合作商户编号
		 * message.setMerTrace("");//商户流水 message.setOrderId("");//支付订单号
		 * message.setOrderAmount("");//订单金额(分) message.setRateCode("");//费率编号
		 * message.setCardNo("");//银行卡卡号 message.setAccountName("");//银行卡姓名
		 * message.setCardType("");//银行卡类型(1、借记卡，2、信用卡)
		 * message.setBankCode("");//银行代码 message.setBankAbbr("");//银行代号
		 * message.setPhoneno("");//预留手机 message.setCertType("");//01、身份证
		 * message.setCertNo("");//证件号码 JSONObject result =
		 * tradeExecute.tradeHttpReq(JSONObject.toJSONString(message));
		 */

		/*
		 * PayMoney payMoney = new PayMoney(); payMoney.setTranType("CONPAY");
		 * payMoney.setMerNo("");//合作商户编号 payMoney.setMerTrace("");//商户流水号
		 * payMoney.setOrderId("");//支付订单号 payMoney.setPayNo("");//支付流水号
		 * payMoney.setPayAmount("");//支付金额(分)
		 * payMoney.setRateCode("");//合作商户费率编号 payMoney.setCardNo("");//银行卡卡号
		 * payMoney.setAccountName("");//银行卡姓名 payMoney.setCardType("");//银行卡类型
		 * payMoney.setBankCode("");//银行代码 payMoney.setBankAbbr("");//银行代号
		 * payMoney.setPhoneno("");//预留手机
		 * payMoney.setCertType("01");//证件类型(01:身份证)
		 * payMoney.setCertNo("");//证件号码 payMoney.setSmsCode("");//雉验证码
		 * payMoney.setProductName("");//购买商品名称
		 * payMoney.setProductDesc("");//购买商品描述
		 * payMoney.setNotifyUrl("");//后台通知URL JSONObject result =
		 * tradeExecute.tradeHttpReq(JSONObject.toJSONString(payMoney));
		 */
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
		TradeLog tradeLog = tradeLogService.findByTradeNo(openId, tradeNo);
		PayMessage message = new PayMessage();
		message.setTranType("PAYMSG");// 交易码
		message.setMerNo(merch.getMerNo());// 合作商户编号
		message.setMerTrace(tradeNo);// 商户流水
		message.setOrderId(Serialnumber.getSerial());// 支付订单号
		message.setOrderAmount(tradeLog.getTradeAmt()*100 + "");// 订单金额(分)
		message.setRateCode("1001002");// 费率编号
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
