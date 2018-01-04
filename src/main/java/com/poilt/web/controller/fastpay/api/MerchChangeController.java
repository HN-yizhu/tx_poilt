package com.poilt.web.controller.fastpay.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.poilt.model.MerchChange;
import com.poilt.service.fastpay.MerchChangeService;

/**
 * 商户费率、结算卡变更
 * @author Administrator
 *
 */
@RestController
public class MerchChangeController {

	private static final Logger logger = LoggerFactory.getLogger(MerchChangeController.class);
	
	@Autowired
	private MerchChangeService merchChangeService;
	
	@RequestMapping("/fastpay_change")
	public JSONObject change(@RequestBody MerchChange change){
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(change));
		return merchChangeService.change(change);
	}
	
}
