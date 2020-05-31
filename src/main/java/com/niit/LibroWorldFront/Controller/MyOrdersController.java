package com.niit.LibroWorldFront.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Libroworld.DAO.IAddressDAO;
import com.niit.Libroworld.DAO.ICartDAO;
import com.niit.Libroworld.DAO.IMyOrdersDAO;
import com.niit.Libroworld.DAO.IProductDAO;
import com.niit.Libroworld.Model.Address;
import com.niit.Libroworld.Model.Cart;
import com.niit.Libroworld.Model.Customer;
import com.niit.Libroworld.Model.MyOrders;
import com.niit.Libroworld.Model.Product;

@Controller
public class MyOrdersController {

	@Autowired
	IAddressDAO addressdao;

	@Autowired
	IMyOrdersDAO myordersdao;
	@Autowired
	IProductDAO productdao;

	@Autowired
	ICartDAO cartdao;

	

	@RequestMapping("/user/placeorder")
	String placeOrder(@RequestParam("addressid") int addressid, HttpSession session, Model model) {

		MyOrders myorders = new MyOrders();
		ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cartinfo");
		Address address = addressdao.oneAddress(addressid);
		float total = Float.parseFloat(session.getAttribute("total").toString());
		System.out.println(total);
		Customer customer = (Customer) session.getAttribute("custdetails");
		String orderid = "OD" + UUID.randomUUID().getMostSignificantBits();
		Iterator<Cart> cartIterator = cartlist.iterator();
		while (cartIterator.hasNext()) {
			Cart cart = (Cart) cartIterator.next();
			myorders.setAddress(address);
			myorders.setCust_Details(customer);
			myorders.setOrder_Id(orderid);
			myorders.setProd_Details(cart.getProdDetails());
			myorders.setProdqty(cart.getPro_Quantity());
			myorders.setOrder_date(new Date());
			myorders.setOrder_total(total);
			Product product = cart.getProdDetails();
			if(product.getStock()>cart.getPro_Quantity() && myordersdao.addMyOrder(myorders))
			{
				product.setStock(product.getStock() - cart.getPro_Quantity());
				productdao.updateProduct(product);
				cartdao.deleteCart(cart);
				
			}
		}
		
		return "redirect:/user/viewallorders";

	}

	@RequestMapping("/user/viewallorders")
	String viewOrders(HttpSession session, Model model) {
		Customer cust = (Customer) session.getAttribute("custdetails");
		ArrayList<MyOrders> orders = myordersdao.allMyOrder(cust);
		session.setAttribute("cartinfo", cartdao.allcart(cust));
		session.setAttribute("cartqty", cartdao.allcart(cust).size());
		model.addAttribute("orderlist", orders);
		model.addAttribute("orderpage", true);
		return "index";

	}
	@RequestMapping("/user/viewdetails")
	String viewOrders(@RequestParam("oid")String orderid, Model model) {	
		ArrayList<MyOrders> orders = myordersdao.oneMyOrder(orderid);
		model.addAttribute("orderlist", orders);
		model.addAttribute("oneorderpage", true);
		return "index";

}
}
