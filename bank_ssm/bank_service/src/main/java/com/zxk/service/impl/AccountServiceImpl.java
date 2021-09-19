package com.zxk.service.impl;

import com.zxk.dao.AccountDao;
import com.zxk.model.dto.AccountDTO;
import com.zxk.model.enums.ResultCodeEnum;
import com.zxk.model.handler.AccountMapper;
import com.zxk.model.pojo.Account;
import com.zxk.model.result.ResponseResult;
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
    public ResponseResult login(AccountDTO dto) {
        if (StringUtils.isEmpty(dto)) {
            return ResponseResult.error(ResultCodeEnum.FAIL);
        }
        if (StringUtils.isEmpty(dto.getAccountId())) {
            return ResponseResult.error(ResultCodeEnum.USER_INFO_NAME_IS_BLANK);
        }
        if (StringUtils.isEmpty(dto.getPassword())) {
            return ResponseResult.error(ResultCodeEnum.USER_INFO_PASSWORD_IS_BLANK);
        }
        Account account = AccountMapper.INSTANCE.accountDto2Account(dto);
        Account account1 = accountDao.selectAccountByName_Password(account);
        if (StringUtils.isEmpty(account1)) {
            return ResponseResult.error(ResultCodeEnum.USER_INFO_IS_INVALID);
        }
        ResponseResult ok = ResponseResult.ok(ResultCodeEnum.SUCCESS);
        System.out.println(ok);
        ok.setData(account1.getAccountId());
        System.out.println(ok);
        return ok;
    }

    @Override
    public Account selectByAccountId(String accountId) {
        return accountDao.selectByAccountId(accountId);
    }
}
