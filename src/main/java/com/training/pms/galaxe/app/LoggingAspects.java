package com.training.pms.galaxe.app;


import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class LoggingAspects {

	public LoggingAspects() {
		// TODO Auto-generated constructor stub
	}
	@Before(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doLogging() {
		System.out.println("###2.Logged in at :"+new Date()+ " By Aspects");
	}

	@After(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doSomeWork() {
		System.out.println("###3.Logged out at :"+new Date()+ " By Aspects");
	}
//		@Around(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.isProductExists(..))")
//		public boolean doSomeWork2(ProceedingJoinPoint point) throws Throwable {
//			System.out.println("1. ###Before the method gets called :: "+new Date()+ " By Aspects");
//			//decide whether to proceed with the method execution
//			point.proceed();
//			System.out.println("4. ###After the method gets called :: "+new Date()+ " By Aspects");
//			return true;
//		}
	@Around(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public Object doSomeWork2(ProceedingJoinPoint point) throws Throwable {
		Signature methods= point.getSignature();
		System.out.println("1. ###Before the method gets called :: "+new Date()+ " By Aspects");
		//decide whether to proceed with the method execution
		Object retval=point.proceed();
		System.out.println("4. ###After the method gets called :: "+new Date()+ " By Aspects");
		return retval;
	}

}
