package com.poilt.service.fastpay;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poilt.enums.StatusCode;
import com.poilt.exception.JsonException;
import com.poilt.mapper.fastpay.MerchMapper;
import com.poilt.model.fastpay.Merch;
import com.poilt.model.fastpay.MerchExample;

@Service
public class MerchRegisterService {
	
	@Autowired
	MerchMapper merchMapper;
	
	public void registerOrUpdate(Merch merch) throws Exception {
		int i;
		if(merch.getId() != null) {
			i = merchMapper.updateByPrimaryKeySelective(merch);
		}else {
			merch.setCreateTime(new Date());
			merch.setCreditRate("0.004");
			merch.setCreditFee(1);
			i = merchMapper.insertSelective(merch);
		}
		if(i != 1) {
			throw new JsonException(StatusCode.SYS_DB_ERR);
		}
	}
	
	public void updateByOpenId(Merch merch) throws Exception{
		int count = merchMapper.updateByOpenId(merch);
		if(count !=1){
			throw new JsonException(StatusCode.SYS_DB_ERR);
		}
	}
	
	public Merch queryByOpenId(String openId) {
		MerchExample example = new MerchExample();
		example.createCriteria().andOpenIdEqualTo(openId);
		List<Merch> merch = merchMapper.selectByExample(example);
		if(merch.size() > 0) 
			return merch.get(0);
		else
			return null;
	}
	
	
}
