package com.mire.biz.common;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.mire.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	
		//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointcut"/> 똑같다.
		
		
		//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointcut"/>
	
		@AfterReturning(pointcut = "PointCutCommon.getPointcut()",returning = "returnObj")
		public void afterReturnLog(JoinPoint jp, Object returnObj) {
			String methodName = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			Object obj = jp.getTarget();
			Date date = new Date();
		//리턴 값 가지고 확인할 수 있다. 부인 자식 타입
		if(returnObj instanceof UserVO) {
			UserVO userVO = (UserVO)returnObj;
			if(userVO.getRole().equals("Admin")) {
				System.out.println(userVO.getName()+"님 환영해여!!"+date.toString());
			}else {
				System.out.println(userVO.getName()+"님 방문하였습니다."+date.toString());
				
			}
		}		
		System.out.println("[afterReturnLog] 비즈니스 로직 수행 후 리턴 동작 메소드 = "+ methodName+
				" 매개변수 = "+args[0].toString()+" 클래스 = "+obj.toString());
	}
}
