package com.zxk.handler;

import com.zxk.dto.AccountDTO;
import com.zxk.pojo.Account;
import com.zxk.vo.AccountVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:06
 **/
@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    /**
     * accountDto2Account 转换
     * @param accountDTO
     * @return
     */
    Account accountDto2Account(AccountDTO accountDTO);

    /**
     * accountVo2accoutDto 转换
     * @param accountVO
     * @return
     */
    AccountDTO accountVo2AccountDto(AccountVO accountVO);

}
