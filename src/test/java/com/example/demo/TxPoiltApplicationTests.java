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
	public void pay() throws Exception{
		RequestBuilder request = MockMvcRequestBuilders.post("/orderPay");
		
		MvcResult mvcResult = mockMvc.perform(request).andReturn();
		int status = mvcResult.getResponse().getStatus();
		String content = mvcResult.getResponse().getContentAsString();
		TestCase.assertTrue("正确:",status == 200);
		TestCase.assertFalse("错误:",status != 200);
		System.out.println("返回结果:" + status);
		System.out.println(content);
	}

}
