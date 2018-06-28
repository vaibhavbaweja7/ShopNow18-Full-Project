package com.niit.Backend.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Backend.model.Authorisation;
import com.niit.Backend.model.User;
@Repository
@Transactional
public class UserDaoImp implements UserDao {
@Autowired	
SessionFactory sessionFactory;

	public boolean addUser(User user) {
		
		Session session=sessionFactory.getCurrentSession();
		try { 
			user.setEnable(true);
			session.save(user);
			System.out.println("-- UsersDaoImpl -- addUser begins -- ");
			user.getBilling().setU(user);
			user.getShipping().setU(user);
			user.setEnable(true);
			System.out.println("-- UsersDaoImpl -- Persisting user data --");
			session.persist(user);
			System.out.println("-- UsersDaoImpl -- Persisting billing data --");
			session.persist(user.getBilling());
			System.out.println("-- UsersDaoImpl -- Persisting shipping data --");
			session.persist(user.getShipping());
			System.out.println("-- UsersDaoImpl -- Authorizing user --");
			Authorisation auth = new Authorisation();
			auth.setEmailId(user.getEmail());
			auth.setRolename("ROLE_USER");
			System.out.println("User role: " + auth.getRoleid());
			System.out.println("Role id: " + auth.getRoleid());
			System.out.println("-- UsersDaoImpl -- Persisting Authorization --");
			session.persist(auth);
			System.out.println("-- UsersDaoImpl -- addUser ends -- ");
		
			return true;
		}
		catch(HibernateException e)
		{
			System.out.println("-- ERROR --");
			e.printStackTrace();
		return false;
		
		}
		// TODO Auto-generated method stub
		
	}

	public boolean updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		try
		{
			session.update(user);
			System.out.println("-- UsersDaoImpl -- updateUser begins -- ");
			session.update(user);
			System.out.println("-- UsersDaoImpl -- updateUser ends -- ");// TODO Auto-generated method stub
		    return true;
		}
		 catch (HibernateException e)
		{ 
			 System.out.println("-- ERROR --");
				e.printStackTrace();
			 
			 return false;
		
		}
	}

	public boolean deleteUser(int userId) {
		Session session=sessionFactory.getCurrentSession();
		try {
	session.delete(userId);
	
	System.out.println("-- UserDaoImlp ---- deleteUserById begins -- ");
	session.delete(userId);
	System.out.println("-- UserDaoImlp ---- deleteUserById ends -- ");// TODO Auto-generated method stub
		return true; 
		}
	catch(HibernateException e)
{
		System.out.println("-- ERROR --");
		e.printStackTrace();
 return false;
 
}
	                                    }
	

	public User getUser(int userId) {
		Session session=sessionFactory.getCurrentSession();// TODO Auto-generated method stub
		System.out.println("-- UserDaoImlp ---- getUserById begins -- ");
		User u = (User) session.get(User.class, userId);
		System.out.println("-- UserDaoImlp ---- getUserById ends -- ");
		return session.get(User.class,userId);
		
	}

	public List<User> getAllUsers() {
		Session session=sessionFactory.getCurrentSession();// TODO Auto-generated method stub
		Query query= session.createQuery("From User");
		List<User> list=(List<User>)query.getResultList();
		return list;
	}

	public List<User> retrieveUser() 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query= session.createQuery("From User");
		List<User> users= session.createQuery("FROM User").list();
		     // TODO Auto-generated method stub
		return users;
	}

}
