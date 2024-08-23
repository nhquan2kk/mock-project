package com.springmvc.mock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mock.models.Role;
import com.springmvc.mock.repositories.RoleRepository;

@Service
public class AdminRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAllRole(){
		return roleRepository.findAll();
	}
	
	public Role getRoleById(Long id) {
		return roleRepository.findById(id).orElse(null);
	}
	
	public void saveRole(Role role) {
		roleRepository.save(role);
	}
	
	public void deleteRole(Long id) {
		roleRepository.deleteById(id);
	}
}
