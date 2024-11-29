package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller

public class HomeController {
	
	@RequestMapping("/display")
	public ModelAndView showHome(@RequestParam(name = "n1", required = true, defaultValue = "0") int num1,
            @RequestParam(name = "n2", required = true, defaultValue = "0") int num2) {
		int sum = num1 + num2;
		 System.out.println("**************************************************" + sum);
		 ModelAndView mv = new ModelAndView();
		 
		 mv.setViewName("home.jsp");
		 mv.addObject("sum", sum);
		
		return mv;
	}

}

