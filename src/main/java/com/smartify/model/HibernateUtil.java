package com.smartify.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.smartify.model.entities.Address;
import com.smartify.model.entities.Bank;
import com.smartify.model.entities.TimeTest;
import com.smartify.model.entities.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	private static StandardServiceRegistry standardServiceRegistry;
	static{
		try{
				standardServiceRegistry = new StandardServiceRegistryBuilder()
												.configure()
												.build();
				
				sessionFactory = new MetadataSources(standardServiceRegistry)
										.addAnnotatedClass(User.class)
										.addAnnotatedClass(TimeTest.class)
										.addAnnotatedClass(Bank.class)
										.addAnnotatedClass(Address.class)
										.buildMetadata()
										.buildSessionFactory();
			
					System.out.println("SessionFactory Created");					
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public static SessionFactory getSessionfactory(){
		return sessionFactory; 
		
	}
}
