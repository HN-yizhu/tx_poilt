package com.poilt.mapper.fastpay;

import com.poilt.pojo.TradeLog;
import com.poilt.pojo.TradeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TradeLogMapper {
    int countByExample(TradeLogExample example);

    int deleteByExample(TradeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TradeLog record);

    int insertSelective(TradeLog record);

    List<TradeLog> selectByExample(TradeLogExample example);

    TradeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TradeLog record, @Param("example") TradeLogExample example);

    int updateByExample(@Param("record") TradeLog record, @Param("example") TradeLogExample example);

    int updateByPrimaryKeySelective(TradeLog record);

    int updateByPrimaryKey(TradeLog record);
}