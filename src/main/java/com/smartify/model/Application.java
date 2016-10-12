package com.smartify.model;

import java.util.Date;

import org.hibernate.Session;

import com.smartify.model.entities.TimeTest;

public class Application {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		
		TimeTest test = new TimeTest(new Date());
		
		session.save(test);
		session.getTransaction().commit();
		session.refresh(test);
		System.out.println(test.toString());
		session.close();
		HibernateUtil.getSessionfactory().close();
	}
}
