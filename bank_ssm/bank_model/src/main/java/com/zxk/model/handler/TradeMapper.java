package com.zxk.model.handler;

import com.zxk.model.dto.TradeDTO;
import com.zxk.model.pojo.Trade;
import com.zxk.model.vo.TradeVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 20:06
 **/
@Mapper
public interface TradeMapper {
    TradeMapper INSTANCE = Mappers.getMapper(TradeMapper.class);

    /**
     * tradeDto2Trade 转换
     *
     * @param tradeDto
     * @return
     */
    Trade tradeDto2Trade(TradeDTO tradeDto);

    /**
     * accountVo2accoutDto 转换
     *
     * @param accountVO
     * @return
     */
    TradeDTO tradeVo2TradeDto(TradeVO accountVO);

}
