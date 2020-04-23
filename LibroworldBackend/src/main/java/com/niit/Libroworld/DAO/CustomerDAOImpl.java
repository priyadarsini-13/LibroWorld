package com.niit.Libroworld.DAO;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Libroworld.Model.Category;
import com.niit.Libroworld.Model.Customer;
@Repository("categorydao")
@Transactional
public class CustomerDAOImpl implements ICustomerDAO {
	@Autowired
	SessionFactory sessionfactory;
	@Override
	public boolean addCustomer(Customer customer) {
		try {
			sessionfactory.getCurrentSession().save(customer);
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
