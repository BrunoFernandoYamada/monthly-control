package com.bfyamada.monthlyexpensescontrol.core.dto;

import java.io.Serializable;
import java.math.BigDecimal;


import lombok.Data;

public class IncomeDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String description;
	private BigDecimal value;
	private boolean isReceived;
	private int year;
	private int month;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public boolean isReceived() {
		return isReceived;
	}
	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
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
