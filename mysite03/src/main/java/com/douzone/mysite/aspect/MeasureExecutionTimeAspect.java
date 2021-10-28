package com.douzone.mysite.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
//@Aspect 어노테이션은 해당 클래스가 부가기능 클래스임을 알려주는 어노테이션이다
//이 어노테이션이 부여되었다고 자동으로 Bean으로 등록되는 것이 아니므로 따로 Bean으로 등록을 해주는 작업이 필요합니다.
//Bean으로 등록할 때 Component 어노테이션을 이용해도 된다.
@Component
public class MeasureExecutionTimeAspect {
	
	@Around("execution(* *..*.repository.*.*(..)) || execution(* *..*.service.*.*(..)) || execution(* *..*.controller.*.*(..))")
	
	//Around는 advice의 한 종류로 핵심 기능의 실패여부와 상관없이 메서드 실행 전, 후 또는 예외 발생 시점에 공통 기능 실행 
	//Around Advice를
    //구현하는 메서드는 org.aspectj.lang.ProceedingJoinPoint를 반드시 첫번째 파라미터로 지정
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// before
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object result = pjp.proceed();
		
		// after
		sw.stop();
		Long totalTime = sw.getTotalTimeMillis();
		
		String className = pjp.getTarget().getClass().getName();
		String methodName = pjp.getSignature().getName();
		String taskName = className + "." + methodName;
		System.out.println("[Execution Time][" + taskName + "] " + totalTime + "millis");
		
		return result;
	}
}
