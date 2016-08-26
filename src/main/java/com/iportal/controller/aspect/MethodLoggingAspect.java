package com.iportal.controller.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class MethodLoggingAspect {

	 @Around("execution(* com.iportal..*.*(..))")
	  public Object timeMethod(ProceedingJoinPoint joinPoint) throws Throwable {
	    StopWatch stopWatch = new StopWatch();
	    stopWatch.start();
	    Object retVal = joinPoint.proceed();
	    stopWatch.stop();
	    
	    StringBuffer logMessageStringBuffer = new StringBuffer();
	    logMessageStringBuffer.append(joinPoint.getTarget().getClass().getName());
	    logMessageStringBuffer.append(".");
	    logMessageStringBuffer.append(joinPoint.getSignature().getName());
	    logMessageStringBuffer.append("(");
	    logMessageStringBuffer.append(joinPoint.getArgs());
	    logMessageStringBuffer.append(")");
	    logMessageStringBuffer.append(" execution time: ");
	    logMessageStringBuffer.append(stopWatch.getTotalTimeMillis());
	    logMessageStringBuffer.append(" ms");
	    System.out.println(logMessageStringBuffer.toString());
	    Logger.getLogger(this.getClass()).info(logMessageStringBuffer.toString());

	    return retVal;
	  }
	}