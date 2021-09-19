package com.zxk.model.pojo;

import com.zxk.utils.DateUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: bank_ssm
 * @description: trade实体类
 * @author: xkZhao
 * @Create: 2021-09-16 19:37
 **/
@Data
public class Trade implements Serializable {
    private static final long serialVersionUID = 8683452581122892189L;
    /**
     * 主键id 流水号
     */
    private Integer id;
    /**
     * 账户 外键用来关联tb_acount表中的accountId
     */
    private String accountId;
    /**
     * 交易类型，0存款，1取款，2转出
     */
    private String tradeType;
    /**
     * 交易金额
     */
    private Double tradeMoney;
    /**
     * 交易时间
     */
    private Date tradeTime;
    /**
     * 交易摘要
     */
    private String digest;

    public String getTradeTimeStr() {
        return DateUtils.date2Str(getTradeTime());
    }

}
