package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.PayMessage;
import com.poilt.service.fastpay.PayMessageService;

/**
 * 支付短信
 * @author Administrator
 *
 */
@RestController
public class PayMessageController {

	private static final Logger logger = LoggerFactory.getLogger(PayMessageController.class);
	
	@Autowired
	private PayMessageService payMessageService;
	
	@RequestMapping("/fastpay_message")
	public JSONObject payMessage(@RequestBody PayMessage payMessage){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(payMessage));
		return payMessageService.payMessage(payMessage);
	}
	
}
