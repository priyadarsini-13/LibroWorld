package com.niit.Libroworld.DAO;

import com.niit.Libroworld.Model.Customer;

public interface ICustomerDAO {
	public boolean addCustomer(Customer customer);
	public boolean updateCustomer(Customer customer);
	public Customer selectCustomer(String emailId);

}
