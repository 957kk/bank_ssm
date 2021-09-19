package com.zxk.service.advice;

import com.zxk.model.pojo.ZJ;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: bank_ssm
 * @description:
 * @author: xkZhao
 * @Create: 2021-09-19 08:44
 **/
@Component
@Aspect
public class TradeService {

    @Pointcut(value = "execution(* *..trade(..))")
    public void pt() {
    }

    @Around("pt()")
    public Object logWrite(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        ZJ zj = (ZJ) args[0];
        Object proceed = pjp.proceed(args);

        System.out.println("账户" + zj.getAccountId() + "时间" + new Date() + "转账" + zj.getMoney() + "给账户" + zj.getAccountId2());

        return proceed;
    }


}
