package com.poilt.web.controller.fastpay.api;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.poilt.model.PayMoney;
import com.poilt.model.fastpay.TradeLog;
import com.poilt.service.fastpay.PayMoneyService;
import com.poilt.service.fastpay.TradeLogService;

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
	
	@Autowired
	private TradeLogService tradeLogService;
	
	
}
