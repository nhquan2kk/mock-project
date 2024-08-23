package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
