package com.niit.LibroWorldFront.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class LoginController {
	@RequestMapping("/login")
	String loginPage(@RequestParam(value="error",required=false,defaultValue="false") boolean error, Model model)
	{
		if(error) {
			model.addAttribute("info",true);
			model.addAttribute("message","username password incorrect");
		}
		else
		{
			model.addAttribute("info",false);
			model.addAttribute("message","");
		}
		model.addAttribute("loginpage",true);
		model.addAttribute("title","Login");
		return "index";
	}
	@RequestMapping("/loginsuccess")
	String loginSuccess( Model model,HttpSession session) {
		String userid=SecurityContextHolder.getContext().getAuthentication().getName();
		String role=SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		if(role.equals("[ROLE_ADMIN]"))
		{
			session.setAttribute("username","ADMINISTRATOR");
			session.setAttribute("adminrole",true);
		}
		else
		{
	}
		model.addAttribute("indexpage",true);
		return"index";
}
}
