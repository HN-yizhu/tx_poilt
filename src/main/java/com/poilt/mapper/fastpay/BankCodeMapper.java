package com.poilt.mapper.fastpay;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.poilt.model.fastpay.BankCode;

public interface BankCodeMapper {
	
	BankCode findByBankCode(@Param(value = "bankCode") String bankCode);
	
	List<BankCode> select();
	
	List<Map<String, Object>> selectMap();
	
}