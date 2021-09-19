package com.zxk.service.impl;

import com.zxk.dao.AccountDao;
import com.zxk.dao.TradeDao;
import com.zxk.model.dto.TradeDTO;
import com.zxk.model.enums.ResultCodeEnum;
import com.zxk.model.enums.TradeType;
import com.zxk.model.pojo.Account;
import com.zxk.model.pojo.Trade;
import com.zxk.model.pojo.ZJ;
import com.zxk.model.result.ResponseResult;
import com.zxk.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-17 21:04
 **/
@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private TradeDao tradeDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Trade> selectTradeByAccountId(String accountId) {
        return tradeDao.selectTradeByAccountId(accountId);
    }

    @Override
    public List<Trade> selectTradeByAccountIdAndTime(TradeDTO tradeDto) {

        System.out.println(tradeDto);
        if (StringUtils.isEmpty(tradeDto)) {
            return null;
        }

        return tradeDao.selectTradeByAccountIdAndTime(tradeDto);
    }

    @Override
    public ResponseResult trade(ZJ zj) {
        String accountId = zj.getAccountId();
        String accountId2 = zj.getAccountId2();
        Double money = zj.getMoney();
        Account account = accountDao.selectByAccountId(accountId);
        System.out.println(account);
        if (StringUtils.isEmpty(money) || money <= 0) {
            return ResponseResult.error(ResultCodeEnum.NOT_ZERO_OR_NEGATIVE_NULL);
        }

        if (StringUtils.isEmpty(accountId2)) {
            return ResponseResult.error(ResultCodeEnum.ACCOUNT_INFO_NAME_IS_BLANK);
        }
        if (account.getRemaining() < money) {
            return ResponseResult.error(ResultCodeEnum.MONEY_IS_NOT_ENOUGH);
        }
        Account account1 = accountDao.selectByAccountId(accountId2);
        System.out.println(account1);
        if (StringUtils.isEmpty(account1)) {
            return ResponseResult.error(ResultCodeEnum.NO_THIS_ACCOUNT);
        }

        accountDao.updateAccount(accountId, -money);

        accountDao.updateAccount(accountId2, money);
        //int i=1/0;
        Trade trade1 = new Trade();
        trade1.setAccountId(accountId);
        trade1.setDigest(accountId2);
        trade1.setTradeMoney(money);
        trade1.setTradeTime(new Date());
        trade1.setTradeType(TradeType.TOMONEY.getMessage());
        System.out.println(trade1);
        tradeDao.insertTrade(trade1);

        Trade trade2 = new Trade();
        trade2.setAccountId(accountId2);
        trade2.setDigest(accountId);
        trade2.setTradeMoney(money);
        trade2.setTradeTime(new Date());
        trade2.setTradeType(TradeType.INMONEY.getMessage());
        tradeDao.insertTrade(trade2);

        return ResponseResult.ok(ResultCodeEnum.SUCCESS);
    }
}
