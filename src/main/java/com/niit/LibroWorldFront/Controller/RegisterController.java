package com.niit.LibroWorldFront.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Libroworld.DAO.ICustomerDAO;
import com.niit.Libroworld.Model.Customer;




@Controller
public class RegisterController {
	@Autowired
	ICustomerDAO customerdao;
	@RequestMapping("/register")
	String RegisterPage(Model model) {
		model.addAttribute("registerpage", true);
		model.addAttribute("customerobject",new Customer());
		model.addAttribute("title", "register");
		return "index";
	}

	@RequestMapping("/addcustomer")
	String addRegisterPage(@Valid@ModelAttribute("customerobject") Customer customer, BindingResult br,Model model) {
		try {
			if(br.hasErrors()) {
				model.addAttribute("info", true);
				model.addAttribute("message", "Please Enter Data In correct Format");
				model.addAttribute("customerobject",customer);
				System.out.println("Done");	
			}
			else {
			if (customerdao.addCustomer(customer)) {
				model.addAttribute("info", true);
				model.addAttribute("message", "Added");
				System.out.println("Done");

			} else {
				model.addAttribute("info", true);
				model.addAttribute("message", "checkData");
				System.out.println("Failure");
			}
			}
		} catch (Exception e) {
			model.addAttribute("info", true);
			model.addAttribute("message", "checkData");
			System.out.println("Failure");

		}
		model.addAttribute("registerpage", true);
		model.addAttribute("customerobject", new Customer());
		model.addAttribute("title", "register");
		return "index";
	}
}
