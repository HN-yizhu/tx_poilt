package com.poilt.mapper.fastpay;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.poilt.model.fastpay.Card;

public interface CardMapper {

	Card findByCardNo(@Param(value = "openId") String openId, @Param(value = "cardNo") String cardNo);
	
	List<Card> findByOpenId(@Param(value = "openId") String openId, @Param(value = "useType") String useType);
	
    int insert(Card card);

    int update(Card card);
    
}