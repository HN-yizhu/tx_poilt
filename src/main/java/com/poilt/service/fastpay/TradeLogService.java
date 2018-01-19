package com.poilt.service.fastpay;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.poilt.mapper.fastpay.TradeLogMapper;
import com.poilt.model.fastpay.TradeLog;

@Service
public class TradeLogService {

	@Autowired
	private TradeLogMapper tradeLogMapper;
	
	public List<TradeLog> select(int pageNum, int pageSize, String openId){
		PageHelper.startPage(pageNum, pageSize);
		List<TradeLog> list = tradeLogMapper.select(openId);
		return list;
	}
	
	public TradeLog findByOrderNo(String openId, String orderNo){
		return tradeLogMapper.findByOrderNo(openId, orderNo);
	}
	
	public int insert(TradeLog trade){
		int count = tradeLogMapper.insert(trade);
		return count;
	}
	
	public int update(TradeLog trade){
		int count = tradeLogMapper.update(trade);
		return count;
	}
	
	public int updateStatus(TradeLog trade){
		int count = tradeLogMapper.updateStatus(trade);
		return count;
	}

	public int updateOrderNoByOldOrderNo(String openId, String orderNo, String newOrderNo) {
		int count = tradeLogMapper.updateOrderNoByOldOrderNo(openId,orderNo,newOrderNo);
		return count;
	}
	
}
