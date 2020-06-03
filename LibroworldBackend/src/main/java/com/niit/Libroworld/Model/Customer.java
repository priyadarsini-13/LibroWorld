package com.niit.Libroworld.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int cust_Id;
	@Column(nullable = false, unique = true)
	@NotBlank(message ="** Name Cannot be blank**")
	
	String cust_Name;
	@Column(nullable = false, unique = true)
	@Email()
	String cust_Email;
	@Column(nullable=false)
	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[6-9]\\d{9}$", message="**Mobile No. must be of Indian Standards**")
	String cust_Phno;
	@Transient
	@Column(nullable = false)

	@Pattern(regexp="^[a-zA-Z]\\w{3,14}$", message="**Letters,numbers and the underscore may be used**")
	String cust_Password;
	public int getCust_Id() {
		return cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}
	public String getCust_Name() {
		return cust_Name;
	}
	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}
	public String getCust_Email() {
		return cust_Email;
	}
	public void setCust_Email(String cust_Email) {
		this.cust_Email = cust_Email;
	}
	public String getCust_Phno() {
		return cust_Phno;
	}
	public void setCust_Phno(String cust_Phno) {
		this.cust_Phno = cust_Phno;
	}
	public String getCust_Password() {
		return cust_Password;
	}
	public void setCust_Password(String cust_Password) {
		this.cust_Password = cust_Password;
	}
	
	
	

	
}
