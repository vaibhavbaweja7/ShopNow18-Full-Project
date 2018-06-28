package com.niit.Backend.dao;

import java.util.List;

import com.niit.Backend.model.Category;



public interface CatDao {
public boolean AddCategory(Category category);
public boolean UpdateCategory(Category category);
public boolean DeleteCategory(String CategoryId);
public Category getCategory(String CategoryId);
public  List<Category>retrieveCategory( );
boolean UpdateCategory(String categoryId);
}
