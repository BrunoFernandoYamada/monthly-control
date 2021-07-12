package com.bfyamada.monthlyexpensescontrol.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;

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

	public Expense(String id, @NotEmpty(message = "name of expense is mantatory") String name, String description,
			@NotNull(message = "value of expense is mantatory") BigDecimal value, boolean isPaid,
			SpreadSheet spreadSheet) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.isPaid = isPaid;
		this.spreadSheet = spreadSheet;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@NotEmpty(message = "name of expense is mantatory")
	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String description;

	@NotNull(message = "value of expense is mantatory")
	@Column(nullable = false)
	private BigDecimal value;

	@Column(nullable = false)
	private boolean isPaid;

	@JsonIgnore
	@ManyToOne
	private SpreadSheet spreadSheet;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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
