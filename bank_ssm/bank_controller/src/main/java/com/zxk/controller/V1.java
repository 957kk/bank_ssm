package com.zxk.controller;

import com.zxk.vo.AccountVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 23:18
 **/
@Controller
public interface V1 {

    @RequestMapping("login")
    String login(AccountVO accountVo);
}
