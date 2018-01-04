package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.CardState;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class CardStatesService {

	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	/**
	 * 卡片状态查询
	 * @param param
	 * @return
	 */
	public JSONObject cardState(CardState cardState) {
		return tradeExecute.tradeHttpReq(JSONObject.toJSONString(cardState));
	}
	
}
