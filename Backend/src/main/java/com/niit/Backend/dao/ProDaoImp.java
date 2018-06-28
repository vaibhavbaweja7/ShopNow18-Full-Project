package com.niit.Backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.niit.Backend.model.Product;
@Repository
@Transactional
public class ProDaoImp implements ProDao {
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean AddProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		try { product.setProductId(product.getProductName());
		session.persist(product);
		return true;
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		return false;
		
		}
	}

	
	public boolean UpdateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(product);
		    return true;
	
		}
		 catch (HibernateException e)
		{ 
			 return false;
		
		}
	}

	
	public boolean DeleteProduct(String ProductId) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.delete(getProduct(ProductId));// TODO Auto-generated method stub
				return true; 
				}
			catch(HibernateException e)
		{
		 return false;
		 
		}
	}

	
	public Product getProduct(String ProductId) {
Session session=sessionFactory.getCurrentSession();// TODO Auto-generated method stub
		
		return session.get(Product.class,ProductId);
	}

	
	public List<Product> retrieveProduct() {
		Session session=sessionFactory.getCurrentSession();
		List<Product> products = (List<Product>)session.createQuery("From Product").getResultList();// TODO Auto-generated method stub
		return products;
		
	}

	public List<Product> retrieveProductbyId(String categoryId) {
		Session session=sessionFactory.getCurrentSession();
		
		
		List<Product> products=(List<Product>)session.createQuery("From Product where categoryId=?").setParameter(0, categoryId).getResultList();// TODO Auto-generated method stub
		return products;
	}

	

}


