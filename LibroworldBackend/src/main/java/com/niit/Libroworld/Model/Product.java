package com.niit.Libroworld.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int pro_Id;
	@Column(nullable = false, unique = true)
	String pro_Name;
	@Column(nullable = false,columnDefinition="text")
	String description;
	@Column(nullable = false)
	int stock;
	@Column(nullable = false)
	float price;
	@Column(nullable = false)
	Category pro_Category;
	public String getPro_Name() {
		return pro_Name;
	}
	public void setPro_Name(String pro_Name) {
		this.pro_Name = pro_Name;
	}
	public int getPro_Id() {
		return pro_Id;
	}
	public void setPro_Id(int pro_Id) {
		this.pro_Id = pro_Id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Category getPro_Category() {
		return pro_Category;
	}
	public void setPro_Category(Category pro_Category) {
		this.pro_Category = pro_Category;
	}
	
	
}
