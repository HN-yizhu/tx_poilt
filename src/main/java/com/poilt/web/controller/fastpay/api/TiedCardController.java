package com.poilt.web.controller.fastpay.api;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.poilt.model.fastpay.Card;
import com.poilt.service.fastpay.TiedCardService;

/**
 * 银联绑卡
 * @author Administrator
 *
 */
@Controller
public class TiedCardController {

	private static final Logger logger = LoggerFactory.getLogger(TiedCardController.class);
	
	@Autowired
	private TiedCardService tiedCardService;
	
	@RequestMapping("/fastpay_tiedcard")
	public String tiedCard(Card card, HttpSession httpSession, Model model) throws Exception{
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(card));
		//String openId = httpSession.getAttribute("openId") == null ? "" : httpSession.getAttribute("openId").toString();
		String openId = httpSession.getAttribute("openId").toString();
		logger.info("Session openId：" + openId);
		if("".equals(openId)){
			throw new Exception("openId获取失败！");
		}else{
			card.setOpenId(openId);
			tiedCardService.tiedCard(card);
		}
		return "/index";
	}
	
}
