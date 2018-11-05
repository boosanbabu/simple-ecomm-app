package com.legendfarmer.ecomm.domain.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role implements Serializable {
	
	private static final long serialVersionUID = 32848121L;
	
	public Role() {	
	}
	
	
	@Id
	private Long roleId;
	private String name;
	
	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
	private Set<UserRole> userRoles = new HashSet<>();
	
	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
}