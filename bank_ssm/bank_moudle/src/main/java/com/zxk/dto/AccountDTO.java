package com.zxk.dto;

import lombok.Data;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:05
 **/
@Data
public class AccountDTO {
    /**
     * 账户名称
     */
    private String accountId;
    /**
     * 密码
     */
    private String password;
}
