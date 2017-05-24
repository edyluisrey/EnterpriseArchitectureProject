package edu.mum.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.domain.Audit;
import edu.mum.service.AuditService;

@Aspect
@Component
public class AuditAspect {
	
	@Autowired
	private AuditService auditService;
	
	@Pointcut("@annotation(edu.mum.aspect.annotation.Auditor)")
	public void audit() {}
	
	@Before("audit()")
	public void logResource(JoinPoint joinPoint) {
		   
	    Audit audit = new Audit();
	    String  target = joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName(); 
	    Date date = new Date();
	    audit.setWho("Edy");
	    audit.setMethodInvoke(target);
	    audit.setTime(date);	
	    auditService.save(audit);
	    System.out.println( "   **********     TARGET CLASS : " + target + "    **********");
	}
	
	@AfterThrowing (pointcut = "execution(* edu.mum.service..*(..))", throwing = "ex")
    public void logAfterThrowingAllMethods(Exception ex) throws Throwable 
    {
        System.out.println("****Aspect.exception " + ex);
    }
	 

}
