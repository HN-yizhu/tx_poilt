package com.poilt.service.fastpay;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poilt.mapper.fastpay.BankCodeMapper;
import com.poilt.model.fastpay.BankCode;

@Service
public class BankCodeService {
	
	@Autowired
	private BankCodeMapper bankCodeMapper;
	
	public BankCode findByBankCode(String bankCode){
		return bankCodeMapper.findByBankCode(bankCode);
	}
	
	public List<BankCode> select(){
		return bankCodeMapper.select();
	}
	
	public List<Map<String, Object>> selectMap(){
		return bankCodeMapper.selectMap();
	}

}
