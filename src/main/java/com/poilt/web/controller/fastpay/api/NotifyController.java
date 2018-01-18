package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poilt.service.fastpay.NotifyService;

@Controller
public class NotifyController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	NotifyService notifyService;
	
	/**
	 * 绑卡通知
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/fastpay_card_notify")
	public String cardNotify(@RequestBody String reqBody){
		logger.info("[绑卡异步通知]" + reqBody);
		notifyService.cardNotify(reqBody);
		return "SUCCESS";
	}
	
	/**
	 * 支付通知
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/fastpay_pay_notify")
	public String payNotify(@RequestBody String reqBody){
		logger.info("[支付异步通知]" + reqBody);
		notifyService.payNotify(reqBody);
		return "SUCCESS";
	}
	
	
}
