package com.zxk.dao;

import com.zxk.model.dto.TradeDTO;
import com.zxk.model.pojo.Account;
import com.zxk.model.pojo.Trade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:26
 **/
@Repository
public interface TradeDao {

    @Select("select * from tb_trade where accountId= #{accountId}")
    List<Trade> selectTradeByAccountId(String accountId);


    @Select("SELECT * FROM tb_trade WHERE AccountID=#{tradeDto.accountId} AND TradeTime BETWEEN DATE_FORMAT(#{tradeDto.tradeTime1}, '%Y-%m-%d') AND DATE_FORMAT(#{tradeDto.tradeTime2}, '%Y-%m-%d')")
        // @Select("SELECT * FROM tb_trade WHERE AccountID=#{tradeDto.accountId} AND TradeTime BETWEEN #{tradeDto.tradeTime1} AND #{tradeDto.tradeTime2}")
    List<Trade> selectTradeByAccountIdAndTime(@Param("tradeDto") TradeDTO tradeDto);

    @Insert("INSERT INTO tb_trade (AccountID,TradeType,TradeMoney,TradeTime,Digest) VALUES (#{trade.accountId},#{trade.tradeType},#{trade.tradeMoney},#{trade.tradeTime},#{trade.digest})")
    Integer insertTrade(@Param("trade") Trade trade);
}
