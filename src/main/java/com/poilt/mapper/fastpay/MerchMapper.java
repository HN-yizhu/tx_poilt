package com.poilt.mapper.fastpay;

import com.poilt.model.fastpay.Merch;
import com.poilt.model.fastpay.MerchExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MerchMapper {
    int countByExample(MerchExample example);

    int deleteByExample(MerchExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Merch record);

    int insertSelective(Merch record);

    List<Merch> selectByExample(MerchExample example);

    Merch selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Merch record, @Param("example") MerchExample example);

    int updateByExample(@Param("record") Merch record, @Param("example") MerchExample example);

    int updateByPrimaryKeySelective(Merch record);

    int updateByPrimaryKey(Merch record);
}