package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.poilt.Application;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class TxPoiltApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void fastpayRegister() throws Exception{
		JSONObject param = new JSONObject();
		param.put("bankAbbr", "CMB");
		param.put("bankAccName", "杨天雄");
		param.put("bankAccNo", "6214830216836675");
		//param.put("bankAccName", "谭国彪");
		//param.put("bankAccNo", "6225882140870236");
		param.put("bankAccType", "2");
		param.put("bankChannelNo", "66666");
		param.put("bankCity", "上海");
		param.put("bankCode", "308");
		param.put("bankName", "招商银行");
		param.put("bankProvince", "上海");
		param.put("bankSubName", "上海亿珠");
		param.put("creditCapAmount", "99999900");
		param.put("creditRate", "0.004");
		param.put("debitCapAmount", "99999900");
		param.put("debitRate", "0.004");
		param.put("idCardNo", "430821198710112632");
		//param.put("idCardNo", "430623198705113018");
		param.put("merAbbr", "一紙荒年");
		param.put("merName", "一紙荒年");
		//param.put("merAbbr", "马上多-神癫癫");
		//param.put("merName", "马上多-神癫癫");
		param.put("merTrace", "20180116233246250403");
		param.put("phoneno", "18721715632");
		//param.put("phoneno", "13651619487");
		param.put("rateCode", "1001002");
		param.put("tranType", "MERREG");
		param.put("withdRate", "0.004");
		param.put("withdSgFee", "100.0");
		RequestBuilder request = MockMvcRequestBuilders
				.post("/fastpay_test_register")
				.contentType("application/json; charset=utf-8")
				.content(param.toString());
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}
	
	@Test
	public void cardStates() throws Exception{
		JSONObject param = new JSONObject();
		param.put("tranType", "OPNCQRY");
		param.put("merNo", "10000837");
		param.put("merTrace", "20180116112332687118");
		param.put("orderId", "20180116112332687118");
		RequestBuilder request = MockMvcRequestBuilders
				.post("/fastpay_cardstate")
				.contentType("application/json; charset=utf-8")
				.content(param.toString());
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}
	
	@Test
	public void fastpayChange() throws Exception{
		JSONObject param = new JSONObject();
		param.put("tranType", "MERCHG");
		param.put("merNo", "321321321321");
		param.put("merTrace", "");
		param.put("changeType", "");
		param.put("bankAccNo", "");
		param.put("phoneno", "");
		//bankAccNo
		param.put("bankName", "");
		param.put("bankSubName", "");
		param.put("bankCode", "");
		param.put("bankAbbr", "");
		param.put("bankChannelNo", "");
		param.put("bankProvince", "");
		param.put("bankCity", "");
		param.put("rateCode", "");
		param.put("debitRate", "");
		param.put("debitCapAmount", "");
		param.put("creditRate", "");
		param.put("creditCapAmount", "");
		param.put("withdRate", "");
		param.put("withdSgFee", "");
		RequestBuilder request = MockMvcRequestBuilders
				.post("/fastpay_change")
				.contentType("application/json; charset=utf-8")
				.content(param.toString());
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}
	
	@Test
	public void fastpayMessage() throws Exception{
		JSONObject param = new JSONObject();
		param.put("tranType", "PAYMSG");
		param.put("merNo", "321321321321");
		param.put("merTrace", "");
		param.put("orderId", "");
		param.put("orderAmount", "");
		param.put("rateCode", "");
		param.put("cardNo", "");
		param.put("accountName", "");
		param.put("cardType", "");
		param.put("bankCode", "");
		param.put("bankAbbr", "");
		param.put("phoneno", "");
		param.put("certType", "");
		param.put("certNo", "");
		RequestBuilder request = MockMvcRequestBuilders
				.post("/fastpay_message")
				.contentType("application/json; charset=utf-8")
				.content(param.toString());
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}
	
	@Test
	public void fastpayPay() throws Exception{
		JSONObject param = new JSONObject();
		param.put("tranType", "CONPAY");
		param.put("merNo", "");
		param.put("merTrace", "");
		param.put("orderId", "");
		param.put("payNo", "");
		param.put("payAmount", "");
		param.put("rateCode", "");
		param.put("cardNo", "");
		param.put("accountName", "");
		param.put("cardType", "");
		param.put("bankCode", "");
		param.put("bankAbbr", "");
		param.put("phoneno", "");
		param.put("certType", "");
		param.put("certNo", "");
		param.put("smsCode", "");
		param.put("productName", "");
		param.put("productDesc", "");
		param.put("notifyUrl", "");
		RequestBuilder request = MockMvcRequestBuilders
				.post("/fastpay_pay")
				.contentType("application/json; charset=utf-8")
				.content(param.toString());
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}
	
	@Test
	public void fastpayPaystate() throws Exception{
		JSONObject param = new JSONObject();
		param.put("tranType", "PAYQRY");
		param.put("merNo", "");
		param.put("merTrace", "");
		param.put("orderId", "");
		RequestBuilder request = MockMvcRequestBuilders
				.post("/fastpay_paystate")
				.contentType("application/json; charset=utf-8")
				.content(param.toString());
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}
	
	@Test
	public void fastpayTiedcard() throws Exception{
		JSONObject param = new JSONObject();
		param.put("tranType", "POPNCD");
		param.put("merNo", "");
		param.put("merTrace", "");
		param.put("orderId", "");
		param.put("rateCode", "");
		param.put("cardNo", "");
		param.put("accountName", "");
		param.put("cardType", "");
		param.put("bankCode", "");
		param.put("bankAbbr", "");
		param.put("phoneno", "");
		param.put("certType", "");
		param.put("certNo", "");
		param.put("pageReturnUrl", "");
		param.put("offlineNotifyUrl", "");
		RequestBuilder request = MockMvcRequestBuilders
				.post("/fastpay_tiedcard")
				.contentType("application/json; charset=utf-8")
				.content(param.toString());
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}

}
