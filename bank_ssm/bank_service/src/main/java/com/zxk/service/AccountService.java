package com.zxk.service;

import com.zxk.dto.AccountDTO;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 19:47
 **/
public interface AccountService {

    boolean login(AccountDTO dto);
}
