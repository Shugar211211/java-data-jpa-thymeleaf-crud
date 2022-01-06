package com.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crm.entities.User;
import com.crm.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/list")
	public String listUsers(Model theModel) {
		List<User> allUsers = userService.findAll();
		theModel.addAttribute("users", allUsers);
		return "users/list-users";
	}
	
	@GetMapping("/add")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		User theUser = new User();
		theModel.addAttribute("user", theUser);
		return "users/user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User theUser) {
		// save the user
		userService.save(theUser);
		// use redirect to prevent duplicate submissions
		return "redirect:/users/list";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("userId")int theId, Model theModel) {
		// get the user from the service
		User theUser = userService.findById(theId);
		// set user as a model attribute to pre-populate the form
		theModel.addAttribute("user", theUser);
		// sens over to the form
		return "users/user-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("userId")int theId) {
		// delete user
		userService.deleteById(theId);
		// redirect to /users/list
		return "redirect:/users/list";
	}
}
