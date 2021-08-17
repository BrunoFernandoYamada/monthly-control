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

import com.bfyamada.monthlyexpensescontrol.core.domain.Income;
import com.bfyamada.monthlyexpensescontrol.core.dto.IncomeDTO;
import com.bfyamada.monthlyexpensescontrol.services.IncomeService;

@RestController
@RequestMapping(value = "/incomes")
public class IncomeController {

	@Autowired
	private IncomeService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Income> findById(@PathVariable String id){
		return ResponseEntity.ok(service.findById(id));
		
	}
	
	@GetMapping(value = "/{year}/{month}")
	public ResponseEntity<List<Income>> findBySpreadsheet(@PathVariable Integer year, @PathVariable Integer month){
		return ResponseEntity.ok(service.findBySpreadSheetId(year, month));
		
	}

	@PostMapping
	public ResponseEntity<Void> saveIncome(@RequestBody IncomeDTO income) {
		Income obj = service.saveIncome(income);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{year}/{month}").buildAndExpand(obj.getSpreadSheet().getYear(), obj.getSpreadSheet().getMonth()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
