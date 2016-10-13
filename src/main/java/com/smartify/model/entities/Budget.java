package com.smartify.model.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "budget")
public class Budget {

	private Long budgetId;

	private String name;

	private BigDecimal goalAmount;

	private String period;

	private List<Transaction> transactions = new ArrayList<>();

	@Id
	@GeneratedValue
	@Column(name = "budget_id")
	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "goal_amount")
	public BigDecimal getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(BigDecimal goalAmount) {
		this.goalAmount = goalAmount;
	}

	@Column(name = "period")
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "budget_transaction", 
			joinColumns = @JoinColumn(name = "budget_id"), 
			inverseJoinColumns = @JoinColumn(name = "transaction_id")
			)
	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}