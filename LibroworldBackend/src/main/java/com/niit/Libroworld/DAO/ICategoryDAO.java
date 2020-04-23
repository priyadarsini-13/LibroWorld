package com.niit.Libroworld.DAO;

import java.util.ArrayList;

import com.niit.Libroworld.Model.Category;

public interface ICategoryDAO {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public ArrayList <Category> allCategory();
	public Category oneCategory(String catname);
}
