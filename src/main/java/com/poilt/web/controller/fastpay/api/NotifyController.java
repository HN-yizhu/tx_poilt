package com.poilt.web.controller.fastpay.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NotifyController {

	/**
	 * 绑卡通知
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/fastpay_card_notify")
	public String cardNotify(){
		
		return "SUCCESS";
	}
	
	/**
	 * 支付通知
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/fastpay_pay_notify")
	public String payNotify(){
		
		return "SUCCESS";
	}
	
	
}
