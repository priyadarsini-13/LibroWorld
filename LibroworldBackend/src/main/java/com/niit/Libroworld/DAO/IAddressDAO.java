package com.niit.Libroworld.DAO;

import java.util.ArrayList;

import com.niit.Libroworld.Model.Address;
import com.niit.Libroworld.Model.Customer;

public interface IAddressDAO {
 public boolean addAddress(Address address);
 public boolean updateAddress(Address address);
  public boolean deleteAddress(Address address);
  public ArrayList <Address> allAddress(Customer cust);
 public Address oneAddress(int addressid) ;
}
