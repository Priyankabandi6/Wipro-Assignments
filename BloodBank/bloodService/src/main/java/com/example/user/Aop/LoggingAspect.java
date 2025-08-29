package com.example.user.Aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j

public class LoggingAspect {
	@Before("execution(* com.example.user.Contollers.BloodController.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("---- AOP Logging Start ----");
        log.info("Target Method: {}", joinPoint.getSignature().getName());
        log.info("Declaring Type: {}", joinPoint.getSignature().getDeclaringTypeName());
        log.info("Arguments: {}", joinPoint.getArgs());
        log.info("---- AOP Logging End ----");
    }


}
