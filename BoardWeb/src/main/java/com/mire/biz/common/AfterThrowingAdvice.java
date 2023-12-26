package com.mire.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointcut"/> �Ȱ���.
	
			
	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointcut"/>
	
	
	@AfterThrowing(pointcut = "PointCutCommon.allPointcut()",throwing ="exception")
	public void afterThrowingLog(JoinPoint jp, Exception exception) {
		String methodName = jp.getSignature().getName();
		
		if(exception instanceof NumberFormatException) {
			System.out.println("[afterThrowingLog] ����Ͻ� ���� ������ ����ó�� ���� �Լ���:"
					+methodName +"NumberFormatException");
		}else if(exception instanceof IllegalAccessException) {
			System.out.println("[afterThrowingLog] ����Ͻ� ���� ������ ����ó�� ���� �Լ���:"
					+methodName +"IllegalAccessException");
		}else if(exception instanceof Exception) {
			System.out.println("[afterThrowingLog] ����Ͻ� ���� ������ ����ó�� ���� �Լ���:"
					+methodName +"Exception");
		}
		System.out.println("[afterThrowingLog] ����Ͻ� ���� ������ ����ó�� ���� �Լ���:"
				+methodName +"�ż��ϰ� ����ٶ�");
	}
}
