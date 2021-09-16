package com.zxk.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @program: bank_ssm
 * @description: trade实体类
 * @author: xkZhao
 * @Create: 2021-09-16 19:37
 **/
@Data
public class Trade {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 外键用来关联tb_acount表中的accountId
     */
    private String accountId;
    /**
     * 交易明细，0存款，1取款，2转出
     */
    private String tradeType;
    /**
     *
     */
    private Double tradeMoney;
    /**
     * 时间
     */
    private Date tradeTime;
    /**
     *
     */
    private String digest;

}
