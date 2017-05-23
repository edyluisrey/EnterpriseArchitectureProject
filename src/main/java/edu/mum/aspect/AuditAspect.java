package edu.mum.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {
	
	@Before("execution(* edu.mum.service..findAll(..))")
	public void applicationMethod() {
		System.out.println("aspectt");
	}

}
