package edu.mum.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.aspect.annotation.Auditor;
import edu.mum.dao.ReservationDao;
import edu.mum.domain.Reservation;
import edu.mum.service.ReservationService;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationDao ReservationDao;
	
	@Auditor
	@Override
	public void save(Reservation Reservation) {
		ReservationDao.save(Reservation);
	}
	
	@Auditor
	@Override
	public void update(Reservation Reservation) {
		ReservationDao.update(Reservation);
	}
    
	@Auditor
	@Override
	public void delete(Reservation Reservation) {
		ReservationDao.delete(Reservation.getId());
	}

	@Override
	public void deleteById(Long ReservationId) {
		ReservationDao.delete(ReservationId);
	}

	@Override
	public Reservation findReservationById(Long ReservationId) {
		return ReservationDao.findOne(ReservationId);
	}

	@Override
	public List<Reservation> findAll() {
		return ReservationDao.findAll();
	}

}
