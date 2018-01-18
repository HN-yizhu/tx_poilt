package com.poilt.service.fastpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.utils.RSAUtils;

@Service
public class NotifyService {
	
	private static final Logger logger = LoggerFactory.getLogger(NotifyService.class);

	@Value("${self_pri_key}")
	private String priKey;
	
	@Value("${gz_pub_key}")
	private String gzPubKey;
	
	@Async
	public void cardNotify(String reqBody) {
		try {
			JSONObject resultJson = decript(JSONObject.parseObject(reqBody));
			
		} catch (Exception e) {
			
		}
	}

	
	@Async
	public void payNotify(String reqBody) {
		
	}
	

	
	private JSONObject decript(JSONObject json) throws Exception {
		String body = RSAUtils.decryptByPrivateKey(json.getString("body"), priKey);
		logger.info("解密body明文[{}]",body);
		if(RSAUtils.verify(body.getBytes(), gzPubKey, json.getString("sign"))){
			return JSONObject.parseObject(body);
		}else{
			logger.error("通知信息验签失败，通知信息:[{}]", json.toString());
			throw new JsonException(StatusCode.SYS_ERR);
		}
	}
	
	
}
