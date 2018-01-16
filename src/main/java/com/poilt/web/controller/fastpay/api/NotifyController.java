package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.poilt.model.CardNotify;

@Controller
public class NotifyController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 绑卡通知
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/fastpay_card_notify")
	public String cardNotify(CardNotify cardNotify){
		logger.info("[绑卡异步通知]" + cardNotify.toString());
		return "SUCCESS";
	}
	
	/**
	 * 支付通知
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/fastpay_pay_notify")
	public String payNotify(CardNotify cardNotify){
		logger.info("[支付异步通知]" + cardNotify.toString());
		return "SUCCESS";
	}
	
	
}
