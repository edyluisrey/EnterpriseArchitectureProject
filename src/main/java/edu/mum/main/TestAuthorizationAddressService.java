package edu.mum.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.mum.domain.Address;
import edu.mum.domain.Audit;
import edu.mum.domain.Authority;
import edu.mum.domain.Customer;
import edu.mum.domain.Group;
import edu.mum.domain.Room;
import edu.mum.domain.User;
import edu.mum.domain.UserCredential;
import edu.mum.security.AuthenticateUser;
import edu.mum.service.AddressService;
import edu.mum.service.AuditService;
import edu.mum.service.CustomerService;
import edu.mum.service.GroupService;
import edu.mum.service.RoomService;
import edu.mum.service.impl.GroupServiceImpl;

@Component
public class TestAuthorizationAddressService {
	
	public static void main(String[] args) {
		  ApplicationContext ctx = new ClassPathXmlApplicationContext(
			        "context/applicationContext.xml", "context/security-context.xml" );
		  
		  AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");
			
		  while (true) {    
			     AuthenticateUser authenticateUser = new AuthenticateUser();
			     try {
			  		authenticateUser.authenticate(authenticationManager);
			  	} catch (Exception e) {
			  		// TODO Auto-generated catch block
			  		e.printStackTrace();
			  	}
			     
				System.out.println();
			    System.out.println( "   **********      Test Authourization for Address Service   **********");	
			    System.out.println( "   **********      account admin/admin or guest/guest (get address   **********");	
			    AddressService addressService = (AddressService) ctx.getBean("addressServiceImpl");
			    
			    Address address1 = new Address();
			    address1.setStreet(" 100admiguest0 N Courst Street");
			    address1.setCity("Fairfield");
			    address1.setZipCode("52556");
			    address1.setState("IA");
			    
			    Address address2 = new Address();
			    address2.setStreet(" 100admiguest0 N Courst Street");
			    address2.setCity("Fairfield");
			    address2.setZipCode("52556");
			    address2.setState("IA");
			    
			    
			    Address address3 = new Address();
			    address3.setStreet(" 100admiguest0 N Courst Street");
			    address3.setCity("Fairfield");
			    address3.setZipCode("52556");
			    address3.setState("IA");
			    
			    addressService.save(address1);
			    addressService.save(address2);
			    addressService.save(address3);
			    
			    
			    
			  			    
		 }	
		}
}
