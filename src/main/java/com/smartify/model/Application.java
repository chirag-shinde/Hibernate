package com.smartify.model;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.smartify.model.entities.Address;
import com.smartify.model.entities.Bank;

public class Application {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {

			session.beginTransaction();

			Bank bank = new Bank();
			Address address = new Address();
			bank.setName("Sachin Bank");
			bank.setInternational(true);
			bank.setCreatedBy("Sachin");
			bank.setCreatedDate(new Date());
			bank.setLastUpdatedBy("Sachin");
			bank.setLastUpdatedDate(new Date());
			bank.getContacts().add("Sachin Clone 1");
			bank.getContacts().add("Sachin Clone 2");
			address.setAddressLine1("Sachin road");
			address.setAddressLine2("Sachin galli");
			address.setCity("Sachin Nagar");
			address.setState("SP");
			address.setZipCode("12345");
			bank.setAddress(address);
			session.save(bank);
			session.getTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.getSessionfactory().close();
		}
	}
}
