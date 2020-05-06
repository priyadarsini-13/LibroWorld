package com.niit.LibroWorldFront.Controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	 
	  @RequestMapping(value={"/","/home"})
		String IndexPage(Model model) {
			
			model.addAttribute("indexpage",true);
			model.addAttribute("title","LibroWorld");
			return "index";
		}
		
		@RequestMapping("/aboutus")
		String abouotusPage(Model model)
		{
			model.addAttribute("aboutuspage",true);
			model.addAttribute("title","AboutUs");
			return "index";
		}
		

		@RequestMapping("/contactus")
		String contactusPage(Model model)
		{
			model.addAttribute("contactus",true);
			model.addAttribute("title","ContactUs");
			return "index";
		}
		

		@RequestMapping("/login")
		String loginPage(Model model)
		{
			model.addAttribute("loginpage",true);
			model.addAttribute("title","Login");
			return "index";
		}
		

		
		
	}
