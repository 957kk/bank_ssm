package com.zxk.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: bank_ssm
 * @description: 账户实体类
 * @author: xkZhao
 * @Create: 2021-09-16 18:56
 **/
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 8683452581122892189L;
    /**
     * 账户名称
     */
    private String accountId;
    /**
     * 密码
     */
    private String password;
    /**
     *
     */
    private String remaining;
}
