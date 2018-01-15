package com.poilt.service.fastpay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poilt.mapper.fastpay.CardMapper;
import com.poilt.model.fastpay.Card;

import me.chanjar.weixin.common.util.RandomUtils;

@Service
public class CardService {

	@Autowired
	private CardMapper cardMapper;
	
	public Card findByCardNo(String openId, String cardNo){
		return cardMapper.findByCardNo(openId, cardNo);
	}
	
	public List<Card> findByOpenId(String openId, String useType){
		List<Card> list = cardMapper.findByOpenId(openId, useType);
		return list;
	}
	
	public int insert(Card card){
		card.setOrderNo(RandomUtils.getRandomStr());
		int count = cardMapper.insert(card);
		return count;
	}
	
}
