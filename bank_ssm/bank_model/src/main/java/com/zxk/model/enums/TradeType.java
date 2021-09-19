package com.zxk.model.enums;

import java.io.Serializable;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-18 23:16
 **/
public enum TradeType implements Serializable {

    INMONEY("存入"),
    OUTMONEY("取出"),
    TOMONEY("转出");

    /**
     * 提示信息
     */
    private final String message;

    private TradeType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
