package com.legendfarmer.ecomm.config;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtility {
	private static final String SALT = "323rldkjf#432!@!3";
	
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12, new SecureRandom(SALT.getBytes()));
	}
	
	@Bean
	public static String randomPassword() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random randNum = new Random();
		while(salt.length()<18) {
			int idx = (int) (randNum.nextFloat()*SALTCHARS.length());
			salt.append(SALTCHARS.charAt(idx));
		}
		return salt.toString();
	}
}
