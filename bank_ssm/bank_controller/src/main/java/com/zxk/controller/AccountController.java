package com.zxk.controller;

import com.zxk.model.dto.AccountDTO;
import com.zxk.model.handler.AccountMapper;
import com.zxk.model.pojo.Account;
import com.zxk.model.result.ResponseResult;
import com.zxk.service.AccountService;
import com.zxk.model.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 19:45
 **/
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("login")
    public ResponseResult login(@RequestBody AccountVO accountVo) {
        System.out.println(accountVo);
        AccountDTO accountDTO = AccountMapper.INSTANCE.accountVo2AccountDto(accountVo);
        ResponseResult login = accountService.login(accountDTO);
        if (StringUtils.isEmpty(login)) {
            return null;
        } else {
            return login;
        }
    }

    @RequestMapping("selectByAccountId")
    public Account selectByAccountId(String accountId) {
        Account account = accountService.selectByAccountId(accountId);
        System.out.println(account);
        return account;
    }


}
