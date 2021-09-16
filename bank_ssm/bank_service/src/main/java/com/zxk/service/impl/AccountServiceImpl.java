package com.zxk.service.impl;

import com.zxk.dao.AccountDao;
import com.zxk.dto.AccountDTO;
import com.zxk.handler.AccountMapper;
import com.zxk.pojo.Account;
import com.zxk.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 19:51
 **/
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean login(AccountDTO dto) {
        if (StringUtils.isEmpty(dto)) {
            return false;
        }
        if (StringUtils.isEmpty(dto.getAccountId())) {
            return false;
        }
        if (StringUtils.isEmpty(dto.getPassword())) {
            return false;
        }
        Account account = AccountMapper.INSTANCE.accountDto2Account(dto);
        Account account1 = accountDao.selectAccountByName_Password(account);
        if (StringUtils.isEmpty(account1)) {
            return false;
        }
        return true;
    }
}
