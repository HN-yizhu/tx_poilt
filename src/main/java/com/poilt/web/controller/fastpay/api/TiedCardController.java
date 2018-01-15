package com.poilt.web.controller.fastpay.api;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.exception.Result;
import com.poilt.model.TiedCard;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.service.fastpay.MerchService;
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
	
	@Autowired
	private MerchService merchService;
	
	@ResponseBody
	@RequestMapping("/fastpay_tiedcard")
	public Result<String> tiedCard(Card card, HttpSession httpSession, Model model) throws JsonException{
		logger.info("[接收到实体]\r\n{}", JSONObject.toJSONString(card));
		try {
			//String openId = httpSession.getAttribute("openId") == null ? "" : httpSession.getAttribute("openId").toString();
			//String openId = httpSession.getAttribute("openId").toString();
			String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
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
	
	@ResponseBody
	@RequestMapping("/fastpay_tiedCreditCard")
	public Result<String> tiedCreditCard(String cvn2, String expired) throws JsonException{
		try {
			//String openId = httpSession.getAttribute("openId") == null ? "" : httpSession.getAttribute("openId").toString();
			//String openId = httpSession.getAttribute("openId").toString();
			String openId = "o1ZZ61qoovpSAhCjrk144BUc6NLY";
			/*获取用户信息*/
			Merch user = merchService.findByOpenId(openId);
			
			TiedCard card = new TiedCard();
			card.setTranType("POPNCD");
			card.setMerNo(user.getMerNo());
			card.setMerTrace("");
			card.setOrderId("");
			card.setRateCode("");
			card.setCardNo("");
			card.setAccountName("");
			card.setCardType("");
			card.setBankCode("");
			card.setBankAbbr("");
			card.setPhoneno(user.getPhone());
			card.setCvn2(cvn2);
			card.setExpired(expired);
			card.setCertType("01");
			card.setCertNo(user.getIdCard());
			card.setPageReturnUrl("");
			card.setOfflineNotifyUrl("");
		} catch (Exception e) {
			throw new JsonException(StatusCode.SYS_ERR);
		}
		return new Result<String>("");
	}
	
}
















