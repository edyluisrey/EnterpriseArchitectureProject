package edu.mum.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.domain.Audit;
import edu.mum.service.AuditService;


public class TestACacheAOP {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "context/applicationContext.xml");
		  
		System.out.println();
	    System.out.println( "   **********      AUDIT TEST  **********");	
		AuditService auditService = (AuditService) ctx.getBean("auditServiceImpl");
		Long id = (long) 1;
		auditService.findOne(id);
		System.out.println("\n");
		
	    System.out.println( "   **********      AOP CACHE  **********");
	    System.out.println("1 call");
	    List<Audit> list1 = auditService.findAll();
	    for (Audit temp : list1) {
			System.out.println("  -:"+temp.getWho() + " invoke"+ temp.getMethodInvoke());
		}
	    
	    System.out.println("2 call");
	    List<Audit> list2 = auditService.findAll();
	    for (Audit temp : list2) {
			System.out.println("  -:"+temp.getWho() + " invoke"+ temp.getMethodInvoke());
		}
		System.out.println("3 call");
		List<Audit> list3 = auditService.findAll();
		for (Audit temp : list3) {
				System.out.println("  -:"+temp.getWho() + " invoke"+ temp.getMethodInvoke());
		}
		
		System.out.println("\n");
		System.out.println( "   **********      EXCEPTIONS **********");
		//System.out.println( "   **********      EXCEPTIONS  **********");
		//auditService.findByEmail("edy@mum.edu");

	}

}
