package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.PayMessage;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class PayMessageService {

	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	/**
	 * 支付短信
	 * @param param
	 * @return
	 */
	public JSONObject payMessage(PayMessage payMessage) {
		return tradeExecute.tradeHttpReq(JSONObject.toJSONString(payMessage));
	}
	
}
