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
	
		//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.*(..))" id="allPointcut"/> �Ȱ���.
		
		
		//2.<aop:pointcut expression="execution(* com.mire.biz..*Impl.get*(..))" id="getPointcut"/>
	
		@AfterReturning(pointcut = "PointCutCommon.getPointcut()",returning = "returnObj")
		public void afterReturnLog(JoinPoint jp, Object returnObj) {
			String methodName = jp.getSignature().getName();
			Object[] args = jp.getArgs();
			Object obj = jp.getTarget();
			Date date = new Date();
		//���� �� ������ Ȯ���� �� �ִ�. ���� �ڽ� Ÿ��
		if(returnObj instanceof UserVO) {
			UserVO userVO = (UserVO)returnObj;
			if(userVO.getRole().equals("Admin")) {
				System.out.println(userVO.getName()+"�� ȯ���ؿ�!!"+date.toString());
			}else {
				System.out.println(userVO.getName()+"�� �湮�Ͽ����ϴ�."+date.toString());
				
			}
		}		
		System.out.println("[afterReturnLog] ����Ͻ� ���� ���� �� ���� ���� �޼ҵ� = "+ methodName+
				" �Ű����� = "+args[0].toString()+" Ŭ���� = "+obj.toString());
	}
}
