package com.poilt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class PayService {
	
	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	public JSONObject orderPay(JSONObject param) {
		param.put("tranType", "MERREG");
		param.put("merTrace", "321321321321");
		param.put("merName", "亿珠测试");
		param.put("merAbbr", "YZ");
		param.put("rateCode", "1001002");
		param.put("idCardNo", "430821198801262345");
		//bankAccNo
		param.put("bankAccNo", "123456789");
		param.put("phoneno", "62289998323432");
		param.put("bankAccName", "谭国");
		param.put("bankAccType", "1");
		param.put("bankName", "中国农业银行");
		param.put("bankSubName", "上海市武定路支行");
		param.put("bankCode", "103");
		param.put("bankAbbr", "ABC");
		param.put("bankChannelNo", "231232132");
		param.put("bankProvince", "21");
		param.put("bankCity", "21");
		param.put("debitRate", "0");
		param.put("debitCapAmount", "0");
		param.put("creditRate", "0.003");
		param.put("creditCapAmount", "0");
		param.put("withdRate", "0");
		param.put("withdSgFee", "0");
		return tradeExecute.tradeHttpReq(param);
		//return null;
	}
}
