package com.poilt.mapper.fastpay;

import com.poilt.pojo.User;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    
	User queryUserByWxid(@Param("wxId") String wxId);
	
	int addUser(User user);
	
	int modifyUser(User user);
	
	List<User> queryUser();
	
}