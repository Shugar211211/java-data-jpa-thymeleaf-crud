package com.crm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// method to sort by last name
	public List<User> findAllByOrderByLastNameAsc();
}
