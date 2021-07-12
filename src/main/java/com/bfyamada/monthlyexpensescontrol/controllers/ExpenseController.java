package com.bfyamada.monthlyexpensescontrol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bfyamada.monthlyexpensescontrol.core.domain.Expense;
import com.bfyamada.monthlyexpensescontrol.services.ExpenseService;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {

	@Autowired
	private ExpenseService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Expense> findById(@PathVariable Integer id){
		return ResponseEntity.ok(service.findById(id));	
	}
	
	@GetMapping(value = "/{year}/{month}")
	public ResponseEntity<List<Expense>> findBySpreadsheet(@PathVariable Integer year, @PathVariable Integer month){
		return ResponseEntity.ok(service.findBySpreadSheetId(year, month));
		
	}

	@PostMapping
	public ResponseEntity<Void> saveExpense(@RequestBody Expense expense) {
		Expense obj = service.saveExpense(expense);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{year}/{month}").buildAndExpand(obj.getSpreadSheet().getYear(), obj.getSpreadSheet().getMonth()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
