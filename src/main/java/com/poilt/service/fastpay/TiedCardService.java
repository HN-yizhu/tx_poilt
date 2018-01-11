package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.mapper.fastpay.CardMapper;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.utils.TradeHttpRequestExecute;

import me.chanjar.weixin.common.util.RandomUtils;

@Service
public class TiedCardService {
	
	@Autowired
	CardMapper cardMapper;

	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	/**
	 * 银联绑卡
	 * @param param
	 * @return
	 */
	public JSONObject tiedCard(Merch merch,Card card) {
		card.setOrderNo(RandomUtils.getRandomStr());
		cardMapper.insertSelective(card);
		JSONObject merchJson = (JSONObject)JSONObject.toJSON(merch);
		JSONObject cardJson = (JSONObject)JSONObject.toJSON(card);
		merchJson.putAll(cardJson);
		return tradeExecute.tradeHttpReq(merchJson.toJSONString());
	}
	
}
