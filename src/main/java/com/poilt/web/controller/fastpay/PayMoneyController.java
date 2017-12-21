package com.poilt.web.controller.fastpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.PayMoney;
import com.poilt.service.fastpay.PayMoneyService;

/**
 * 支付
 * @author Administrator
 *
 */
@RestController
public class PayMoneyController {

	private static final Logger logger = LoggerFactory.getLogger(PayMoneyController.class);
	
	@Autowired
	private PayMoneyService payMoneyService;
	
	@RequestMapping("/fastpay_pay")
	public JSONObject pay(@RequestBody PayMoney payMoney){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(payMoney));
		return payMoneyService.pay(payMoney);
	}
	
}
