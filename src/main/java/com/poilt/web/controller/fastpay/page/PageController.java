package com.poilt.web.controller.fastpay.page;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.BankCodeService;
import com.poilt.service.fastpay.CardService;
import com.poilt.service.fastpay.MerchService;
import com.poilt.utils.WebUtils;

@Controller
public class PageController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MerchService merchService;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private BankCodeService bankCodeService;
	
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, Model model) throws Exception {
		String openId = WebUtils.getSessionValue("openId");
		model.addAttribute("payCardList", cardService.selectMap(openId));
		return "/index";
	}
	
	@RequestMapping(value = "/orderList")
	public String orderList(HttpServletRequest request, Map<String, Object> map) throws Exception {
		return "/orderList";
	}
	
	@RequestMapping(value = "/tiedCard")
	public String tiedCard(HttpServletRequest request, Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = bankCodeService.selectMap();
		map.put("bankCodeList", list);
		return "/tiedCard";
	}
	
	@RequestMapping(value = "/paysms")
	public String paysms(String orderNo, Model model) throws Exception {
		model.addAttribute("orderNo", orderNo);
		return "/paysms";
	}
	
	@RequestMapping(value = "/tiedCreditCard")
	public String tiedCreditCard(HttpServletRequest request, Map<String, Object> map) throws Exception {
		List<Map<String, Object>> list = bankCodeService.selectMap();
		map.put("bankCodeList", list);
		return "/tiedCreditCard";
	}
	
	@RequestMapping(value = "/home")
	public String home(HttpSession httpSession, Model model) throws Exception {
		String openId = WebUtils.getSessionValue("openId");
		logger.info("Session openId：" + openId);
		Merch merch = merchService.findByOpenId(openId);
		model.addAttribute("merch", merch);
		/*结算卡信息*/
		List<Card> list = cardService.findByOpenId(openId, "1");
		if(list.size() > 0){
			model.addAttribute("card", list.get(0));
		}
		return "/home";
	}
	
	@RequestMapping(value = "/success")
	public String success() throws Exception {
		return "/successMsg";
	}
	
	@RequestMapping(value = "/failed")
	public String failed() throws Exception {
		return "/failedMsg";
	}
	
	@RequestMapping(value = "/wechat/register")
	public String register(HttpServletRequest request, Map<String, Object> map) throws Exception {
		map.put("openId", "123");
		return "/register";
	}
	
}
