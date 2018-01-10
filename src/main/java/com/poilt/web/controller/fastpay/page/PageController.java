package com.poilt.web.controller.fastpay.page;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, Map<String, Object> map) throws Exception {
		return "/index";
	}
	
	@RequestMapping(value = "/orderList")
	public String orderList(HttpServletRequest request, Map<String, Object> map) throws Exception {
		return "/orderList";
	}
	
	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request, Map<String, Object> map) throws Exception {
		return "/home";
	}
	
	@RequestMapping(value = "/wechat/register")
	public String register(HttpServletRequest request, Map<String, Object> map) throws Exception {
		return "/register";
	}
	
}
