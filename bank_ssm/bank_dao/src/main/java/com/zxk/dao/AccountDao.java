package com.zxk.dao;

import com.zxk.model.pojo.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:26
 **/
@Repository
public interface AccountDao {
    @Select("select * from tb_account where accountId=#{account.accountId} and password=#{account.password}")
    Account selectAccountByName_Password(@Param("account") Account account);

    @Select("select * from tb_account where accountId= #{accountId}")
    Account selectByAccountId(String accountId);


    @Update("UPDATE tb_account SET Remaining = Remaining + #{V} WHERE AccountID = #{accountId}")
    Integer updateAccount(@Param("accountId") String accountId,@Param("V") double v);

}
