package com.mire.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
		

	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointcut"/> �Ȱ���.

			
	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointcut"/>

	
	@Around("PointCutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("[aroundLog start] ");
		//�ð� ó�� 
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object obj = pjp.proceed();
		stopWatch.stop();
		//�Լ����� �̸� ����ش�.
		String funcName = pjp.getSignature().getName();
		System.out.println("[aroundLog stop]"+funcName+"�Լ� ���� �ð�"+stopWatch.getTotalTimeMillis()+"(ms)��");
		return obj;
	}
}
