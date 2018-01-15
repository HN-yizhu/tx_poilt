package com.poilt.web.controller.fastpay.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.model.fastpay.TradeLog;
import com.poilt.service.fastpay.CardService;
import com.poilt.service.fastpay.MerchService;
import com.poilt.service.fastpay.TradeLogService;

@Controller
public class TradeLogController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MerchService merchService;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private TradeLogService tradeLogService;
	
	@ResponseBody
	@RequestMapping("/fastpay_pay")
	public Map<String, Object> pay(@RequestBody TradeLog trade, HttpSession httpSession) throws InterruptedException{
		 Map<String, Object> map = new HashMap<String, Object>();
		//String openId = httpSession.getAttribute("openId") == null ? "" : httpSession.getAttribute("openId").toString();
		String openId = httpSession.getAttribute("openId").toString();
		logger.info("Session openId：" + openId);
		Merch merch = merchService.findByOpenId(openId);
		/* 是否绑卡
		 * 如果有绑卡记录，看下卡状态是否开通成功
		 * */
		Card card = cardService.findByCardNo(openId, trade.getPayCardNo());
		if(card == null){
			card = new Card();
			card.setOpenId(openId);
			card.setIdCard(merch.getIdCard());
			card.setPhone(merch.getPhone());
			card.setCardNo(trade.getPayCardNo());
			card.setCardType("2");//信用卡
			card.setCardName(merch.getName());
			card.setBankName(trade.getBankName());
			cardService.insert(card);
			/*去银联绑卡*/
		}
		/*交易记录*/
		trade.setOpenId(openId);
		trade.setTradeNo("11111111");
		trade.setUserName(merch.getName());
		trade.setIdCard(merch.getIdCard());
		trade.setStatus("0");
		tradeLogService.insert(trade);
		/*发起支付*/
		
		map.put("result", true);
		return map;
	}
	
	@RequestMapping("/fastpay_trade_list")
	public String tradeList(HttpSession httpSession, Model model){
		//String openId = httpSession.getAttribute("openId") == null ? "" : httpSession.getAttribute("openId").toString();
		String openId = httpSession.getAttribute("openId").toString();
		logger.info("Session openId：" + openId);
		List<TradeLog> list = tradeLogService.select(1, 20, openId);
		model.addAttribute("tradeList", list);
		return "/tradeList";
	}
	
	@ResponseBody
	@RequestMapping("/fastpay_json_list")
	public List<TradeLog> jsonList(int pageNum, int pageSize, HttpSession httpSession, Model model){
		logger.info(pageNum + "========" + pageSize);
		//String openId = httpSession.getAttribute("openId") == null ? "" : httpSession.getAttribute("openId").toString();
		String openId = httpSession.getAttribute("openId").toString();
		logger.info("Session openId：" + openId);
		List<TradeLog> list = tradeLogService.select(pageNum, pageSize, openId);
		return list;
	}
	
}
