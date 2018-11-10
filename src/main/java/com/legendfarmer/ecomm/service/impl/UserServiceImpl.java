package com.legendfarmer.ecomm.service.impl;

import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.legendfarmer.ecomm.domain.User;
import com.legendfarmer.ecomm.domain.security.UserRole;
import com.legendfarmer.ecomm.repository.RoleRepository;
import com.legendfarmer.ecomm.repository.UserRepository;
import com.legendfarmer.ecomm.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	public User createUser(User user, Set<UserRole> userRoles) {
		User localUser = userRepository.findByusername(user.getUsername());
		
		if(localUser != null) {
			LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
		} else {
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			localUser = userRepository.save(user);
		}
		
		return localUser;
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByusername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByemail(email);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findOne(id);
	}

}
