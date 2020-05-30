package com.niit.LibroWorldFront.Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Libroworld.DAO.ICartDAO;
import com.niit.Libroworld.DAO.IProductDAO;
import com.niit.Libroworld.Model.Cart;
import com.niit.Libroworld.Model.Customer;
import com.niit.Libroworld.Model.Product;

@Controller
public class CartController {

	@Autowired
	IProductDAO productdao;

	@Autowired
	ICartDAO cartdao;

	@RequestMapping("/addtocart")

	String addToCart(@RequestParam("productid") int prodid,
			@RequestParam(required = false, value = "quantity", defaultValue = "1") int qty,
			@RequestParam(value = "cartpage", required = false, defaultValue = "false") boolean cartpage, Model model,
			HttpSession session) {
		Customer customer = (Customer) session.getAttribute("custdetails");

		if (session.getAttribute("cartinfo") == null)
		{
			session.setAttribute("prodid", prodid);
			session.setAttribute("qty", qty);
			model.addAttribute("loginpage", true);
		} else {
			Cart item = new Cart();
			Product product = productdao.oneProduct(prodid);
			ArrayList<Cart> cartlist = (ArrayList<Cart>) session.getAttribute("cartinfo");
			if (cartlist.isEmpty()) {
				item.setCustDetails(customer);
				item.setProdDetails(product);
				if (product.getStock() >= qty) {
					item.setPro_Quantity(qty);
				} else {
					item.setPro_Quantity(1);
					model.addAttribute("error", true);
					model.addAttribute("message", "Stock Insufficient");
					model.addAttribute("prodid", product.getPro_Id());
				}
				cartdao.addCart(item);
			} else {
				int flag = 1;
				Iterator<Cart> cartitem = cartlist.listIterator();
				while (cartitem.hasNext()) {
					Cart item1 = (Cart) cartitem.next();
					if (item1.getProdDetails().getPro_Id() == prodid) {
						if (cartpage) {
							if (qty > product.getStock()) {

								model.addAttribute("error", true);
								model.addAttribute("message", "Stock Insufficient");
								model.addAttribute("prodid", product.getPro_Id());
							} else {
								item1.setPro_Quantity(qty);
								cartdao.updateCart(item1);
							}
						} else {
							int oldqty = item1.getPro_Quantity();
							int newqty = oldqty + qty;
							if (newqty > product.getStock()) {
								model.addAttribute("error", true);
								model.addAttribute("message", "Stock insufficent");
								model.addAttribute("prodid", product.getPro_Id());
							} else {
								item1.setPro_Quantity(newqty);
								cartdao.updateCart(item1);
							}
						}
						flag = 0;
						break;
					}

				}
				if (flag == 1) {
					item.setCustDetails(customer);
					item.setProdDetails(product);
					if (product.getStock() >= qty) {
						item.setPro_Quantity(qty);
					} else {
						model.addAttribute("error", true);
						model.addAttribute("message", "Stock Insufficient");
						model.addAttribute("prodid", product.getPro_Id());
					}
					cartdao.addCart(item);
				}
			}
			float total = 0;
			cartlist = cartdao.allcart(customer);
			session.setAttribute("cartinfo", cartlist);
			session.setAttribute("cartqty", cartlist.size());
			model.addAttribute("cartpage", true);

		}

		return "index";
	}

	@RequestMapping("/user/viewcart")
	String viewcart(HttpSession session, Model m) {
		if(session.getAttribute("cartinfo")==null) {
			
		
		Customer cust = (Customer) session.getAttribute("custdetails");
		float total=0;
		ArrayList<Cart> cartlist=cartdao.allcart(cust);
		Iterator<Cart> cartIterator=cartlist.iterator();
		while(cartIterator.hasNext())
		{
			Cart cart=(Cart)  cartIterator.next();
			total=total+(cart.getPro_Quantity()*cart.getProdDetails().getPrice());
		}
		session.setAttribute("total",total);
		session.setAttribute("cartinfo", cartdao.allcart(cust));
		session.setAttribute("cartqty", cartdao.allcart(cust).size());
		}
		m.addAttribute("cartpage", true);
		return "index";
	}

	@RequestMapping("user/deleteitem")

	String deleteCart(@RequestParam("cartid") int cartid, HttpSession session) {
		Customer customer = (Customer) session.getAttribute("custdetails");
		cartdao.deleteCart(cartdao.oneCart(cartid));
		session.setAttribute("cartinfo", cartdao.allcart(customer));
		return "redirect:/user/viewcart";
	}
}
