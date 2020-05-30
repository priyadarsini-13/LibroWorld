package com.niit.Libroworld.DAO;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Libroworld.Model.Address;
import com.niit.Libroworld.Model.Category;
import com.niit.Libroworld.Model.Customer;
import com.niit.Libroworld.Model.MyOrders;

@Repository("myordersdao")
@Transactional
public class MyOrdersDAOImpl implements IMyOrdersDAO {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addMyOrder(MyOrders myorders) {
		try {
			sessionfactory.getCurrentSession().save(myorders);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateMyOrder(MyOrders myorders) {
		try {
			sessionfactory.getCurrentSession().update(myorders);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteMyOrder(MyOrders myorders) {
		try {
			sessionfactory.getCurrentSession().delete(myorders);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ArrayList<MyOrders> allMyOrder(Customer cust) {
		try {
			ArrayList<MyOrders> orderlist = (ArrayList<MyOrders>) sessionfactory.getCurrentSession()
					.createCriteria(MyOrders.class).add(Restrictions.eq("cust_Details", cust)).list();
			return orderlist;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public  ArrayList<MyOrders> oneMyOrder(String order_id) {
		try {
			ArrayList<MyOrders> order = 	(ArrayList<MyOrders>)sessionfactory.getCurrentSession().createCriteria(MyOrders.class)
				.add(Restrictions.eq("order_Id", order_id)).list();
			return order;
		} catch (Exception e) {
			return null;
		}
	}
}
