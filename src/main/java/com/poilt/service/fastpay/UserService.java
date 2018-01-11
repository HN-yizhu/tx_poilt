package com.poilt.service.fastpay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poilt.mapper.fastpay.MerchMapper;
import com.poilt.model.fastpay.Merch;
import com.poilt.model.fastpay.MerchExample;

@Service
public class UserService {

	@Autowired
	private MerchMapper userMapper;

	public Merch queryUserByWxid(String wxId) {
		MerchExample example = new MerchExample();
		example.createCriteria().andOpenIdEqualTo(wxId);
		List<Merch> users = userMapper.selectByExample(example);
		return users.size() > 0 ? users.get(0) : new Merch();
	}

}
