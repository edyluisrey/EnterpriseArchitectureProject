package edu.mum.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.domain.Customer;
import edu.mum.domain.Reservation;
import edu.mum.domain.Room;
import edu.mum.rest.client.service.ReservationRestService;
import edu.mum.service.ReservationService;

@Component
public class TestRestFull {
    
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	ReservationRestService reservationRestService;
	
	public static void main(String[] args) {
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
		        "context/applicationContext.xml");
		 applicationContext.getBean(TestRestFull.class).mainInternal(applicationContext);
        
	}
	
	private void mainInternal(ApplicationContext applicationContext) {
		 
		 Customer  customer = new Customer();
		 customer.setFirstName("Edy");
		 customer.setLastName("Aguirre Rest");
		 customer.setPassport("5677884");
		 
		 List<Room> rooms = new ArrayList<>();
		 Room room= new Room();
		 room.setFloor("2");
		 room.setRoomNumber("44");
		 rooms.add(room);
		 
		 Reservation  reservation =  new Reservation();
		 reservation.setCustomer(customer);
		 reservation.setRooms(rooms);
		 reservation.setCheckInDate(new Date());
		// reservationService.save(reservation);
		 
		 System.out.println( "   **********  RESTFULL WITH SECURITY  **********");
		 System.out.println( "        ********** REST: Create  Reservation**********");
		 reservationRestService.save(reservation);
		 System.out.println( "  ok");
		 
		 System.out.println( "        ********** REST: List Reservations  **********");
		 List<Reservation> listReservation = (List<Reservation> ) reservationRestService.findAll();
		 for(Reservation tempReservation: listReservation){
			 System.out.println("*** Reserved for:"+ tempReservation.getCustomer().getFirstName() + 
					 " "+ tempReservation.getCustomer().getLastName()+ " Room:"+ tempReservation.getRooms().get(0).getRoomNumber());
		 }
	}

}
