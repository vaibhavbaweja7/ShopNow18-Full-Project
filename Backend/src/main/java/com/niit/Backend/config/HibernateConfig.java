package com.niit.Backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Backend.model.Authorisation;
import com.niit.Backend.model.Billing;
import com.niit.Backend.model.Category;
import com.niit.Backend.model.Product;
import com.niit.Backend.model.Shipping;
import com.niit.Backend.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages ="com.niit")
public class HibernateConfig {
	@Bean("dataSource")
	public DataSource geth2DataSource()
	{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("h2");
		dataSource.setPassword("h2");
		return dataSource;
		
	}
	@Autowired
	@Bean("sessionFactory")
	public  SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);
		
		
		sessionFactory.addProperties(getHibernateProperties());
		sessionFactory.addAnnotatedClass(Category.class);
		sessionFactory.addAnnotatedClass(Product.class);
		sessionFactory.addAnnotatedClass(User.class);
		sessionFactory.addAnnotatedClass(Billing.class);
		sessionFactory.addAnnotatedClass(Shipping.class);
		sessionFactory.addAnnotatedClass(Authorisation.class);
		
		return sessionFactory.buildSessionFactory();
		
	}
	public Properties getHibernateProperties()
	{

		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		
		properties.setProperty("hibernate.show_sql", "true");
		;
		properties.setProperty("hibernate.hbm2ddl.auto","update");
	
		return properties;
	}
	@Autowired
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}


		}
