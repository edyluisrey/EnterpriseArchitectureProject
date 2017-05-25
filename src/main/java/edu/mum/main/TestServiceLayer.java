package edu.mum.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import edu.mum.domain.Address;
import edu.mum.domain.Authority;
import edu.mum.domain.Customer;
import edu.mum.domain.Group;
import edu.mum.domain.Reservation;
import edu.mum.domain.Room;
import edu.mum.domain.RoomType;
import edu.mum.domain.User;
import edu.mum.domain.UserCredential;
import edu.mum.exception.ValidationException;
import edu.mum.security.AuthenticateUser;
import edu.mum.service.CustomerService;
import edu.mum.service.GroupService;
import edu.mum.service.ReservationService;
import edu.mum.service.RoomService;
import edu.mum.service.RoomTypeService;
import edu.mum.service.UserService;

@Component
public class TestServiceLayer {
	
	@Autowired
	private GroupService groupService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoomTypeService roomTypeService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	MessageSourceAccessor messageAccessor;
	
	@Autowired
	private ReservationService reservationService;

	private List<Authority> authorities = new ArrayList<>();
	private List<UserCredential> userCredentials = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	private List<Address> addresses = new ArrayList<>();
	
	private void testUserAuthenticationSaving() {
		
		// Add Authority 
		Authority roleAdmin = new Authority();
		roleAdmin.setAuthority("ROLE_ADMIN");
		Authority roleUser = new Authority();
		roleUser.setAuthority("ROLE_USER");
		Authority read = new Authority();
		read.setAuthority("READ");
		
		// Add User credential
		UserCredential creDora = new UserCredential();
		creDora.setUsername("dora");
		creDora.setPassword("dora");
		creDora.setVerifyPassword("dora");
		creDora.setEnabled(true);
		
		// Add Group
		Group adminGroup = new Group();
		adminGroup.setGroupName("ADMIN");
		adminGroup.getUserCredentials().add(creDora);
		adminGroup.getAuthorities().add(roleAdmin);
		adminGroup.getAuthorities().add(read);
		
		// Add Address
		Address address = new Address();
		address.setStreet("53B, Maple St");
		address.setCity("Fairfield");
		address.setZipCode("52556");
		address.setState("IOWA");
		// Add User
		User user = new User();
		user.setFirstName("Dora");
		user.setLastName("Khiev");
		user.setEmail("khievdora@gmail.com");
		user.setAdmin(true);
		user.setRanking(2);
		user.getAddresses().add(address);
		
		
		if (groupService == null) {
			System.out.println("GroupService is null!!!");
			return;
		}
		
		groupService.save(adminGroup);
		user.setUserCredential(creDora);
		userService.save(user);
		//userService.update(user);
		
	}
	
	public void testAddDefaultData() {
		// RoomType saving
		RoomType familyType = new RoomType();
		familyType.setRoomTypeName("Family");
		RoomType doubleType = new RoomType();
		doubleType.setRoomTypeName("Double");		
		roomTypeService.save(familyType);
		roomTypeService.save(doubleType);

		// Room saving
		Room r001 = new Room();
		r001.setRoomName("001");
		r001.setPrice(50.0);
		r001.setRoomType(familyType);
		Room r002 = new Room();
		r002.setRoomName("002");
		r002.setPrice(25.0);
		r002.setRoomType(familyType);
		familyType.getRooms().add(r001);
		familyType.getRooms().add(r002);
		try {
			roomTypeService.update(familyType);
			roomTypeService.update(doubleType);			
		} catch (ValidationException e) {
			System.out.println("Validation fail!!!");
			printValidationErrors(e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RoomType family = roomTypeService.findRoomTypeById((long)1);
		System.out.println("room in room type is  " + family.getRooms().size());
				
		// Add customer into system
		 Customer  customer = new Customer();
		 customer.setFirstName("Edy");
		 customer.setLastName("Aguirre Rest");
		 customer.setPassport("5677884");
		 try {
			 customerService.save(customer);			 
		 } catch(ValidationException e) {
			 System.out.println("Save customer fail!!!");
			 printValidationErrors(e);
		 } catch (Exception e) {
				e.printStackTrace();
		 }
		 
		 // Reservation saving
		 List<Room> rooms = new ArrayList<>();
		 Room room = roomService.findRoomById((long)1);
		 rooms.add(room);		 
		 Reservation  reservation =  new Reservation();
		 reservation.setCustomer(customer);
		 reservation.setRooms(rooms);
		 reservation.setCheckInDate(new Date());
		 //reservationService.save(reservation);
		 customerService.update(customer);
		 
		 // Load customer with id 1
		 Customer cus1 = customerService.findCustomerById((long)1);
		 System.out.println("size of room booking is " + cus1.getReservations().size());
	}
	
	/**
	 * This method is used to print all validation error messages in console
	 * @param e
	 */
	public void printValidationErrors(ValidationException e) {
		String text = " \n";
		List<FieldError> fieldErrors = e.getErrors().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			text += messageAccessor.getMessage(fieldError) + "\n";
			System.err.println(text);
		}
	}
	
	/**
	 * Main class to run
	 * @param args
	 */
	public static void main(String[] args) {
			
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "context/applicationContext.xml", "context/security-Context.xml" );

		AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");
		TestServiceLayer test = (TestServiceLayer)ctx.getBean("testServiceLayer");
		//test.testUserAuthenticationSaving();
		while (true) {    
		     AuthenticateUser authenticateUser = new AuthenticateUser();
		     try {
		  		authenticateUser.authenticate(authenticationManager);
		  	} catch (Exception e) {
		  		// TODO Auto-generated catch block
		  		e.printStackTrace();
		  	}
			test.testAddDefaultData();		
		    System.out.println("Test Saving group and related fields!!!");
		}    
	}

}
