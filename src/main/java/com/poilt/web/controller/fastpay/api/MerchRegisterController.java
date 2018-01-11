package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.exception.Result;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.MerchRegisterService;

/**
 * 商户注册
 * 
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
	public Result<String> register(@RequestBody Merch merch) throws JsonException {
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(merch));
		try {
			payService.registerOrUpdate(merch);
		} catch (JsonException e) {
			logger.error("", e);
			throw e;
		} catch (Exception e) {
			logger.error("", e);
			throw new JsonException(StatusCode.SYS_ERR);
		}
		return new Result<String>("");
	}

}
