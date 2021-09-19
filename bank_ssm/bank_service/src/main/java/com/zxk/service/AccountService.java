package com.zxk.service;

import com.zxk.model.dto.AccountDTO;
import com.zxk.model.pojo.Account;
import com.zxk.model.result.ResponseResult;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 19:47
 **/
public interface AccountService {

    ResponseResult login(AccountDTO dto);

    Account selectByAccountId(String accountId);
}
