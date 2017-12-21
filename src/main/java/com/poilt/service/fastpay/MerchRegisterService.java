package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.MerchRegister;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class MerchRegisterService {
	
	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	public JSONObject register(MerchRegister register) {
		return tradeExecute.tradeHttpReq(JSONObject.toJSONString(register));
	}
	
}
