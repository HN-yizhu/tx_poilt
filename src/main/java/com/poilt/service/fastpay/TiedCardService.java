package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.TiedCard;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class TiedCardService {

	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	/**
	 * 银联绑卡
	 * @param param
	 * @return
	 */
	public JSONObject tiedCard(TiedCard tiedCard) {
		return tradeExecute.tradeHttpReq(JSONObject.toJSONString(tiedCard));
	}
	
}
