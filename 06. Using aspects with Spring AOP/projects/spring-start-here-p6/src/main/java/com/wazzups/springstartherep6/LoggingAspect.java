package com.wazzups.springstartherep6;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

    private final Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.wazzups.springstartherep6.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("Method will be executed");
        Object proceed = joinPoint.proceed();
        log.info("Method executed successfully");
        return proceed;
    }
}
