package com.bus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bus.entity.Booking;
import com.bus.entity.Bus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
public class BookingRepository {
	
	@Autowired
    private EntityManager entityManager;
	
	@Transactional
    public void save(Booking book) {
        entityManager.persist(book);
    }
	
	public List<Booking> findAll() {
        return entityManager.createQuery("SELECT book FROM Booking book", Booking.class).getResultList();
    }

	public Booking findById(Integer id) {
		 return entityManager.find(Booking.class, id);
	}
	

}
