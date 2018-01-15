package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poilt.mapper.fastpay.MerchMapper;
import com.poilt.model.fastpay.Merch;

@Service
public class MerchService {
	
	@Autowired
	MerchMapper merchMapper;
	
	public int insert(Merch merch) {
		int count = merchMapper.insert(merch);
		return count;
	}
	
	public int updateByOpenId(Merch merch) {
		int count = merchMapper.update(merch);
		return count;
	}
	
	public Merch findByOpenId(String openId) {
		Merch merch = merchMapper.findByOpenId(openId);
		return merch;
	}
	
	
}
