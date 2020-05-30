package com.niit.LibroWorldFront.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Libroworld.DAO.ICartDAO;
import com.niit.Libroworld.DAO.ICustomerDAO;
import com.niit.Libroworld.Model.Cart;
import com.niit.Libroworld.Model.Customer;
@Controller
public class LoginController {
	@Autowired
	ICustomerDAO customerdao;
	@Autowired
	ICartDAO cartdao;
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
	String loginSuccess( Model model,HttpSession session) 
	{
		String userid=SecurityContextHolder.getContext().getAuthentication().getName();
		String role=SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		if(role.equals("[ROLE_ADMIN]"))
		{
			Customer customer=customerdao.selectCustomer(userid);
			session.setAttribute("username","ADMINISTRATOR");
			session.setAttribute("adminrole",true);
			session.setAttribute("userrole",true);
		}
		else
		{
			Customer customer=customerdao.selectCustomer(userid);
			session.setAttribute("custdetails", customer);
			session.setAttribute("username",customer.getCust_Name().toUpperCase());
			session.setAttribute("adminrole", false);
			session.setAttribute("userrole", true);
			float total=0;
			ArrayList<Cart> cartlist=cartdao.allcart(customer);
			Iterator<Cart> cartIterator=cartlist.iterator();
			while(cartIterator.hasNext())
			{
				Cart cart=(Cart)  cartIterator.next();
				total=total+(cart.getPro_Quantity()*cart.getProdDetails().getPrice());
			}
			session.setAttribute("total",total);
			session.setAttribute("cartinfo", cartlist);
			session.setAttribute("cartqty", cartlist.size());
			if(session.getAttribute("prodid")!=null){
				int prodid=Integer.parseInt(session.getAttribute("prodid").toString());
				int qty=Integer.parseInt(session.getAttribute("qty").toString());
				return "redirect:/addtocart?productid="+prodid+"&quantity="+qty;
			}
		}
		model.addAttribute("indexpage", true);
		return "index";
	}
}
			

