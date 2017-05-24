package edu.mum.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.mum.domain.Address;
import edu.mum.domain.Authority;
import edu.mum.domain.Group;
import edu.mum.domain.User;
import edu.mum.domain.UserCredential;
import edu.mum.service.GroupService;
import edu.mum.service.impl.GroupServiceImpl;

@Component
public class TestServiceLayer {
	
	@Autowired
	private GroupService groupService;

	private List<Authority> authorities = new ArrayList<>();
	private List<UserCredential> userCredentials = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<Address> addresses = new ArrayList<>();
	
	private void testUserAuthenticationSaving() {
		Authority roleAdmin = new Authority();
		roleAdmin.setAuthority("ROLE_ADMIN");
		Authority roleUser = new Authority();
		roleUser.setAuthority("ROLE_USER");
		Authority read = new Authority();
		read.setAuthority("READ");
		
		UserCredential creDora = new UserCredential();
		creDora.setUsername("dora");
		creDora.setPassword("dora");
		creDora.setVerifyPassword("dora");
		creDora.setEnabled(true);
		
		Group adminGroup = new Group();
		adminGroup.setGroupName("ADMIN");
		adminGroup.getUserCredentials().add(creDora);
		adminGroup.getAuthorities().add(roleAdmin);
		adminGroup.getAuthorities().add(read);
		
		if (groupService == null) {
			System.out.println("GroupService is null!!!");
			return;
		}
		
		groupService.save(adminGroup);
		
	}
	
	public static void main(String[] args) {
			
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "context/applicationContext.xml");
		
		TestServiceLayer test = (TestServiceLayer)ctx.getBean("testServiceLayer");
		test.testUserAuthenticationSaving();
		System.out.println("Test Saving group and related fields!!!");
	}

}
