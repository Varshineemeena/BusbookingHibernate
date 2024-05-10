package com.bus.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bus.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class UserRepository{
	
	
	@Autowired
    private EntityManager entityManager;
	
	@Transactional
    public void save(User user) {
        entityManager.persist(user);
    }
	
	public List<User> findAll() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }



}
