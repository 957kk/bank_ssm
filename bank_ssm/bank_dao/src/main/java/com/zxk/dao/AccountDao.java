package com.zxk.dao;

import com.zxk.pojo.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:26
 **/
@Repository
public interface AccountDao {
    @Select("select * from tb_account where accountId=#{account.accountId} and where password=#{account.password}")
    Account selectAccountByName_Password(Account account);

}
