package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.poilt.model.CardState;
import com.poilt.model.MerchRegister;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.CardStatesService;
import com.poilt.utils.TradeHttpRequestExecute;

/**
 * 卡片状态查询
 * @author Administrator
 *
 */
@RestController
public class CardStatesController {

	private static final Logger logger = LoggerFactory.getLogger(CardStatesController.class);
	
	@Autowired
	private CardStatesService cardStatesService;
	
	@Autowired
	private TradeHttpRequestExecute tradeExecute;
	
	@RequestMapping("/fastpay_cardstate")
	public JSONObject cardState(@RequestBody CardState cardState){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(cardState));
		return cardStatesService.cardState(cardState);
	}
	
	@RequestMapping("/fastpay_test_register")
	public JSONObject register(@RequestBody MerchRegister merch){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(merch));
		JSONObject result = tradeExecute.tradeHttpReq(JSONObject.toJSONString(merch));
		return result;
	}
	
}
