package com.zxk.model.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-18 23:44
 **/
@Data
public class ZJ implements Serializable {
    private String accountId;
    private String accountId2;
    private Double money;
}
