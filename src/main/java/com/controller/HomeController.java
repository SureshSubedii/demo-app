package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@GetMapping("/display")
	public String showHome(@RequestParam(name = "n1", required = true, defaultValue = "0") int num1,
            @RequestParam(name = "n2", required = true, defaultValue = "0") int num2, Model model ) {
		int sum = num1 + num2;
		 System.out.println("**************************************************" + sum);

		 
		    model.addAttribute("sum", sum);
		    model.addAttribute("message", "THis is the message");


		
		return "home";
	}

}

