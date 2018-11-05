package com.legendfarmer.ecomm.domain.security;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority, Serializable{

	private static final long serialVersionUID = 323248L;
	
	private final String authority;
	
	public Authority(String auth){
		authority = auth;
	}
	
	@Override
	public String getAuthority() {
		return authority;
	}

}
