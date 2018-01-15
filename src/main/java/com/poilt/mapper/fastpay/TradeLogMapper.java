package com.poilt.mapper.fastpay;

import com.poilt.model.fastpay.TradeLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeLogMapper {

	List<TradeLog> select(@Param(value = "openId") String openId);
	
	TradeLog findByTradeNo(@Param(value = "openId") String openId, @Param(value = "tradeNo") String tradeNo);
	
    int insert(TradeLog trade);

    int update(TradeLog trade);
    
}