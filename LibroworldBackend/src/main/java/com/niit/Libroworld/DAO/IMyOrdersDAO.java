package com.niit.Libroworld.DAO;

import java.util.ArrayList;
import com.niit.Libroworld.Model.Customer;
import com.niit.Libroworld.Model.MyOrders;

public interface IMyOrdersDAO {
	public boolean addMyOrder(MyOrders myorders);
	public boolean updateMyOrder(MyOrders myorders);
	public boolean deleteMyOrder(MyOrders  myorders);
	public ArrayList<MyOrders> allMyOrder(Customer cust);
	public ArrayList<MyOrders> oneMyOrder(String orderid);
}
