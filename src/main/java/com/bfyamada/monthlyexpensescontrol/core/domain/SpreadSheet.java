package com.bfyamada.monthlyexpensescontrol.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "SpreadSheet_TB")
public class SpreadSheet implements Serializable {

	private static final long serialVersionUID = 1L;

	public SpreadSheet() {

	}
	
	public SpreadSheet(Integer year, Integer month) {
		super();

		this.id.setYear(year);
		this.id.setMonth(month);
		this.totalIncome = new BigDecimal(0.0);
		this.totalExpense = new BigDecimal(0.0);
		this.totalPaid = new BigDecimal(0.0);
		this.totalNotPaid = new BigDecimal(0.0);
		this.isClosed = false;
		this.balance = new BigDecimal(0.0);
	}
	

	public SpreadSheet(Integer year, Integer month, BigDecimal totalIncome, BigDecimal totalExpense,
			BigDecimal totalPaid, BigDecimal totalNotPaid, boolean isClosed, BigDecimal balance) {
		super();

		this.id.setYear(year);
		this.id.setMonth(month);
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
		this.totalPaid = totalPaid;
		this.totalNotPaid = totalNotPaid;
		this.isClosed = isClosed;
		this.balance = balance;
	}

	@JsonIgnore
	@EmbeddedId
	private SpreadSheetID id = new SpreadSheetID();

	@Column(nullable = true)
	private BigDecimal totalIncome;

	@Column(nullable = true)
	private BigDecimal totalExpense;

	@Column(nullable = true)
	private BigDecimal totalPaid;

	@Column(nullable = true)
	private BigDecimal totalNotPaid;

	@Column(nullable = false)
	private boolean isClosed;

	@Column(nullable = true)
	private BigDecimal balance;

	@OneToMany(mappedBy = "spreadSheet", cascade = CascadeType.ALL)
	private List<Income> incomes = new ArrayList<>();

	@OneToMany(mappedBy = "spreadSheet", cascade = CascadeType.ALL)
	private List<Expense> expenses = new ArrayList<>();

	public SpreadSheetID getId() {
		return id;
	}

	public void setId(SpreadSheetID id) {
		this.id = id;
	}

	public BigDecimal getTotalIncome() {
		return totalIncome;
	}

	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}

	public Integer getYear() {
		return id.getYear();
	}

	public void setYear(Integer year) {
		this.id.setYear(year);
	}

	public Integer getMonth() {
		return id.getMonth();
	}

	public void setMonth(Integer month) {
		this.id.setMonth(month);
	}

	public BigDecimal getTotalExpense() {
		return totalExpense;
	}

	public void setTotalExpense(BigDecimal totalExpense) {
		this.totalExpense = totalExpense;
	}

	public BigDecimal getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
	}

	public BigDecimal getTotalNotPaid() {
		return totalNotPaid;
	}

	public void setTotalNotPaid(BigDecimal totalNotPaid) {
		this.totalNotPaid = totalNotPaid;
	}

	public boolean isClosed() {
		return isClosed;
	}

	public void setClosed(boolean isClosed) {
		this.isClosed = isClosed;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public List<Income> getIncomes() {
		return incomes;
	}

	public void setIncomes(List<Income> incomes) {
		this.incomes = incomes;
	}

	public List<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}

}
