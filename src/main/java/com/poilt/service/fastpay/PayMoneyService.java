package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.PayMoney;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class PayMoneyService {

	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	/**
	 * 消费支付
	 * @param param
	 * @return
	 */
	public JSONObject pay(PayMoney payMoney) {
		return tradeExecute.tradeHttpReq(JSONObject.toJSONString(payMoney));
	}
	
}
