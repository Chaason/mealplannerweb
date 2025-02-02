package com.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/") 
	public String home() { 
		logger.debug("HomeController: home method called"); 
		return "index"; 
	}

    @GetMapping("/login")
    public String login() {
        return "login"; 
    }
    @ExceptionHandler(Exception.class) 
    public String handleException(Exception e, Model model) { 
    	logger.error("Error occurred:", e);
    	model.addAttribute("errorMessage", e.getMessage()); 
    return "error"; // error.html テンプレートにリダイレクト }
    }
}

