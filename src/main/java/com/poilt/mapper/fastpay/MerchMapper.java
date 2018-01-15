package com.poilt.mapper.fastpay;

import org.apache.ibatis.annotations.Param;
import com.poilt.model.fastpay.Merch;

public interface MerchMapper {

	Merch findByOpenId(@Param(value = "openId") String openId);
	
    int insert(Merch merch);
    
    int update(Merch merch);
    
}