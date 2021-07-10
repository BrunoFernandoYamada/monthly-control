package com.bfyamada.monthlycontrol.core.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SpreedSheet_TB")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpreadSheet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@NotNull(message = "Month is mantatory")
	@Size(min = 4, max = 4, message = "Invalid value for year")
	@Column(nullable = false)
	private Integer year;
	
	@Min(value = 1, message = "Invalid value for month")
	@Max(value = 12, message = "Invalid value for month")
	@NotNull(message = "Month is mantatory")
	@Column(nullable = false)
	private Integer month;
	
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
	
	@OneToMany(mappedBy = "spreadSheetId", cascade = CascadeType.ALL)
	private List<Income> incomes = new ArrayList<>();
	
	@OneToMany(mappedBy = "spreadSheetId", cascade = CascadeType.ALL)
	private List<Expense> expense = new ArrayList<>();
	

	public SpreadSheet(String id, Integer month, BigDecimal totalIncome, BigDecimal totalExpense, BigDecimal totalPaid,
			BigDecimal totalNotPaid, boolean isClosed, BigDecimal balance) {
		super();
		this.id = id;
		this.month = month;
		this.totalIncome = totalIncome;
		this.totalExpense = totalExpense;
		this.totalPaid = totalPaid;
		this.totalNotPaid = totalNotPaid;
		this.isClosed = isClosed;
		this.balance = balance;
	}


	
	
	
	
	
	
	

}
