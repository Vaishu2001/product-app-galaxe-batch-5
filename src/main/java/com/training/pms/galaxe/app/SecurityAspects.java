package com.training.pms.galaxe.app;

import java.util.Date;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
@Aspect
@Order(0)
public class SecurityAspects {

	public SecurityAspects() {
		// TODO Auto-generated constructor stub
	}
	@Before(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doSecurityCheck() {
		System.out.println("###Security check Before Log in called at :"+new Date()+ " By Aspects");
	}
	@After(value =  "execution(* com.training.pms.galaxe.service.ProductServiceImpl.*(..))")
	public void doSecurityCheck1() {
		System.out.println("###Security check After Log out called at :"+new Date()+ " By Aspects");
	}

}
