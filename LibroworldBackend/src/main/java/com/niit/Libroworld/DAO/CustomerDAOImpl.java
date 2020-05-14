package com.niit.Libroworld.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.Libroworld.Model.Customer;
import com.niit.Libroworld.Model.customerCred;
@Repository("customerdao")
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().save(customer);
			customerCred cred=new customerCred();
			cred.setCust_Email(customer.getCust_Email());
			cred.setCust_Password(customer.getCust_Password());
			cred.setCust_status("false");
			cred.setCust_Role("ROLE_CUSTOMER");
			sessionfactory.getCurrentSession().save(cred);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().update(customer);
			return true;
		} catch (Exception e) {
			return false;
		}
		}

	@Override
	public Customer selectCustomer(String cust_email) {
		try {
			Customer customer= (Customer) sessionfactory.getCurrentSession().createCriteria(Customer.class)
					.add(Restrictions.eq("cust_Email",cust_email)).uniqueResult();
			return customer;
		} catch (Exception e) {
			return null;
		}
	
	}

}
