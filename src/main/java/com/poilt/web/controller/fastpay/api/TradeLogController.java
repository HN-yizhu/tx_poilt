package com.poilt.web.controller.fastpay.api;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.exception.Result;
import com.poilt.model.PayMessage;
import com.poilt.model.PayMoney;
import com.poilt.model.PayState;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.model.fastpay.TradeLog;
import com.poilt.service.fastpay.CardService;
import com.poilt.service.fastpay.MerchService;
import com.poilt.service.fastpay.TradeLogService;
import com.poilt.utils.Serialnumber;
import com.poilt.utils.TradeHttpRequestExecute;
import com.poilt.utils.WebUtils;

@Controller
public class TradeLogController {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private MerchService merchService;

	@Autowired
	private TradeLogService tradeLogService;

	@Autowired
	private TradeHttpRequestExecute tradeExecute;
	
	@Autowired
	private CardService cardService;
	
	@Value("${fastpay.rateCode}")
	private String rateCode;
	
	@Value("${fastpay.payNotifyUrl}")
	private String payNotifyUrl;

	@ResponseBody
	@RequestMapping("/fastpay_start_pay")
	public Result<String> startPay(TradeLog trade, HttpSession httpSession, HttpServletResponse response, Model model) throws JsonException {
		try {
			String openId = WebUtils.getSessionValue("openId");
			logger.info("Session openId：" + openId);
			/*是否已绑结算卡*/
			Merch merch = merchService.findByOpenId(openId);
			String tiedCard = merch.getTiedCard();
			if(tiedCard == null || "N".equals(tiedCard) || "".equals(tiedCard)){
				throw new JsonException(StatusCode.SYS_TIED_CARD);
			}
			/*查看卡片状态是否绑定*/
			Card card = cardService.findByCardNo(openId, trade.getPayCardNo());
			if(!"2".equals(card.getCardStatus())){
				throw new JsonException(StatusCode.TX_PAY_CARD_NOT_TIED);
			}
			String orderNo = Serialnumber.getSerial();
			/*记录交易订单号*/
			httpSession.setAttribute("orderNo", orderNo);
			model.addAttribute("orderNo", orderNo);
			/*记录交易流水*/
			trade.setMerNo(merch.getMerNo());
			trade.setOpenId(openId);
			//trade.setTradeNo(Serialnumber.getSerial());
			trade.setOrderNo(orderNo);
			trade.setUserName(merch.getName());
			trade.setIdCard(merch.getIdCard());
			trade.setBankCode(trade.getBankCode());
			trade.setBankAbbr(trade.getBankAbbr());
			trade.setStatus("0");//待支付
			tradeLogService.insert(trade);
			logger.info("支付订单号：" + orderNo);
			/*发送短信验证码*/
			TradeLog tradeLog = tradeLogService.findByOrderNo(openId, orderNo);
			PayMessage message = new PayMessage();
			message.setTranType("PAYMSG");// 交易码
			message.setMerNo(merch.getMerNo());// 合作商户编号
			message.setMerTrace(Serialnumber.getSerial());// 商户流水
			message.setOrderId(orderNo);// 支付订单号
			String tradeAmt = tradeLog.getTradeAmt()*100 + "";
			logger.info("支付金额：" + tradeAmt);
			message.setOrderAmount(tradeAmt);// 订单金额(分)
			message.setRateCode(rateCode);// 费率编号
			message.setCardNo(tradeLog.getPayCardNo());// 银行卡卡号
			message.setAccountName(tradeLog.getUserName());// 银行卡姓名
			message.setCardType("2");// 银行卡类型(1、借记卡，2、信用卡)
			message.setBankCode(tradeLog.getBankCode());// 银行代码
			message.setBankAbbr(tradeLog.getBankAbbr());// 银行代号
			message.setPhoneno(merch.getPhone());// 预留手机
			message.setCertType("01");// 01、身份证
			message.setCertNo(merch.getIdCard());// 证件号码
			JSONObject msgResult = tradeExecute.tradeHttpReq(JSONObject.toJSONString(message));
			if(!"000000".equals(msgResult.getString("respCode"))){
				throw new JsonException(StatusCode.SYS_SEND_MSG_ERR);
			}else{
				String code = msgResult.getJSONObject("result").getString("resultCode");
				if(!"000000".equals(code)){
					/*记录支付流水号(短信接口返回)*/
					String orderId = msgResult.getJSONObject("result").getString("orderId");
					String payNo = msgResult.getJSONObject("result").getString("payNo");
					TradeLog msgTrade = new TradeLog();
					msgTrade.setOpenId(openId);
					msgTrade.setOrderNo(orderId);
					msgTrade.setPayNo(payNo);
					msgTrade.setStatus("5");
					tradeLogService.update(msgTrade);
					String codeMsg = msgResult.getJSONObject("result").getString("resultMsg");
					return new Result<String>(code, codeMsg, "");
				}else{
					/*记录支付流水号(短信接口返回)*/
					String orderId = msgResult.getJSONObject("result").getString("orderId");
					String payNo = msgResult.getJSONObject("result").getString("payNo");
					TradeLog msgTrade = new TradeLog();
					msgTrade.setOpenId(openId);
					msgTrade.setOrderNo(orderId);
					msgTrade.setPayNo(payNo);
					tradeLogService.update(msgTrade);
					return new Result<String>(merch.getPhone());
				}
			}
		} catch(JsonException e){
			logger.error("", e);
			throw e;
		} catch (Exception e) {
			logger.error("", e);
			throw new JsonException(StatusCode.SYS_PAY_ERR);
		}
//		return new Result<String>("");
	}

