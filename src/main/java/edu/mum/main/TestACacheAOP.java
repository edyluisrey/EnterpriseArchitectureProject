package edu.mum.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.service.AuditService;


public class TestACacheAOP {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "context/applicationContext.xml");
		AuditService auditService = (AuditService) ctx.getBean("auditServiceImpl");
		 auditService.findAll();
		 auditService.findAll();
		 auditService.findAll();
	}    
	
}
