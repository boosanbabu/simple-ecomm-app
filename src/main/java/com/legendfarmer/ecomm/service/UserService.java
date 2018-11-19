package com.legendfarmer.ecomm.service;


import java.util.Set;

import com.legendfarmer.ecomm.domain.User;
import com.legendfarmer.ecomm.domain.security.UserRole;


public interface UserService {

	User createUser(User user, Set<UserRole> userRoles);

	User findByUsername(String username);
	
	User findByEmail (String email);
	
	User save(User user);
	
	User findById(Long id);
	
}