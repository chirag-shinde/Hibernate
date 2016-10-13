package com.smartify.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {

	private Long accountId;

	private String name;
	
	private List<Transaction> transactions = new ArrayList<>();

	private BigDecimal initialBalance;

	private BigDecimal currentBalance;

	private Date openDate;

	private Date closeDate;

	private Date lastUpdatedDate;

	private String lastUpdatedBy;

	private Date createdDate;

	private String createdBy;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="account_id")
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy = "account")
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "initial_balance")
	public BigDecimal getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(BigDecimal initialBalance) {
		this.initialBalance = initialBalance;
	}
	
	@Column(name = "current_balance")
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	@Column(name = "open_date")
	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
	@Column(name = "close_date")
	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	
	@Column(name = "last_updated_date")
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	@Column(name = "last_updated_by")
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}
	
	@Column(name = "created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}