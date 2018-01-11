package com.poilt.web.controller.fastpay.page;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.chanjar.weixin.mp.api.WxMpService;

@Controller
public class PageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private WxMpService wxMpService;
	
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
		
		// 临时ticket
		/*WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(scene, expire_seconds);
		// 永久ticket
		WxMpQrCodeTicket ticket = wxMpService.getQrcodeService().qrCodeCreateLastTicket(scene);
		*/
		return "/home";
	}
	
	@RequestMapping(value = "/wechat/register")
	public String register(HttpServletRequest request, Map<String, Object> map) throws Exception {
		return "/register";
	}
	
}
