package com.smartify.model;

import org.hibernate.Session;

public class Application {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionfactory().close();
	}
}
