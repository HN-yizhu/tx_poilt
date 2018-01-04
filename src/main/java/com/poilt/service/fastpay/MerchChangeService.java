package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.MerchChange;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class MerchChangeService {

	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	/**
	 * 商户费率和结算卡变更
	 * @param param
	 * @return
	 */
	public JSONObject change(MerchChange change) {
		return tradeExecute.tradeHttpReq(JSONObject.toJSONString(change));
	}
	
}
