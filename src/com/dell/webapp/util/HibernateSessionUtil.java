package com.dell.webapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dell.webapp.model.Product;


public class HibernateSessionUtil {
	
	private static SessionFactory factory;
	
	public static SessionFactory buildSessionFactory() {
		
		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Product.class)
//				.addAnnotatedClass(Order.class)
				.buildSessionFactory();
		return factory;
	}

}
