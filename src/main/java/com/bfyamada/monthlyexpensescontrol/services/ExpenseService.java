package com.bfyamada.monthlyexpensescontrol.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.Expense;
import com.bfyamada.monthlyexpensescontrol.core.domain.Income;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.core.dto.ExpenseDTO;
import com.bfyamada.monthlyexpensescontrol.repositories.ExpenseRepository;
import com.bfyamada.monthlyexpensescontrol.services.exceptions.ObjectNotFoundException;

@Service
public class ExpenseService {
	
	@Autowired
	private SpreadSheetService spreadsheetService;

	@Autowired
	private ExpenseRepository repo;

	public List<ExpenseDTO> findBySpreadSheetId(Integer year, Integer month) {
		return repo.findBySpreadSheet(new SpreadSheet(year, month)).stream().map(obj -> toDTO(obj)).collect(Collectors.toList());
	}

	public ExpenseDTO findById(Integer id) {
		Expense expense = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Income nor Found"));
		if (expense == null) {
			throw new ObjectNotFoundException("Expense nor Found");
		}
		return toDTO(expense);
	}
	
	public boolean deleteExpense(Integer id) {
		repo.delete(fromDTO(findById(id)));
		return true;
	}
	
	public ExpenseDTO saveExpense(ExpenseDTO expenseDto) {
		
		Expense exp = repo.findByLine(expenseDto.getLine());
		
		if(exp != null) {
			throw new IllegalArgumentException("Invalid request input");
		}
		
		
		SpreadSheet spreadsheet = spreadsheetService.findByYearAndMonth(expenseDto.getYear(), expenseDto.getMonth());
		if (spreadsheet == null) {
			spreadsheet = new SpreadSheet(expenseDto.getYear(), expenseDto.getMonth(), expenseDto.getValue(),
					new BigDecimal(0), expenseDto.isPaid() ? expenseDto.getValue() : new BigDecimal(0),
					new BigDecimal(0), false, expenseDto.getValue());
			spreadsheetService.saveSpreadSheet(spreadsheet);
		} else {
			if(!(expenseDto.getValue() == new BigDecimal(0) || expenseDto.getValue() == null)) {
				spreadsheet.setTotalExpense(spreadsheet.getTotalExpense().add(expenseDto.getValue()));
				if (expenseDto.isPaid()) {
					spreadsheet.setTotalPaid(expenseDto.getValue());
				}
			}
			spreadsheetService.saveSpreadSheet(spreadsheet);
		}
		return toDTO(repo.save(fromDTO(expenseDto)));
	}


	public void updateExpense(Integer id, ExpenseDTO expenseDto) {
		if(id != expenseDto.getId()) {
			throw new IllegalArgumentException("Invalida input parameters");
		}
		ExpenseDTO inc = findById(id);
		if(inc == null) {
			throw new IllegalArgumentException("Invalid expense id");
		}
		repo.save(fromDTO(expenseDto));
	}
	
	public Expense fromDTO(ExpenseDTO dto) {
		return new Expense(dto.getId(),dto.getLine(), dto.getName(), dto.getValue(), dto.isPaid(),
				new SpreadSheet(dto.getYear(), dto.getMonth()));
	}
	
	public ExpenseDTO toDTO(Expense expense) {
		return new ExpenseDTO(expense.getId(), expense.getLine(), expense.getName(), expense.getValue(), expense.isPaid(), expense.getSpreadSheet().getYear(), expense.getSpreadSheet().getMonth());
	}

}
