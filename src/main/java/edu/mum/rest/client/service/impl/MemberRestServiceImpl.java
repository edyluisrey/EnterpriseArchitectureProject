package edu.mum.rest.client.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import edu.mum.domain.Reservation;
import edu.mum.rest.client.RestHttpHeader;
import edu.mum.rest.client.service.ReservationRestService;


@Component
public class MemberRestServiceImpl implements ReservationRestService {

	@Autowired
	RestHttpHeader restHttpHeader;
	
	public List<Reservation> findAll() {		
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		return Arrays.asList(restTemplate.exchange("http://localhost:8080/EnterpriseArchitectureProject/api/reservations/", HttpMethod.GET, restHttpHeader.getHttpEntity(), Reservation[].class).getBody());
 	}

	public Reservation getReservationById(Long id) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
 		return (restTemplate.exchange("http://localhost:8080/EnterpriseArchitectureProject/api/reservations/"+ id, HttpMethod.GET, restHttpHeader.getHttpEntity(), Reservation.class).getBody());
	}

	public void save(Reservation reservation) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		HttpEntity<Reservation> httpEntity = new HttpEntity<Reservation>(reservation, restHttpHeader.getHttpHeaders());
		restTemplate.postForObject("http://localhost:8080/EnterpriseArchitectureProject/api/reservations/add/", httpEntity, Reservation.class);
	}

	public void updateReservation(Reservation reservation) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate(); 
		HttpEntity<Reservation> httpEntity = new HttpEntity<Reservation>(reservation, restHttpHeader.getHttpHeaders());
		restTemplate.exchange("http://localhost:8080/EnterpriseArchitectureProject/api/reservations/update/", HttpMethod.PUT, httpEntity, Reservation.class);		
	}

	public void deleteReservation(Long id) {
		RestTemplate restTemplate = restHttpHeader.getRestTemplate();
		restTemplate.exchange("http://localhost:8080/EnterpriseArchitectureProject/api/reservations/delete/"+ id, HttpMethod.DELETE, restHttpHeader.getHttpEntity(), Reservation.class);		
	}

}
