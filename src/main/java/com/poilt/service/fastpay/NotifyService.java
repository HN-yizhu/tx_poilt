package com.poilt.service.fastpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.TradeLog;
import com.poilt.utils.RSAUtils;

@Service
public class NotifyService {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${self_pri_key}")
	private String priKey;
	
	@Value("${gz_pub_key}")
	private String gzPubKey;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private TradeLogService tradeLogService;
	
	@Async
	public void cardNotify(String reqBody) {
		try {
			JSONObject resultJson = decript(JSONObject.parseObject(reqBody));
			logger.info("[绑卡通知报文请求参数]" + resultJson.toJSONString());
			String merNo = resultJson.getString("merNo") == null ? "" : resultJson.getString("merNo");
			String merTrace = resultJson.getString("merTrace") == null ? "" : resultJson.getString("merTrace");
			String orderNo = resultJson.getString("orderNo") == null ? "" : resultJson.getString("orderNo");
			String status = resultJson.getString("transStatus") == null ? "" : resultJson.getString("transStatus");
			if(!"".equals(merNo) && !"".equals(merTrace) && !"".equals(orderNo) && !"".equals(status)){
				Card card = new Card();
				card.setMerNo(merNo);
				card.setTraceNo(merTrace);
				card.setOrderNo(orderNo);
				card.setCardStatus(status);
				cardService.updateStatus(card);
			}
		} catch (Exception e) {
			logger.error("[绑卡通知接收处理异常]", e);
		}
	}

	
	@Async
	public void payNotify(String reqBody) {
		try {
			JSONObject resultJson = decript(JSONObject.parseObject(reqBody));
			logger.info("[支付通知报文请求参数]" + resultJson.toJSONString());
			String merNo = resultJson.getString("merNo") == null ? "" : resultJson.getString("merNo");
			String merTrace = resultJson.getString("merTrace") == null ? "" : resultJson.getString("merTrace");
			String orderNo = resultJson.getString("orderNo") == null ? "" : resultJson.getString("orderNo");
			String status = resultJson.getString("transStatus") == null ? "" : resultJson.getString("transStatus");
			if(!"".equals(merNo) && !"".equals(merTrace) && !"".equals(orderNo) && !"".equals(status)){
				TradeLog trade = new TradeLog();
				trade.setMerNo(merNo);
				trade.setTradeNo(merTrace);
				trade.setOrderNo(orderNo);
				trade.setStatus(status);
				tradeLogService.updateStatus(trade);
			}
		} catch (Exception e) {
			logger.error("[支付通知接收处理异常]", e);
		}
	}
	

	
	private JSONObject decript(JSONObject json) throws Exception {
		String body = RSAUtils.decryptByPrivateKey(json.getString("body"), priKey);
		logger.info("解密body明文[{}]",body);
		if(RSAUtils.verify(body.getBytes(), gzPubKey, json.getString("sign"))){
			return JSONObject.parseObject(body);
		}else{
			logger.error("通知信息验签失败，通知信息:[{}]", json.toString());
			throw new JsonException(StatusCode.SYS_ERR);
		}
	}
	
	
}
