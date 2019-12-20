package com.pramila.javaproject.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pramila.javaproject.model.Calendar;
import com.pramila.javaproject.model.User;
import com.pramila.javaproject.repositories.UserRepository;
import com.pramila.javaproject.services.CalendarEventService;
import com.pramila.javaproject.services.UserService;

@Controller
public class HomeController {
	private final UserService userService;
	private final CalendarEventService eventService;
	



//Construtor

	public HomeController(UserService userService, CalendarEventService eventService) {
		this.userService = userService;
		this.eventService = eventService;
	}
	@RequestMapping("/home")
	public String homePage( @ModelAttribute("user") User user,BindingResult result ,Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		 if (userId == null) {
			 return "redirect:/";
			
		 }
		 model.addAttribute("user", userService.findUserById(userId));
		 model.addAttribute("events",eventService.finaAllEvents());
		 return "homePage.jsp";
	}	
//	To show all the Events
	@RequestMapping("/calendar")
	public String showCalendar( @ModelAttribute("event") Calendar event,BindingResult result ,Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("user_id");
		 if (userId == null) {
			 return "redirect:/";
			
		 }
		 model.addAttribute("user", userService.findUserById(userId));
		 model.addAttribute("events", eventService.finaAllEvents());
		 return "calendar.jsp";
	}
	
	 
	 @RequestMapping(value ="/calendar/new/create",method =RequestMethod.POST)
		public String taskCreate(@Valid @ModelAttribute("task") Calendar event, BindingResult result, Model model,HttpSession session) {
			if(result.hasErrors()) {
				 model.addAttribute("users", userService.findAllUser());
				return "/calendar.jsp";
			}
			
			 Long userId = (Long) session.getAttribute("user_id");
			 if (userId == null) {
				 return "redirect:/";
			 }  
			        model.addAttribute("user", userService.findUserById(userId));
		            eventService.createTask(event);
		            return "redirect:/calendar";
		}
	
	
	

}
