package com.springmvc.mock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.mock.models.Role;
import com.springmvc.mock.services.AdminRoleService;


@Controller
@RequestMapping("/role")
public class AdminRoleController {
	
	@Autowired
	private AdminRoleService adminRoleService;
	
	@GetMapping("/createroleform")
	public String showCreateForm() {
		return "adminCreateRole";
	}

	
	@GetMapping("/listrole")
	public String listRole(Model model) {
		List<Role> roles = adminRoleService.getAllRole();
		model.addAttribute("roles", roles);
		return "listRole";
	}
	
	@PostMapping("/createrole")
	public String createRole(
			@ModelAttribute Role role
			) {
		adminRoleService.saveRole(role);
		
		return "redirect:/role/listrole";
	}
	
	@PostMapping("/updaterole")
	public String updateRole(
			@RequestParam("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("description") String description
			) {
		Role role = adminRoleService.getRoleById(id);
		if(role != null) {
			role.setName(name);
			role.setDescription(description);
			adminRoleService.saveRole(role);
		}
		return "redirect:/role/listrole";
	}
	
	@PostMapping("/delrole")
	public String delRole(@RequestParam("id") Long id) {
		adminRoleService.deleteRole(id);
		return "redirect:/role/listrole";
	}
	
}
