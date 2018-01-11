package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.TiedCardService;

/**
 * 银联绑卡
 * @author Administrator
 *
 */
@RestController
public class TiedCardController {

	private static final Logger logger = LoggerFactory.getLogger(TiedCardController.class);
	
	@Autowired
	private TiedCardService tiedCardService;
	
	@RequestMapping("/fastpay_tiedcard")
	public JSONObject tiedCard(@SessionAttribute Merch merch,@RequestBody Card card){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(card));
		return tiedCardService.tiedCard(merch,card);
	}
	
}
