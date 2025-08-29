package com.example.user.contoller.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j

public class DonerLoggingAspect {
	@Before("execution(* com.example.user.controllers.DonerController.*(..))")
    public void logBeforeDonerController(JoinPoint joinPoint) {
        log.info("===== DonerController Method Call =====");
        log.info("Method: {}", joinPoint.getSignature().getName());
        log.info("Class: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
        log.info("========================================");
    }

}
