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
	
	public JSONObject tradeHttpReq(String param) {
		JSONObject result = new JSONObject();
		try {
			logger.info("发送HTTP请求参数[{}]",param);
			JSONObject json = new JSONObject();
			json.put("orgCode", orgCode);
			json.put("sign", RSAUtils.sign(param.getBytes(), priKey));
			json.put("body", RSAUtils.encryptByPublicKey(param.getBytes(),gzPubKey));
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			//restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
			logger.info("[发送密文]\r\n" + json);
			String resXml = restTemplate.postForObject(gzTradeUrl, new HttpEntity<>(json, headers), String.class);
			logger.info("[返回结果]\r\n" + resXml);
			JSONObject resultJson = JSONObject.parseObject(resXml);
			if(resultJson != null) {
				String sign = resultJson.getString("sign");
				String body = RSAUtils.decryptByPrivateKey(resultJson.getString("body"), priKey);
				logger.info("解密body明文[{}]",body);
				if(RSAUtils.verify(body.getBytes(), gzPubKey, sign)){
					result = JSONObject.parseObject(body);
				}else{
					result.put("respCode","001");
					result.put("respInfo","通道返回错误");
					logger.error("返回信息验签失败，返回信息:[{}]", resultJson);
				}
			}else {
				result.put("respCode","001");
				result.put("respInfo","通道未返回信息");
				logger.error("通道未返回信息");
			}
		} catch (Exception e) {
			result.put("respCode","001");
			result.put("respInfo","通道返回错误");
			logger.error("[通道返回错误]\r\n", e);
		}
		return result;
	}
}
