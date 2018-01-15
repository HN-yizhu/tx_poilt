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
	
	public int insert(TradeLog trade){
		int count = tradeLogMapper.insert(trade);
		return count;
	}
	
	public int update(TradeLog trade){
		int count = tradeLogMapper.update(trade);
		return count;
	}
	
}
