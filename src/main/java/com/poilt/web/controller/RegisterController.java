package com.poilt.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poilt.pojo.User;
import com.poilt.service.RegisterService;

@Controller
public class RegisterController {
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@Autowired
	private RegisterService registerService;
	
	@ResponseBody
	@RequestMapping("register")
	public String register(User user) {
		logger.info("-------用户注册调用--------");
		registerService.register(user);
		return "";
	}
}
