package com.springmvc.mock.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.mock.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
