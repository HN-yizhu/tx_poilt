package com.poilt.web.controller.fastpay.api;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.exception.Result;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.CardService;
import com.poilt.service.fastpay.MerchService;
import com.poilt.service.fastpay.TiedCardService;
import com.poilt.utils.WebUtils;

/**
 * 绑卡
 * Title: TiedCardController.java
 * Description: 
 * Date: 2018年1月16日
 * @author: TanGuobiao
 *
 */
@Controller
public class TiedCardController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TiedCardService tiedCardService;
	
	@Autowired
	private MerchService merchService;
	
	@Autowired
	private CardService cardService;
	
	@Value("${fastpay.rateCode}")
	private String rateCode;
	
	@ResponseBody
	@RequestMapping("/fastpay_tiedcard")
	public Result<String> tiedCard(Card card, HttpSession httpSession, Model model) throws JsonException{
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(card));
		try {
			String openId = WebUtils.getSessionValue("openId");
			logger.info("Session openId：" + openId);
			if("".equals(openId)){
				throw new JsonException(StatusCode.SYS_NO_OPEN_ID);
			}else{
				card.setOpenId(openId);
				tiedCardService.tiedCard(card);
			}
		} catch (JsonException e) {
			throw e;
		} catch (Exception e){
			throw new JsonException(StatusCode.SYS_ERR);
		}
		return new Result<String>("");
	}
	
	@RequestMapping("/fastpay_tiedCreditCard")
	public String tiedCreditCard(Card card, HttpServletResponse response, Model model) throws Exception{
		String openId = WebUtils.getSessionValue("openId");
		/*获取用户信息*/
		Merch merch = merchService.findByOpenId(openId);
		/*
		 * 是否绑卡 如果有绑卡记录，看下卡状态是否开通成功
		 */
		Card tiedCard = cardService.findByCardNo(openId, card.getCardNo());
		if (tiedCard == null) {
			tiedCard = new Card();
			tiedCard.setOpenId(openId);
			tiedCard.setIdCard(merch.getIdCard());
			tiedCard.setPhone(merch.getPhone());
			tiedCard.setCardNo(card.getCardNo());
			tiedCard.setCardType("2");// 信用卡
			tiedCard.setCardName(merch.getName());
			tiedCard.setBankCode(card.getBankCode());
			tiedCard.setBankAbbr(card.getBankAbbr());
			tiedCard.setBankName(card.getBankName());
			cardService.insert(tiedCard);
		}
		JSONObject result = tiedCardService.tiedCreditCard(openId, card.getCardNo());
		String respCode = result.getString("respCode");
		if("000000".equals(respCode)){
			String status = result.getJSONObject("result").getString("activateStatus");
			if("2".equals(status)){
				logger.info("[" + card.getCardNo() + "]已经开通");
			} else if("1".equals(status)){
				//如果没有开通
				String html = result.getJSONObject("result").getString("html");
				logger.info("html页面代码" + html);
				response.reset();
				response.setContentType("text/html; charset=UTF-8");
				ServletOutputStream out = response.getOutputStream();
				out.println(html);
				return null;
			} else {
				throw new Exception(StatusCode.SYS_MSG_TIED_CARD.toString());
			}
		}else{
			throw new Exception(StatusCode.SYS_PAY_ERR.toString());
		}
		model.addAttribute("payCardList", cardService.selectMap(openId));
		return "/index";
	}
	
}
















