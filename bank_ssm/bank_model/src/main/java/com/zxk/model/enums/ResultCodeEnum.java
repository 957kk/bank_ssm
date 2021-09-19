package com.zxk.model.enums;

import java.io.Serializable;

/**
 * @program: ssm-xml
 * @description: 注册提示信息枚举类
 * @author: xkZhao
 * @Create: 2021-09-15 15:31
 **/
public enum ResultCodeEnum implements Serializable {
    /**
     * 成功与失败
     */
    SUCCESS(10001, "操作成功！"),
    FAIL(10002, "操作失败！"),
  /*  SUCCESS(10001, "success.jsp"),
    FAIL(10002, "error.jsp"),*/

    /**
     * 用户注册业务枚举  20000
     */
    USER_INFO_IS_INVALID(20001, "用户信息无效！"),
    USER_INFO_NAME_IS_BLANK(20002, "用户名为空！"),

    USER_INFO_PASSWORD_IS_BLANK(20003, "密码为空！"),
    USER_INFO_NAME_IS_EXIST(20004, "用户已经存在！"),

    MONEY_IS_NOT_ENOUGH(00001, "余额不足，请输入新的！"),
    NO_THIS_ACCOUNT(00002, "仅支持本行账户转账"),
    NOT_ZERO_OR_NEGATIVE_NULL(00003, "转账金额不可为0或者负数或空"),
    ACCOUNT_INFO_NAME_IS_BLANK(20002, "转账名不可为空！"),

    /**
     * 异常枚举
     */
    USER_BIZ_EXCEPTION(90000, "网络不好，请您稍后重试！"),
    EXCEPTION(90001, "您的数据跑丢了，请您稍后重试！");

    /**
     * 提示码
     */
    private final Integer code;
    /**
     * 提示信息
     */
    private final String message;


    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
