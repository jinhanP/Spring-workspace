package com.mire.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutCommon {
	
	//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointcut"/> ¶È°°´Ù.
		@Pointcut("execution(* com.mire.biz..*Impl.*(..))")
		public void allPointcut() {}
				
		//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointcut"/>
		@Pointcut("execution(* com.mire.biz..*Impl.get*(..))")
		public void getPointcut() {}
}
