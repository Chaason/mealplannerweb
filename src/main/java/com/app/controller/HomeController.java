package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login"; 
    }
    @ExceptionHandler(Exception.class) 
    public String handleException(Exception e, Model model) { 
    	model.addAttribute("errorMessage", e.getMessage()); 
    return "error"; // error.html テンプレートにリダイレクト }
    }
}

