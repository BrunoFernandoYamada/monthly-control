package com.bfyamada.monthlyexpensescontrol.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;


import lombok.Data;

public class ExpenseDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private int line;
	private String name;
	private BigDecimal value;
	private boolean isPaid;
	private int year;
	private int month;
	
	
	public ExpenseDTO() {
		
	}
	
	public ExpenseDTO(Integer id, int line, String name, BigDecimal value, boolean isPaid, int year,
			int month) {
		super();
		this.id = id;
		this.line = line;
		this.name = name;
		this.value = value;
		this.isPaid = isPaid;
		this.year = year;
		this.month = month;
	}
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
	public void setIsPaid(boolean isReceived) {
		this.isPaid = isReceived;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	
	

	
	
}
