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
			
			user.setAge(23);
			user.setBirthDate(new Date());
			user.setCreatedBy("Test");
			user.setCreatedDate(new Date());
			user.setEmailAddress("emailaddress");
			user.setFirstName("Sachin");
			user.setLastname("Sachya");
			user.setLastUpdatedBy("Sachya");
			user.setLastUpdatedDate(new Date());
			user.setValid(true);
			
			Address address = new Address();
			address.setAddressLine1("Sachin road");
			address.setAddressLine2("Sachin galli");
			address.setCity("Sachin Nagar");
			address.setState("SP");
			address.setZipCode("12345");
			
			Address address1 = new Address();
			address1.setAddressLine1("Sachi road");
			address1.setAddressLine2("Sachin gali");
			address1.setCity("SachinNagar");
			address1.setState("SA");
			address1.setZipCode("23451");
			
			user.getAddress().add(address);
			user.getAddress().add(address1);
			session.save(user);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.getSessionfactory().close();
		}
	}
}
