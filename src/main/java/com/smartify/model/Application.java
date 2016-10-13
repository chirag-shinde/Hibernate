package com.smartify.model;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.smartify.model.entities.User;

public class Application {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {

			session.beginTransaction();

			User user = new User();
			user.setBirthDate(getBirthday());
			user.setCreatedBy("John Doe");
			user.setCreatedDate(new Date());
			user.setEmailAddress("chirag@shinde.com");
			user.setFirstName("Chirag");
			user.setLastname("Shinde");
			user.setLastUpdatedBy("John");
			user.setLastUpdatedDate(new Date());

			session.save(user);
			session.getTransaction().commit();

			session.refresh(user);

			System.out.println(user.getAge());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.getSessionfactory().close();
		}
	}

	private static Date getBirthday() {
		Calendar calender = Calendar.getInstance();
		calender.set(Calendar.YEAR, 1993);
		calender.set(Calendar.MONTH, 4);
		calender.set(Calendar.DATE, 22);
		return calender.getTime();
	}
}
