package org.jsp.jsp_gram.controller;

import org.jsp.jsp_gram.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class AppController {
	@GetMapping({"/","/login"})
	public String loadLogin() {
		return "login.html";
	}

	@GetMapping("/register")
	public String loadRegister(ModelMap map,User user) {
		map.put("user", user);
		return "register.html";
	}
	
	@PostMapping("/register")
	public String register(@Valid User user,BindingResult result) {
		if(!user.getPassword().equals(user.getConfirmpassword()))
			result.rejectValue("confirmpassword", "error.confirmpassword", "Passwords not Matching");
			
		if(result.hasErrors()) {
			return "register.html";
		}
		else {
		System.err.println(user);
		return "redirect:https://www.youtube.com";
		}
	}
}
