package com.legendfarmer.ecomm.repository;

import org.springframework.data.repository.CrudRepository;

import com.legendfarmer.ecomm.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{

}
