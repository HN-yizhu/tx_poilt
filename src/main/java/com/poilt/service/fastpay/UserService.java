package com.poilt.service.fastpay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poilt.mapper.fastpay.UserMapper;
import com.poilt.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User queryUserByWxid(String wxId){
		return userMapper.queryUserByWxid(wxId);
	}
	
	
}
