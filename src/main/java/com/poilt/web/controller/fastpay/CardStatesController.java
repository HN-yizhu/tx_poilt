package com.poilt.web.controller.fastpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.poilt.model.CardState;
import com.poilt.service.fastpay.CardStatesService;

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
	
	@RequestMapping("/fastpay_cardstate")
	public JSONObject cardState(@RequestBody CardState cardState){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(cardState));
		return cardStatesService.cardState(cardState);
	}
	
}
