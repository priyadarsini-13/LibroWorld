package com.niit.Libroworld.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class customerCred {
	@Id
	@Column(nullable = false)
	String cust_Email;
	@Column(nullable = false)
	String cust_Password;
	@Column(nullable = false)
	String cust_Role;
	@Column(nullable = false)
	String cust_status;
	
	public String getCust_Email() {
		return cust_Email;
	}
	public void setCust_Email(String cust_Email) {
		this.cust_Email = cust_Email;
	}
	public String getCust_Password() {
		return cust_Password;
	}
	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}
	public String getCust_Role() {
		return cust_Role;
	}
	public void setCust_Role(String cust_Role) {
		this.cust_Role = cust_Role;
	}
	public String getCust_status() {
		return cust_status;
	}
	public void setCust_status(String cust_status) {
		this.cust_status = cust_status;
	}
	
}
