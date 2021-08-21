package com.bfyamada.monthlyexpensescontrol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bfyamada.monthlyexpensescontrol.core.domain.Expense;
import com.bfyamada.monthlyexpensescontrol.core.dto.ExpenseDTO;
import com.bfyamada.monthlyexpensescontrol.core.dto.IncomeDTO;
import com.bfyamada.monthlyexpensescontrol.services.ExpenseService;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ExpenseDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(service.findById(id));	
	}
	
	@GetMapping(value = "/{year}/{month}")
	public ResponseEntity<List<ExpenseDTO>> findBySpreadsheet(@PathVariable Integer year, @PathVariable Integer month){
		return ResponseEntity.ok(service.findBySpreadSheetId(year, month));
		
	}

	@PostMapping
	public ResponseEntity<Void> saveExpense(@RequestBody ExpenseDTO expense) {
		ExpenseDTO obj = service.saveExpense(expense);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{year}/{month}").buildAndExpand(obj.getYear(), obj.getMonth()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> updateExpense(@PathVariable Integer id,@RequestBody ExpenseDTO expense) {
		service.updateExpense(id, expense);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> updateIncome(@PathVariable Integer id) {
		service.deleteExpense(id);
		return ResponseEntity.ok().build();
	}
}
