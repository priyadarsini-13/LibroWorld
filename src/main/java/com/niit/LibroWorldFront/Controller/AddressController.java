package com.niit.LibroWorldFront.Controller;


import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Libroworld.DAO.IAddressDAO;
import com.niit.Libroworld.Model.Address;
import com.niit.Libroworld.Model.Customer;




@Controller
@RequestMapping("/user")
public class AddressController {

	@Autowired
	IAddressDAO addressdao;
	
	@RequestMapping("/selectaddress")
	String addressPage(Model model,HttpSession session)
	{
		
		Customer customer=(Customer)session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(customer));
		model.addAttribute("addressobject", new Address());
		return "index";
	}

	@RequestMapping("/addaddress")
	String addaddressPage(@RequestParam Map<String, String> addressmodel,Model model,HttpSession session)
	{
		
		model.addAttribute("addresspage", true);
		Customer cust=(Customer)session.getAttribute("custdetails");
		Address address=new Address();
		address.setArea(addressmodel.get("area"));
		address.setCustomer(cust);
		address.setLine1(addressmodel.get("line1"));
		address.setLine2(addressmodel.get("line2"));
		address.setName(addressmodel.get("name"));
		address.setPincode(Integer.parseInt(addressmodel.get("pincode")));
		System.out.println(addressmodel.get("pincode"));
		try
		{
		if(addressdao.addAddress(address))
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Inserted");
			
			System.out.println("added");
		}
		else
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not  Inserted");
			System.out.println("failed");
			
		}
		}
		catch(Exception e) 
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not  Inserted");
			System.out.println("catch");
		}
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		return "index";
	}
	@RequestMapping("/deleteaddress")
	String deleteAddress(@RequestParam("addressid") int addressid,Model model,HttpSession session)
	{
		try
		{
			
			if(addressdao.deleteAddress(addressdao.oneAddress(addressid)))
			{
				model.addAttribute("info",true);
				model.addAttribute("message","Data Deleted");
				System.out.println("deleted");
			}
			else
			{
				model.addAttribute("info",true);
				model.addAttribute("message","Data Not Deleted");
				System.out.println("notdeleted");
			}
				
			
		}
		catch (Exception e)
		{
			model.addAttribute("info",true);
			model.addAttribute("message","Data Deleted");
			System.out.println("catch");
		}
		
		Customer cust=(Customer)session.getAttribute("custdetails");

		model.addAttribute("addresslist", addressdao.allAddress(cust));
		model.addAttribute("addresspage", true);
		return "index";
		}
	@RequestMapping("/editaddress")
	String editAddress(@RequestParam("addressid")int addressid,Model model,HttpSession session)
	{
		model.addAttribute("edit", true);
		Customer cust=(Customer)session.getAttribute("custdetails");
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		model.addAttribute("addressobject", addressdao.oneAddress(addressid));
		System.out.println( addressdao.oneAddress(addressid).getArea());
		
		return "index";
	}
	@RequestMapping("/updateaddress")
	String updateaddressPage(@RequestParam Map<String, String> addressmodel,Model model,HttpSession session)
	{
		Customer cust=(Customer)session.getAttribute("custdetails");
		Address address=new Address();
		address.setAddress_Id(Integer.parseInt(addressmodel.get("addressid")));
		address.setArea(addressmodel.get("area"));
		address.setCustomer(cust);
		address.setLine1(addressmodel.get("line1"));
		address.setLine2(addressmodel.get("line2"));
		address.setName(addressmodel.get("name"));
		address.setPincode(Integer.parseInt(addressmodel.get("pincode")));
		try
		{
		if(addressdao.updateAddress(address))
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Updated");
			System.out.println("updated");
			model.addAttribute("addressobject", address);
			
		}
		else
		{
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not Updated");
			System.out.println("not updated");
			model.addAttribute("addressobject", address);
		}
		}
		catch(Exception e) 
		{
			model.addAttribute("addressobject", address);
			model.addAttribute("info", true);
			model.addAttribute("message","Address Not  Inserted");
			System.out.println("catch");
		}
		model.addAttribute("addresspage", true);
		model.addAttribute("addresslist", addressdao.allAddress(cust));
		return "index";
	}
	
}