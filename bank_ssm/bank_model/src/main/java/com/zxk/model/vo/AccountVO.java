package com.zxk.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:04
 **/
@Data
public class AccountVO implements Serializable {
    private static final long serialVersionUID = 8683452581122892189L;

    /**
     * 账户名称
     */
    private String accountId;
    /**
     * 密码
     */
    private String password;
}
