package com.mire.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
	//1.<bean id="log" class="com.mire.biz.common.LogAdvice"></bean>
@Service
@Aspect
public class LogAdvice {
	
	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointcut"/> 똑같다.
	
	
	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointcut"/>
	
	
	//3.<aop:aspect ref="log4">
	//	 <aop:after method="printLogging" pointcut-ref="allPointcut"/> 
	//	<aop:after-throwing method="afterThrowingLog" pointcut-ref="allPointcut"
	//		throwing="exception"/>
	//	</aop:aspect>
	
	@Before("PointCutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		//함수 가져오기
		String methodName = jp.getSignature().getName();
		Object[] args = jp.getArgs();
		Object obj = jp.getTarget();
		
		System.out.println("[beforeLog] 비즈니스 로직 수행 전 동작 메소드 = "+ methodName+
				" 매개변수 = "+args[0].toString()+" 클래스 = "+obj.toString());
	}
}
