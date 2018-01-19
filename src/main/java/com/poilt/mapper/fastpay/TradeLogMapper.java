package com.poilt.mapper.fastpay;

import com.poilt.model.fastpay.TradeLog;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeLogMapper {

	List<TradeLog> select(@Param(value = "openId") String openId);

	TradeLog findByOrderNo(@Param(value = "openId") String openId, @Param(value = "orderNo") String orderNo);

	int insert(TradeLog trade);

	int update(TradeLog trade);

	int updateStatus(TradeLog trade);

	int updateOrderNoByOldOrderNo(@Param(value = "openId") String openId, @Param(value = "orderNo") String orderNo,
			@Param(value = "newOrderNo") String newOrderNo);

}