package com.niit.Libroworld.DAO;

import java.util.ArrayList;

import com.niit.Libroworld.Model.Cart;
import com.niit.Libroworld.Model.Customer;

public interface ICartDAO {
	public boolean addCart(Cart cart);
	public boolean updateCart(Cart cart);
 public boolean deleteCart(Cart cart);
	public ArrayList <Cart> allcart(Customer cust);
	public Cart oneCart(int cartid);
}
