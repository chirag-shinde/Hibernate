package com.smartify.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.smartify.model.entities.Account;
import com.smartify.model.entities.Address;
import com.smartify.model.entities.Credential;
import com.smartify.model.entities.Transaction;
import com.smartify.model.entities.User;

public class Application {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {

			session.beginTransaction();
			
			Address addressAkshay = new Address("AddLine1", "AddLine2", "City", "NY", "1231");
			Address addressAdnan = new Address("AddLine2", "AddLine3", "City1", "TY", "2231");
			Address addressAkshay2 = new Address("AddLine4", "AddLine5", "City2", "YY", "6232");
			Address addressAdnan2 = new Address("AddLine5", "AddLine1", "City3", "CY", "1731");
			
			List<Address> akAdd = new ArrayList<>();
			akAdd.add(addressAdnan);
			akAdd.add(addressAdnan2);
			
			List<Address> adAdd = new ArrayList<>();
			adAdd.add(addressAkshay);
			adAdd.add(addressAkshay2);
			
			
			User Akshay = new User("Akshay", "Kumar", adAdd, null, new Date(), "AkshayEmail", new Date(), "Akshay", new Date(), "Akshay", true, 22);
			User Adnan = new User("Adnan", "Sami", akAdd, null, new Date(), "emailBro", new Date(), "Adnan", new Date(), "Adnan", true, 22);
			
			
			Credential akshayCred = new Credential(Akshay, "akshay", "12334");
			Credential adnanCred = new Credential(Adnan, "adnan", "12354");
			
			Akshay.setCredential(akshayCred);
			Adnan.setCredential(adnanCred);
			
			Set<User> users = new HashSet<>();
			users.add(Adnan);
			users.add(Akshay);
			
			
			
			
			Account savingsAcc = new Account("SavingsAcc", null, new BigDecimal("100"), new BigDecimal("10"), new Date(), new Date(), new Date(), "Sachin", new Date(), "Sachin", users);
			Account currentAcc = new Account("CurrentAcc", null, new BigDecimal("1000"), new BigDecimal("300"), new Date(), new Date(), new Date(), "Rahul", new Date(), "Rahul", users);
			Transaction belt = new Transaction("IDk", "BeltPurchase", new BigDecimal("100"), new BigDecimal("10"), new BigDecimal("10"), "None", new Date(), "Adnan", new Date(), "Adnan", currentAcc);
			Transaction wallet = new Transaction("IDk1", "Wallet Purchase", new BigDecimal("200"), new BigDecimal("20"), new BigDecimal("20"), "NoneAgain", new Date(), "Akshay", new Date(), "Akshay", savingsAcc);
			List<Transaction> transaction = new ArrayList<>();
			transaction.add(wallet);
			transaction.add(belt);
			Akshay.getAccounts().add(currentAcc);
			Akshay.getAccounts().add(savingsAcc);
			Adnan.getAccounts().add(currentAcc);
			Adnan.getAccounts().add(savingsAcc);
			savingsAcc.setTransactions(transaction);
			currentAcc.setTransactions(transaction);
			
			savingsAcc.getUsers().add(Adnan);
			savingsAcc.getUsers().add(Akshay);
			
			currentAcc.getUsers().add(Adnan);
			currentAcc.getUsers().add(Akshay);
			
			
			session.save(Akshay);
			session.save(Adnan);
			
			session.getTransaction().commit();

			
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.getSessionfactory().close();
		}
	}
}
