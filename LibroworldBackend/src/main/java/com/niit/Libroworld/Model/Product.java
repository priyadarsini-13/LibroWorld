package com.niit.Libroworld.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;

import org.springframework.web.multipart.MultipartFile;

@Entity

public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int pro_Id;
	@Column(nullable = false, unique = true)
	@Length(min=3,message ="The minimum no.of character is 3")
	String pro_Name;
	@Column(nullable = false,columnDefinition="text")

	String description;
	@Column(nullable = false)
	
	int stock;
	@Column(nullable = false)
	
	float price;
	@ManyToOne
	Category pro_Category;
	@Transient
	MultipartFile product_Images;

	public MultipartFile getProduct_Images() {
		return product_Images;
	}
	public void setProduct_Images(MultipartFile product_Images) {
		this.product_Images = product_Images;
	}
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
