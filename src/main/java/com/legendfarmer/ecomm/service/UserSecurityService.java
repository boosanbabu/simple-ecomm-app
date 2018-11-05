package com.legendfarmer.ecomm.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.legendfarmer.ecomm.domain.User;
import com.legendfarmer.ecomm.repository.UserRepository;

public class UserSecurityService implements UserDetailsService{

	private static final Logger LOGGER = LoggerFactory.getLogger(UserSecurityService.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) 
							throws UsernameNotFoundException {
		User user = userRepo.findByusername(username);
		if(null==user) {
			LOGGER.debug("User name is null");
			throw new UsernameNotFoundException("User " + user + " is not found");
		}
		return user;
	}
	
	@Autowired
	private UserRepository userRepo;

}
