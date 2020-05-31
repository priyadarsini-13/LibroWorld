package com.niit.Libroworld.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MyOrders {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int dummy_id;
	
	@Column(nullable = false)
	String order_Id;
	
	@ManyToOne
	Product prod_Details;
	
	@ManyToOne
	Customer cust_Details;
	
	@Column(nullable = false)
     int prodqty;
	
	@ManyToOne
	Address address;
	
	@Column(nullable = false)
	float order_total;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	Date order_date;

	public int getDummy_id() {
		return dummy_id;
	}

	public void setDummy_id(int dummy_id) {
		this.dummy_id = dummy_id;
	}

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

	public int getProdqty() {
		return prodqty;
	}

	public void setProdqty(int prodqty) {
		this.prodqty = prodqty;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public float getOrder_total() {
		return order_total;
	}

	public void setOrder_total(float order_total) {
		this.order_total = order_total;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	
	
}