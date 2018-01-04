package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.poilt.model.PayState;
import com.poilt.service.fastpay.PayStatesService;

/**
 * 支付状态
 * @author Administrator
 *
 */
@RestController
public class PayStatesController {

	private static final Logger logger = LoggerFactory.getLogger(PayStatesController.class);
	
	@Autowired
	private PayStatesService payStatesService;
	
	@RequestMapping("/fastpay_paystate")
	public JSONObject payState(@RequestBody PayState payState){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(payState));
		return payStatesService.payState(payState);
	}
	
}
