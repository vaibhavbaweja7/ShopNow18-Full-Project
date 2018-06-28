package com.niit.Backend.dao;

import java.util.List;

import com.niit.Backend.model.Product;



public interface ProDao {
	public boolean AddProduct(Product product);
	public boolean UpdateProduct(Product product);
	public boolean DeleteProduct(String ProductId);
	public Product getProduct(String ProductId);
	public  List<Product>retrieveProduct( );
	List<Product> retrieveProductbyId(String categoryId);
}
