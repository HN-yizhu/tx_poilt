package com.poilt.web.controller.fastpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.poilt.model.MerchRegister;
import com.poilt.service.fastpay.MerchRegisterService;

/**
 * 商户注册
 * @author Administrator
 *
 */
@Controller
public class MerchRegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(MerchRegisterController.class);
	
	@Autowired
	MerchRegisterService payService;
	
	@ResponseBody
	@RequestMapping("/fastpay_register")
	public JSONObject register(@RequestBody MerchRegister register) {
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(register));
		return payService.register(register);
	}

}
