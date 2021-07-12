package com.bfyamada.monthlyexpensescontrol.core.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class SpreadSheetID implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "year")
	private Integer year;

	@JoinColumn(name = "month")
	private Integer month;
	
	public SpreadSheetID() {
		
	}
	
	public SpreadSheetID(Integer year, Integer month) {
		this.year = year;
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

}
