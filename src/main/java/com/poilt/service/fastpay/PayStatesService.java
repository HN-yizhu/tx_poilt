package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.PayState;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class PayStatesService {

	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	/**
	 * 支付状态查询
	 * @param param
	 * @return
	 */
	public JSONObject payState(PayState payState) {
		return tradeExecute.tradeHttpReq(JSONObject.toJSONString(payState));
	}
	
}
