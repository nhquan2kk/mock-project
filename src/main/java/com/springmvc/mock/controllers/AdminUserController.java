package com.springmvc.mock.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.mock.models.Role;
import com.springmvc.mock.models.User;
import com.springmvc.mock.services.AdminRoleService;
import com.springmvc.mock.services.AdminUserService;


@Controller
@RequestMapping("/users")
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;
	
	@Autowired
	private AdminRoleService adminRoleService;
	

	@GetMapping
	public String getAllUser(Model model) {
		List<User> users = adminUserService.getAllUser();
		List<Role> roles = adminRoleService.getAllRole();
		model.addAttribute("users", users);
		model.addAttribute("roles", roles);
		return "listUser";
	}
	
	@GetMapping("/create")
	public String getCreateForm(Model model) {
	    List<Role> roles = adminRoleService.getAllRole();
	    model.addAttribute("roles", roles);  
	    model.addAttribute("user", new User());
	    return "adminCreateUser";  
	}
	
	@PostMapping("/save")
	public String saveUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName,
            @RequestParam("address") String address,
            @RequestParam("telephone") String telephone,
            @RequestParam("avatar") MultipartFile file,
            @RequestParam("role.id") Long roleId) {
		try {
			User user = new User();
		    user.setUsername(username);
            user.setPassword(password);
            user.setFirst_name(firstName);
            user.setLast_name(lastName);
            user.setAddress(address);
            user.setTelephone(telephone);
            user.setRole(adminRoleService.getRoleById(roleId));

		 	  adminUserService.saveUser(user, file);
	    }catch(IOException e){
	    	e.printStackTrace();
	    }
		return "redirect:/users";
	}
	
	@PostMapping("/update")
	public String updateUser(
			@RequestParam("id") Long id,
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName,
            @RequestParam("address") String address,
            @RequestParam("telephone") String telephone,
            @RequestParam("avatar") MultipartFile file,
            @RequestParam("role.id") Long roleId
			) {
		try {
			User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setFirst_name(firstName);
            user.setLast_name(lastName);
            user.setAddress(address);
            user.setTelephone(telephone);
            user.setRole(adminRoleService.getRoleById(roleId));
        
            adminUserService.saveUser(user, file);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/users";
	}

	@PostMapping("/deluser")
	public String deleteUser(@RequestParam("id") Long id) {
		adminUserService.deleteUser(id);
		return "redirect:/users";
	}
	
}
