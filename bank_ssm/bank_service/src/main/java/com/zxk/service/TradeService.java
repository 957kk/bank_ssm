package com.zxk.service;


import com.zxk.model.dto.TradeDTO;
import com.zxk.model.pojo.Trade;
import com.zxk.model.pojo.ZJ;
import com.zxk.model.result.ResponseResult;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-17 20:59
 **/
@Transactional
@EnableAspectJAutoProxy
public interface TradeService {

    List<Trade> selectTradeByAccountId(String accountId);

    List<Trade> selectTradeByAccountIdAndTime(TradeDTO tradeDto);

    @Transactional(
            readOnly = false,
            timeout = -1,
            isolation = Isolation.DEFAULT,
            rollbackFor = {},   //java.lang.ArithmeticException.class, IOException.class
            noRollbackFor = {},
            propagation = Propagation.REQUIRED
    )
    ResponseResult trade(ZJ zj);
}
