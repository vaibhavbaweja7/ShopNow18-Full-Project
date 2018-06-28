package com.niit.Backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.model.Category;

@Repository
@Transactional
public class CatDaoImp implements CatDao{
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean AddCategory(Category category) {
		System.out.println("Data is here 2");
		Session session=sessionFactory.getCurrentSession();
		try { 
			System.out.println("Data is here 3");
			category.setCategoryId(category.getCategoryName());
			session.persist(category);
		
			return true;
		}
		catch(HibernateException e)
		{
			System.out.println(e.getMessage());
		return false;
		
		}
	}

	public boolean UpdateCategory(Category category) {
		
		
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(category);
		    return true;
	
		}
		 catch (HibernateException e)
		{ 
			 return false;
		
		}
	}

	public boolean DeleteCategory(String CategoryId) {
		Session session=sessionFactory.getCurrentSession();
		try {
			session.delete(getCategory(CategoryId));// TODO Auto-generated method stub
				return true; 
				}
			catch(HibernateException e)
		{
		 return false;
		 
		}
	}

	public Category getCategory(String CategoryId) {
		Session session=sessionFactory.getCurrentSession();// TODO Auto-generated method stub
		
		return session.get(Category.class,CategoryId);
		
	}

	
	public List<Category> retrieveCategory() {
		
		Session session=sessionFactory.getCurrentSession();
		List<Category> categories = session.createQuery("FROM Category").list();// TODO Auto-generated method stub
		return categories;
	}


	public boolean UpdateCategory(String categoryId) {
		// TODO Auto-generated method stub
		return false;
	}

}
