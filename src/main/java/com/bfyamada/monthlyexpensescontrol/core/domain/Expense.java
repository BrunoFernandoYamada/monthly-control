package com.bfyamada.monthlyexpensescontrol.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Expense_TB")
public class Expense implements Serializable {

	private static final long serialVersionUID = 1L;

	public Expense() {

	}

	public Expense(Integer id, int line, String name,BigDecimal value, boolean isPaid, SpreadSheet spreadSheet) {
		super();
		this.id = id;
		this.line = line;
		this.name = name;
		this.value = value;
		this.isPaid = isPaid;
		this.spreadSheet = spreadSheet;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "name of income is mantatory")
	@Column(nullable = false)
	private int line;

	@Column(nullable = true)
	private String name;

	@Column(nullable = true)
	private BigDecimal value;

	@Column(nullable = true)
	private boolean isPaid;

	@JsonIgnore
	@ManyToOne
	private SpreadSheet spreadSheet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public SpreadSheet getSpreadSheet() {
		return spreadSheet;
	}

	public void setSpreadSheet(SpreadSheet spreadSheet) {
		this.spreadSheet = spreadSheet;
	}

}
