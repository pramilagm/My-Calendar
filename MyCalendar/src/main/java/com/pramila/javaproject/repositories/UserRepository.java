package com.pramila.javaproject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.pramila.javaproject.model.User;

public interface UserRepository extends CrudRepository <User,Long> {

	User findByEmail(String email);
	

}
