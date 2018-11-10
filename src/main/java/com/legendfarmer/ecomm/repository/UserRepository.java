package com.legendfarmer.ecomm.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.legendfarmer.ecomm.domain.User;


public interface UserRepository extends CrudRepository<User, Long>{

	User findByusername(String username);
	User findByemail(String email);
	List<User> findAll();
}
