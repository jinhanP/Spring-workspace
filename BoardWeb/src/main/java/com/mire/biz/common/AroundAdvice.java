package com.mire.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
		

	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointcut"/> 똑같다.

			
	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointcut"/>

	
	@Around("PointCutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[aroundLog start] ");
		//시간 처리 
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		//함수명의 이름 잡아준다.
		String funcName = pjp.getSignature().getName();
		System.out.println("[aroundLog stop]"+funcName+"함수 수행 시간"+stopWatch.getTotalTimeMillis()+"(ms)초");
		return obj;
	}
}
