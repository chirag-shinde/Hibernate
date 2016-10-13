package com.smartify.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.smartify.model.entities.Account;
import com.smartify.model.entities.Transaction;

public class Application {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionfactory().openSession()) {

			session.beginTransaction();
			
			Transaction beltPurchase = new Transaction();
			Transaction shoePurchase = new Transaction();
			
			
			Account account = new Account();
			account.setCloseDate(new Date());
			account.setOpenDate(new Date());
			account.setCreatedBy("Kevin Bowersox");
			account.setInitialBalance(new BigDecimal("50.00"));
			account.setName("Savings Account");
			account.setCurrentBalance(new BigDecimal("100.00"));
			account.setLastUpdatedBy("Kevin Bowersox");
			account.setLastUpdatedDate(new Date());
			account.setCreatedDate(new Date());
			
			beltPurchase.setTitle("Dress Belt");
			beltPurchase.setAmount(new BigDecimal("50.00"));
			beltPurchase.setClosingBalance(new BigDecimal("0.00"));
			beltPurchase.setCreatedBy("Kevin Bowersox");
			beltPurchase.setCreatedDate(new Date());
			beltPurchase.setInitialBalance(new BigDecimal("0.00"));
			beltPurchase.setLastUpdatedBy("Kevin Bowersox");
			beltPurchase.setLastUpdatedDate(new Date());
			beltPurchase.setNotes("New Dress Belt");
			beltPurchase.setTransactionType("Debit");
			beltPurchase.setAccount(account);
			
			shoePurchase.setTitle("Work Shoes");
			shoePurchase.setAmount(new BigDecimal("100.00"));
			shoePurchase.setClosingBalance(new BigDecimal("0.00"));
			shoePurchase.setCreatedBy("Kevin Bowersox");
			shoePurchase.setCreatedDate(new Date());
			shoePurchase.setInitialBalance(new BigDecimal("0.00"));
			shoePurchase.setLastUpdatedBy("Kevin Bowersox");
			shoePurchase.setLastUpdatedDate(new Date());
			shoePurchase.setNotes("Nice Pair of Shoes");
			shoePurchase.setTransactionType("Debit");
			shoePurchase.setAccount(account);
			
			account.getTransactions().add(shoePurchase);
			account.getTransactions().add(beltPurchase);
			
			session.save(account);
			session.getTransaction().commit();
			
			Transaction transaction =  session.get(Transaction.class,account.getTransactions().get(0).getTransactionId());
			System.out.println(transaction.getAccount().getName());
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.getSessionfactory().close();
		}
	}
}
