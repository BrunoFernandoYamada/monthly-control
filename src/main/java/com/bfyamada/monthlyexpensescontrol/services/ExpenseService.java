package com.bfyamada.monthlyexpensescontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.Expense;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.repositories.ExpenseRepository;
import com.bfyamada.monthlyexpensescontrol.services.exceptions.ObjectNotFoundException;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepository repo;

	public List<Expense> findBySpreadSheetId(Integer year, Integer month) {
		return repo.findBySpreadSheet(new SpreadSheet(year, month));
	}

	public Expense findById(Integer id) {
		Expense expense = findById(id);
		if (expense == null) {
			throw new ObjectNotFoundException("Income nor Found");
		}
		return expense;
	}

	public Expense saveExpense(Expense expense) {
		return repo.save(expense);
	}

	public boolean deleteExpense(Integer id) {
		repo.delete(findById(id));
		return true;
	}

}
