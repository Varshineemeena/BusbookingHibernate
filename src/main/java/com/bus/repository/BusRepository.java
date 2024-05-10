package com.bus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bus.entity.Booking;
import com.bus.entity.Bus;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class BusRepository{
	
	@Autowired
    private EntityManager entityManager;
	
	@Transactional
    public void save(Bus bus) {
        entityManager.persist(bus);
    }
	
	public List<Bus> findAll() {
        return entityManager.createQuery("SELECT bus FROM Bus bus", Bus.class).getResultList();
    }


}
