package com.poilt.web.controller.fastpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.TiedCard;
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
	public JSONObject tiedCard(@RequestBody TiedCard tiedCard){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(tiedCard));
		return tiedCardService.tiedCard(tiedCard);
	}
	
}
