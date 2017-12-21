package com.poilt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;

@Component
public class TradeHttpRequestExecute {
	
	@Value("${gz_trade_url}")
	private String gzTradeUrl;
	
	@Value("${self_pri_key}")
	private String priKey;
	
	@Value("${gz_pub_key}")
	private String gzPubKey;
	
	@Value("${org_code}")
	private String orgCode;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(TradeHttpRequestExecute.class);
	
	public JSONObject tradeHttpReq(JSONObject param) {
		JSONObject result = new JSONObject();
		try {
			logger.info("发送HTTP请求参数:{}",param.toString());
			JSONObject jsonm = new JSONObject();
			jsonm.put("orgCode", orgCode);
			jsonm.put("sign", param.toString());
			jsonm.put("body", param.toString());
			logger.info("发送明文:" + jsonm);
			JSONObject json = new JSONObject();
			json.put("orgCode", orgCode);
			json.put("sign", RSAUtils.sign(param.toString().getBytes(), priKey));
			json.put("body", RSAUtils.encryptByPublicKey(param.toString().getBytes(),gzPubKey));
			
			logger.info("发送密文:" + json);
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
			
			String resXml = restTemplate.postForObject(gzTradeUrl, new HttpEntity<>(json, headers), String.class);
	        
			logger.info("返回结果:" + resXml);
			JSONObject resultJson = JSONObject.parseObject(resXml);
			if(resultJson != null) {
				String sign = resultJson.getString("sign");
				String body = RSAUtils.decryptByPrivateKey(resultJson.getString("body"), priKey);
				logger.info("解密body明文:{}",body);
				if(RSAUtils.verify(body.getBytes(), gzPubKey, sign)){
					result = JSONObject.parseObject(body);
				}else{
					logger.error("嘎吱返回信息验签失败，返回信息:[{}]", resultJson);
					result.put("respCode","001");
					result.put("respInfo","通道返回错误");
				}
			}else {
				logger.error("通道未返回信息");
				result.put("respCode","001");
				result.put("respInfo","通道未返回信息");
			}
		} catch (Exception e) {
			result.put("respCode","001");
			result.put("respInfo","通道返回错误");
			logger.error("通道返回错误", e);
		}
		return result;
	}
}
