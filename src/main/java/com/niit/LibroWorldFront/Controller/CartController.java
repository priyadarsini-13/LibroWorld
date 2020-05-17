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
public class CartController 
{

	@Autowired
	IProductDAO productdao;
	
	@Autowired
	ICartDAO  cartdao;
	
	@RequestMapping("/addtocart")
	String addToCart(@RequestParam("productid") int prodid,@RequestParam(required=false ,value="quantity",defaultValue = "1") int qty,Model model,HttpSession session)
	{
		Customer customer = (Customer)session.getAttribute("custdetails");
		
		if(session.getAttribute("cartinfo")==null)
		{
			session.setAttribute("prodid", prodid);
			session.setAttribute("qty", qty);
		    model.addAttribute("loginpage",true);
		}
		else
		{
			Cart item = new Cart();			
			Product product = productdao.oneProduct(prodid);
			ArrayList<Cart> cartlist =(ArrayList<Cart>)session.getAttribute("cartinfo");
			if(cartlist.isEmpty())
			{
				item.setCustDetails(customer);
				item.setProdDetails(product);
				if(product.getStock()>=qty)
				{
					item.setPro_Quantity(qty);
				}
				else
				{
					model.addAttribute("error",true);
					model.addAttribute("message","Stock Insufficient");
				}
				cartdao.addCart(item);
				}
			else
			{
				int flag=1;
				Iterator<Cart> cartitem = cartlist.listIterator();
				while(cartitem.hasNext())
				{
					Cart item1 = (Cart) cartitem.next();
					if(item1.getProdDetails().getPro_Id()==prodid)
					{
						int oldqty = item1.getPro_Quantity();
						int newqty = oldqty +qty;
						if(newqty > product.getStock())
						{
							model.addAttribute("error", true);
							model.addAttribute("message","Stock Insufficient");
						}
						else
						{
							item1.setPro_Quantity(newqty);
							cartdao.updateCart(item1);
						}
						flag=0;
						break;
					}
					
				}
				if(flag == 1)
				{
					item.setCustDetails(customer);
					item.setProdDetails(product);
					if(product.getStock()>=qty)
					{
						item.setPro_Quantity(qty);
					}
					else
					{
						model.addAttribute("error",true);
						model.addAttribute("message","Stock Insufficient");
					}
					cartdao.addCart(item);
				}
			}
			session.setAttribute("cartinfo", cartdao.allcart(customer));
			model.addAttribute("cartpage",true);
			
		}
		
		return "index";
	}
}