	/**
	 * 支付短信(重发短信需要重新生成订单号)
	 * @throws JsonException 
	 */
	@ResponseBody
	@RequestMapping("/fastpay_pay_sms")
	public Result<String> paySms(String orderNo, HttpSession httpSession) throws JsonException {
		try {
			String openId = WebUtils.getSessionValue("openId");
			logger.info("Session openId：" + openId);
			Merch merch = merchService.findByOpenId(openId);
			if(null == orderNo || "".equals(orderNo)){
				orderNo = httpSession.getAttribute("orderNo").toString();
			}
			String newOrderNo = Serialnumber.getSerial();
			tradeLogService.updateOrderNoByOldOrderNo(openId,orderNo,newOrderNo);
			httpSession.setAttribute("orderNo", newOrderNo);
			
			logger.info("支付订单号：" + newOrderNo);
			TradeLog tradeLog = tradeLogService.findByOrderNo(openId, newOrderNo);
			PayMessage message = new PayMessage();
			message.setTranType("PAYMSG");// 交易码
			message.setMerNo(merch.getMerNo());// 合作商户编号
			message.setMerTrace(Serialnumber.getSerial());// 商户流水
			message.setOrderId(newOrderNo);// 支付订单号
			String tradeAmt = tradeLog.getTradeAmt()*100 + "";
			logger.info("支付金额：" + tradeAmt);
			message.setOrderAmount(tradeAmt);// 订单金额(分)
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
			if(!"000000".equals(result.getString("respCode"))){
				throw new JsonException(StatusCode.SYS_SEND_MSG_ERR);
			}else{
				String code = result.getJSONObject("result").getString("resultCode");
				if(!"000000".equals(code)){
					/*记录支付流水号(短信接口返回)*/
					String orderId = result.getJSONObject("result").getString("orderId");
					String payNo = result.getJSONObject("result").getString("payNo");
					TradeLog msgTrade = new TradeLog();
					msgTrade.setOpenId(openId);
					msgTrade.setOrderNo(orderId);
					msgTrade.setPayNo(payNo);
					msgTrade.setStatus("5");
					tradeLogService.update(msgTrade);
					String codeMsg = result.getJSONObject("result").getString("resultMsg");
					return new Result<String>(code, codeMsg, "");
				}else{
					/*记录支付流水号(短信接口返回)*/
					String orderId = result.getJSONObject("result").getString("orderId");
					String payNo = result.getJSONObject("result").getString("payNo");
					TradeLog msgTrade = new TradeLog();
					msgTrade.setOpenId(openId);
					msgTrade.setOrderNo(orderId);
					msgTrade.setPayNo(payNo);
					tradeLogService.update(msgTrade);
				}
			}
			return new Result<String>(result.toJSONString());
		} catch (JsonException e) {
			logger.error("[发送短信异常]", e);
			throw e;
		} catch (Exception e) {
			logger.error("", e);
			throw new JsonException(StatusCode.SYS_ERR);
		}
	}
	
