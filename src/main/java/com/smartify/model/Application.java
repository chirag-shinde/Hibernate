package com.smartify.model;

import java.util.Date;

import org.hibernate.Session;

import com.smartify.model.entities.User;

public class Application {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		session.beginTransaction();
		
		User user = new User();
		user.setBirthDate(new Date());
		user.setCreatedBy("Jane Doe");
		user.setCreatedDate(new Date());
		user.setEmailAddress("test@user.com");
		user.setFirstName("Test");
		user.setLastname("User");
		user.setLastUpdatedBy("Jane Doe");
		user.setLastUpdatedDate(new Date());
		
		session.save(user);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.getSessionfactory().close();
	}
}
