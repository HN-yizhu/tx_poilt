package com.poilt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.poilt.service.PayService;

@Controller
public class PayController {
	
	@Autowired
	PayService payService;
	
	@ResponseBody
	@RequestMapping("orderPay")
	public JSONObject pay() {
		JSONObject json = new JSONObject();
		return payService.orderPay(json);
		//return json;
	}

}
