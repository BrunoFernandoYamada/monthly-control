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
@Table(name = "Income_TB")
public class Income implements Serializable {

	private static final long serialVersionUID = 1L;

	public Income() {

	}

	public Income(String id, @NotEmpty(message = "name of income is mantatory") String name, String description,
			@NotNull(message = "value of income is mantatory") BigDecimal value, boolean isReceived,
			SpreadSheet spreadSheet) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.value = value;
		this.isReceived = isReceived;
		this.spreadSheet = spreadSheet;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String Id;

	@NotEmpty(message = "name of income is mantatory")
	@Column(nullable = false)
	private String name;

	@Column(nullable = true)
	private String description;

	@NotNull(message = "value of income is mantatory")
	@Column(nullable = false)
	private BigDecimal value;

	@Column(nullable = false)
	private boolean isReceived;

	@JsonIgnore
	@ManyToOne
	private SpreadSheet spreadSheet;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
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

	public boolean isReceived() {
		return isReceived;
	}

	public void setReceived(boolean isReceived) {
		this.isReceived = isReceived;
	}

	public SpreadSheet getSpreadSheet() {
		return spreadSheet;
	}

	public void setSpreadSheet(SpreadSheet spreadSheet) {
		this.spreadSheet = spreadSheet;
	}

}
