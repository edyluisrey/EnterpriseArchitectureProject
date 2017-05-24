package edu.mum.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.mum.domain.Address;
import edu.mum.domain.Authority;
import edu.mum.domain.Customer;
import edu.mum.domain.Group;
import edu.mum.domain.Reservation;
import edu.mum.domain.Room;
import edu.mum.domain.RoomType;
import edu.mum.domain.User;
import edu.mum.domain.UserCredential;
import edu.mum.domain.status.CustomerStatus;
import edu.mum.domain.status.ReservationStatus;
import edu.mum.service.CustomerService;
import edu.mum.service.GroupService;
import edu.mum.service.ReservationService;
import edu.mum.service.RoomService;
import edu.mum.service.RoomTypeService;
import edu.mum.service.UserService;
import edu.mum.service.impl.GroupServiceImpl;

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
		RoomType familyType = new RoomType();
		familyType.setRoomTypeName("Family");
		RoomType doubleType = new RoomType();
		doubleType.setRoomTypeName("Double");
		
		roomTypeService.save(familyType);
		roomTypeService.save(doubleType);
		
		Room r001 = new Room();
		r001.setRoomName("001");
		r001.setPrice(50.0);
		r001.setRoomType(familyType);
		Room r002 = new Room();
		r002.setRoomName("002");
		r002.setPrice(25.0);
		r002.setRoomType(doubleType);
		roomService.save(r001);
		roomService.save(r002);	
		
		// Get room type
		//RoomType roomType = roomTypeService.findRoomTypeById((long)1);
		//System.out.println("Number of room for roomType Family is " + roomType.getRoomTypeName());
		
		Customer cus1 = new Customer();
		cus1.setFirstName("John");
		cus1.setLastName("Dear");
		cus1.setCustomerStatus(CustomerStatus.VIP);
		
		customerService.save(cus1);
		
		Reservation re1 = new Reservation();
		re1.setReservationStatus(ReservationStatus.NOT_CONFIRMED);
		re1.setCustomer(customerService.findCustomerById((long)1));
		re1.addRoom(roomService.findRoomById((long)1));
		Calendar checkInDate = Calendar.getInstance();
		checkInDate.set(2015,  05, 24);
		re1.setCheckInDate(checkInDate.getTime());
		Calendar checkOutDate = Calendar.getInstance();
		checkOutDate.set(2015,  05, 26);
		re1.setCheckOutDate(checkOutDate.getTime());
		reservationService.save(re1);
	}
	
	public static void main(String[] args) {
			
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
		        "context/applicationContext.xml");
		
		TestServiceLayer test = (TestServiceLayer)ctx.getBean("testServiceLayer");
		test.testUserAuthenticationSaving();
		test.testAddDefaultData();
		System.out.println("Test Saving group and related fields!!!");
	}

}
