package com.niit.Libroworld.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MyOrders {
	@Id
	String order_Id;
	@Column(nullable = false)
	Product prod_Details;
	@Column(nullable = false)
	Customer cust_Details;
	@Column(nullable = false)
	Address address;
	@Column(nullable = false)
	float total;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	Date order_date;
	public String getOrder_Id() {
		return order_Id;
	}
	public void setOrder_Id(String order_Id) {
		this.order_Id = order_Id;
	}
	public Product getProd_Details() {
		return prod_Details;
	}
	public void setProd_Details(Product prod_Details) {
		this.prod_Details = prod_Details;
	}
	public Customer getCust_Details() {
		return cust_Details;
	}
	public void setCust_Details(Customer cust_Details) {
		this.cust_Details = cust_Details;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	
	
	

}
