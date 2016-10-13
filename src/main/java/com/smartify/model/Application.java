package com.smartify.model;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.smartify.model.entities.Address;
import com.smartify.model.entities.User;

public class Application {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {

			session.beginTransaction();

			User user = new User();
			Address address = new Address();
			user.setAge(23);
			user.setBirthDate(new Date());
			user.setCreatedBy("Test");
			user.setCreatedDate(new Date());
			user.setEmailAddress("test@test.com");
			user.setFirstName("Sachin");
			user.setLastname("Sachin");
			user.setLastUpdatedBy("Test");
			user.setLastUpdatedDate(new Date());
			address.setAddressLine1("Sachin road");
			address.setAddressLine2("Sachin galli");
			address.setCity("Sachin Nagar");
			address.setState("SP");
			address.setZipCode("12345");
			user.setAddress(address);
			session.save(user);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.getSessionfactory().close();
		}
	}
}
