package com.pramila.javaproject.controller;

import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pramila.javaproject.model.User;
import com.pramila.javaproject.services.UserService;

@Controller
public class UserController {
	
	 private final UserService userService;
	 
	 public UserController(UserService userService) {
	     this.userService = userService;
	 }
	 @RequestMapping("/")
	 public String index( @ModelAttribute("user") User user) {
		 return "login.jsp";
	 }
	 
	 @RequestMapping("/registration")
	 public String registerForm(@ModelAttribute("user") User user) {
	     return "homePage.jsp";
	 }
	 @RequestMapping("/login")
	 public String login() {
	     return "homePage.jsp";
	 }
	 
	 @RequestMapping(value = "/registration", method = RequestMethod.POST)
		public String registerUser(Model model, @Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, RedirectAttributes attribute) {
			
			if (result.hasErrors()) {
				return "login.jsp";
			} else if (userService.checkUser(user.getEmail())) {
				attribute.addFlashAttribute("registrationError", "User already exists");
				return "redirect:/";
			} else if (!user.getPassword().equals(user.getConfirmpassword())) {
				attribute.addFlashAttribute("registrationError", "Passwords do not match");
				return "redirect:/";
			} else {
				User new_user = userService.registerUser(user);
				session.setAttribute("loggedIn", user);
				session.setAttribute("user_id", new_user.getId());
				return "redirect:/home";
			}
		}
	 
	 @RequestMapping(value="/login", method=RequestMethod.POST)
	 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session,RedirectAttributes attribute) {
	     // if the user is authenticated, save their user id in session
	     // else, add error messages and return the login page
		 if (email.length() < 1) {
				attribute.addFlashAttribute("loginError", "Must enter an email");
				return "redirect:/";
			} else if (password.length() < 1) {
				attribute.addFlashAttribute("loginError", "Must enter a password");
				return "redirect:/";
			} else if (userService.authenticateUser(email, password)) {
				User user = userService.findByEmail(email);
				if (user == null) {
					attribute.addFlashAttribute("loginError", "User does not exist");
				} else {
					session.setAttribute("user_id", user.getId());
					session.setAttribute("loggedIn", true);
					return "redirect:/home";
				}                                                                                      
			} else {
				attribute.addFlashAttribute("loginError", "Invalid Password");
			}
			return "redirect:/";
		}
	 

	 


}
