package edu.mum.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;

import edu.mum.domain.Audit;
import edu.mum.domain.Customer;
import edu.mum.domain.Room;
import edu.mum.security.AuthenticateUser;
import edu.mum.service.AuditService;
import edu.mum.service.CustomerService;
import edu.mum.service.RoomService;


public class TestACacheAOP {
	
	public static void main(String[] args) {
	  ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "context/applicationContext.xml");
	  
	  ApplicationContext ctx1 = new ClassPathXmlApplicationContext(
		        "context/security-context.xml");
	  AuthenticationManager authenticationManager = (AuthenticationManager) ctx1.getBean("authenticationManager");
		
	  while (true) {    
		     AuthenticateUser authenticateUser = new AuthenticateUser();
		     try {
		  		authenticateUser.authenticate(authenticationManager);
		  	} catch (Exception e) {
		  		// TODO Auto-generated catch block
		  		e.printStackTrace();
		  	}
		     
			System.out.println();
		    System.out.println( "   **********      AUDIT AOP  **********");	
		    System.out.println( "   ***** Call method with annotation @auditor ****");
		    AuditService auditService = (AuditService) ctx.getBean("auditServiceImpl");
		    CustomerService customerService = (CustomerService) ctx.getBean("customerServiceImpl");
		    RoomService roomService = (RoomService) ctx.getBean("roomServiceImpl");
		    
		    Customer  customer = new Customer();
			customer.setFirstName("Dorita");
			customer.setLastName("rita");
			customer.setPassport("5677d");
			
			Room room= new Room();
			room.setDescription("Test Audit");
			room.setFloor("10");
			room.setRoomNumber("33");
			
			System.out.println( "   ****** Total of elements in audit table before: " + auditService.findAll().size() + " ****");
			customerService.save(customer);
			roomService.save(room);
			List<Audit> listAudit = auditService.findAll();
			
			System.out.println( "   ****** Total of elements in audit table after: " + listAudit.size()+ " ****");
			for (Audit temp : listAudit) {
				System.out.println("  - "+temp.getWho() + " Action: "+ temp.getMethodInvoke());
			}
			System.out.println("\n");
			
			
			
		    System.out.println( "   **********      AOP CACHE  **********");		   			
		    System.out.println("1 call roomService.findAll");
		    List<Room> list1 = roomService.findAll();
		    for (Room temp : list1) {
				System.out.println("  - Room Number: "+temp.getRoomNumber() + "  Floor:"+ temp.getFloor());
			}
		    
		    System.out.println("2 call");
		    List<Room> list2 = roomService.findAll();
		    for (Room temp : list2) {
				System.out.println("  - Room Number: "+temp.getRoomNumber() + "  Floor:"+ temp.getFloor());
			}
			System.out.println("3 call");
			List<Room> list3 = roomService.findAll();
		    for (Room temp : list3) {
				System.out.println("  - Room Number: "+temp.getRoomNumber() + "  Floor:"+ temp.getFloor());
			}
			
			System.out.println("\n");
			System.out.println( "   **********      EXCEPTIONS **********");
			//System.out.println( "   **********      EXCEPTIONS  **********");
			//auditService.findByEmail("edy@mum.edu");
	 }
	}

}

