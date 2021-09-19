package com.zxk.model.dto;

import com.zxk.model.pojo.Trade;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-18 19:02
 **/
@Data
public class TradeDTO {
    /**
     * 账户 外键用来关联tb_acount表中的accountId
     */
    private String accountId;
    /**
     * 交易时间
     */
    private Date tradeTime1;
    /**
     * 交易时间
     */
    private Date tradeTime2;




}