	@ResponseBody
	@RequestMapping("/fastpay_pay")
	public Result<String> pay(String orderNo, String smsCode, HttpSession httpSession) throws JsonException {
		try {
			String openId = WebUtils.getSessionValue("openId");
			Merch merch = merchService.findByOpenId(openId);
			if(null == orderNo || "".equals(orderNo)){
				orderNo = httpSession.getAttribute("orderNo").toString();
			}
			logger.info("支付订单号：" + orderNo);
			String merTrace = Serialnumber.getSerial();
			TradeLog tradeLog = tradeLogService.findByOrderNo(openId, orderNo);
			PayMoney payMoney = new PayMoney();
			payMoney.setTranType("CONPAY");
			payMoney.setMerNo(merch.getMerNo());// 合作商户编号
			payMoney.setMerTrace(merTrace);//商户流水号
			payMoney.setOrderId(orderNo);// 支付订单号 
			payMoney.setPayNo(tradeLog.getPayNo());//支付流水号
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
			payMoney.setSmsCode(smsCode);//雉验证码
			payMoney.setProductName("上海嘎吱");// 购买商品名称
			payMoney.setProductDesc("上海嘎吱");// 购买商品描述
			payMoney.setNotifyUrl(payNotifyUrl);// 后台通知URL
			/*发交易前修改状态为处理中以及流水号*/
			TradeLog trade = new TradeLog();
			trade.setOpenId(openId);
			trade.setOrderNo(orderNo);
			trade.setTradeNo(merTrace);
			trade.setStatus("1");
			tradeLogService.update(trade);
			JSONObject result = tradeExecute.tradeHttpReq(JSONObject.toJSONString(payMoney));
			if(!"000000".equals(result.getString("respCode"))){
				TradeLog errTrade = new TradeLog();
				errTrade.setOpenId(openId);
				errTrade.setOrderNo(orderNo);
				errTrade.setStatus("5");
				tradeLogService.update(errTrade);
				throw new JsonException(StatusCode.SYS_PAY_ERR);
			}else{
				/*成功不做处理,成功会有通知推送过来*/
				if(!"000000".equals(result.getJSONObject("result").getString("resultCode"))){
					String orderId = result.getJSONObject("result").getString("orderId");
					TradeLog errTrade = new TradeLog();
					errTrade.setOpenId(openId);
					errTrade.setOrderNo(orderId);
					errTrade.setStatus("5");
					tradeLogService.update(errTrade);
					throw new JsonException(StatusCode.SYS_PAY_ERR);
				}else{
					/*接口查询交易状态*/
					PayState payState = new PayState();
					payState.setTranType("PAYQRY");
					payState.setMerNo(merch.getMerNo());
					payState.setMerTrace(merTrace);
					payState.setOrderId(orderNo);
					JSONObject stateResult = tradeExecute.tradeHttpReq(JSONObject.toJSONString(payState));
					if("000000".equals(stateResult.getString("respCode"))){
						String merNo = stateResult.getJSONObject("result").getString("merNo");
						orderNo = stateResult.getJSONObject("result").getString("orderId");
						String status = stateResult.getJSONObject("result").getString("orderStatus");
						TradeLog stateTrade = new TradeLog();
						stateTrade.setMerNo(merNo);
						stateTrade.setTradeNo(merTrace);
						stateTrade.setOrderNo(orderNo);
						stateTrade.setStatus(status);
						tradeLogService.updateStatus(stateTrade);
					}
				}
			}
			httpSession.setAttribute("orderNo", "");
			return new Result<String>(result.toJSONString());
		} catch (JsonException e) {
			logger.error("[支付异常]", e);
			throw e;
		} catch (Exception e) {
			logger.error("", e);
			throw new JsonException(StatusCode.SYS_ERR);
		}
	}

	@RequestMapping("/fastpay_trade_list")
	public String tradeList(HttpSession httpSession, Model model) {
		String openId = WebUtils.getSessionValue("openId");
		logger.info("Session openId：" + openId);
		List<TradeLog> list = tradeLogService.select(1, 20, openId);
		model.addAttribute("tradeList", list);
		return "/tradeList";
	}

	@ResponseBody
	@RequestMapping("/fastpay_json_list")
	public List<TradeLog> jsonList(int pageNum, int pageSize, HttpSession httpSession, Model model) {
		String openId = WebUtils.getSessionValue("openId");
		logger.info("Session openId：" + openId);
		List<TradeLog> list = tradeLogService.select(pageNum, pageSize, openId);
		return list;
	}

}
