package com.example.user.Controller.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class RequestBloodLoggingAspect {
	@Before("execution(* com.example.user.controller.RequestBloodController.*(..))")
    public void logBeforeRequestBloodMethods(JoinPoint joinPoint) {
        log.info("===== RequestBloodController Method Call =====");
        log.info("Method: {}", joinPoint.getSignature().getName());
        log.info("Class: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()));
        log.info("==============================================");
    }

}
