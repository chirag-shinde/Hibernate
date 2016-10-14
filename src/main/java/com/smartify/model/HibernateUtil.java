package com.smartify.model;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.smartify.model.entities.Account;
import com.smartify.model.entities.Budget;
import com.smartify.model.entities.Credential;
import com.smartify.model.entities.Transaction;
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
										.addAnnotatedClass(Account.class)
										.addAnnotatedClass(Transaction.class)
										.addAnnotatedClass(Budget.class)
										.addAnnotatedClass(User.class)
										.addAnnotatedClass(Credential.class)
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
