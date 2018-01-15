package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.poilt.model.fastpay.Card;
import com.poilt.model.fastpay.Merch;
import com.poilt.utils.TradeHttpRequestExecute;

@Service
public class TiedCardService {
	
	@Autowired
	TradeHttpRequestExecute tradeExecute;
	
	@Autowired
	private CardService cardService;
	
	@Autowired
	private MerchService merchService;
	
	/**
	 * 结算卡
	 * @param param
	 * @return
	 * @throws Exception 
	 */
	@Transactional
	public void tiedCard(Card card) {
		Merch user = merchService.findByOpenId(card.getOpenId());
		card.setIdCard(user.getIdCard());
		card.setPhone(user.getPhone());
		card.setCardName(user.getName());
		card.setCardType("1");
		card.setUseType("2");
		cardService.insert(card);
		Merch merch = new Merch();
		merch.setOpenId(card.getOpenId());
		merch.setTiedCard("Y");
		merchService.updateByOpenId(merch);
	}
	
	/**
	 * 信用卡
	 * @param card
	 * @return
	 */
	public int tiedCreditCard(Card card) {
		Merch user = merchService.findByOpenId(card.getOpenId());
		card.setIdCard(user.getIdCard());
		card.setPhone(user.getPhone());
		card.setCardName(user.getName());
		card.setUseType("1");
		return cardService.insert(card);
	}
	
}
