package com.zxk.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxk.model.handler.TradeMapper;
import com.zxk.model.pojo.Trade;
import com.zxk.model.pojo.ZJ;
import com.zxk.model.result.ResponseResult;
import com.zxk.model.vo.AccountVO;
import com.zxk.model.vo.TradeVO;
import com.zxk.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-16 19:43
 **/
@Controller
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @RequestMapping("toTrade")
    public ModelAndView toTrade(String accountId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("success.jsp");
        mv.addObject("accountId", accountId);
        return mv;
    }


    @RequestMapping("selectTradeByAccountId")
    @ResponseBody
    public List<Trade> selectTradeByAccountId(@RequestBody AccountVO vo) {
        List<Trade> trades = tradeService.selectTradeByAccountId(vo.getAccountId());
        System.out.println(trades);

        return tradeService.selectTradeByAccountId(vo.getAccountId());
    }

    @RequestMapping("STBAT")
    @ResponseBody
    public List<Trade> selectTradeByAccountIdAndTime(@RequestBody TradeVO vo) {
        System.out.println(vo);
        List<Trade> trades = tradeService.selectTradeByAccountIdAndTime(TradeMapper.INSTANCE.tradeVo2TradeDto(vo));
        System.out.println(trades);
        return tradeService.selectTradeByAccountIdAndTime(TradeMapper.INSTANCE.tradeVo2TradeDto(vo));
    }

    @RequestMapping("trade")
    @ResponseBody
    public ResponseResult trade(@RequestBody ZJ zj) {
        return tradeService.trade(zj);
    }

}
