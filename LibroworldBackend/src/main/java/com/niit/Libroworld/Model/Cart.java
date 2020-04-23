package com.niit.Libroworld.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cart_Id;
	@ManyToOne
	Customer custDetails;
	@ManyToOne
	Product prodDetails;
	@Column(nullable=false)
	int Quantity;
	public int getCart_Id() {
		return cart_Id;
	}
	public void setCart_Id(int cart_Id) {
		this.cart_Id = cart_Id;
	}
	public Customer getCustDetails() {
		return custDetails;
	}
	public void setCustDetails(Customer custDetails) {
		this.custDetails = custDetails;
	}
	public Product getProdDetails() {
		return prodDetails;
	}
	public void setProdDetails(Product prodDetails) {
		this.prodDetails = prodDetails;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	

}
