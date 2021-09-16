package com.zxk.vo;

import lombok.Data;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:04
 **/
@Data
public class AccountVO {

    /**
     * 账户名称
     */
    private String accountId;
    /**
     * 密码
     */
    private String password;
}
