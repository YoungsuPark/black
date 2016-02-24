package com.javap.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;

@Aspect
public class ApmUtil {
	protected Log log = LogFactory.getLog(ApmUtil.class);
	
	@Around("execution(* com.javap.home..*.*(..)) || execution(* com.javap.member..*.*(..)) || execution(* com.javap.memoboard..*.*(..))")
	public Object apmMeasurement(ProceedingJoinPoint pjp) throws Throwable {
		String methodName = pjp.getSignature().getName();
		StopWatch sw = new StopWatch();
		sw.start(methodName);
		Object returnObj = pjp.proceed();
		sw.stop();
		log.debug("Method : " + methodName +" was called.");
		log.debug("Elaped Time : " + sw.getTotalTimeMillis()+ "millisecond");
		return returnObj;
	}
}
