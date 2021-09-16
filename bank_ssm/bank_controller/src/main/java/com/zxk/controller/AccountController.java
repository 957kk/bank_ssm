package com.zxk.controller;

import com.zxk.dto.AccountDTO;
import com.zxk.handler.AccountMapper;
import com.zxk.service.AccountService;
import com.zxk.vo.AccountVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 19:45
 **/
@Controller
public class AccountController implements V1{

    @Autowired
    private AccountService accountService;

    @Override
    @RequestMapping("login")
    public String login( AccountVO accountVo) {
        System.out.println(accountVo);
        AccountDTO accountDTO = AccountMapper.INSTANCE.accountVo2AccountDto(accountVo);

        boolean login = accountService.login(accountDTO);
        if (login) {
            return "success.jsp";
        } else {
            return "error.jsp";
        }
    }
}
