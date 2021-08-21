package com.bfyamada.monthlyexpensescontrol.controllers;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
	public ResponseEntity<IncomeDTO> findById(@PathVariable Integer id){
		return ResponseEntity.ok(service.findById(id));
		
	}
	
	@GetMapping(value = "/{year}/{month}")
	public ResponseEntity<List<IncomeDTO>> findBySpreadsheet(@PathVariable Integer year, @PathVariable Integer month){
		return ResponseEntity.ok(service.findBySpreadSheetId(year, month));
		
	}

	@PostMapping
	public ResponseEntity<Void> saveIncome(@RequestBody IncomeDTO income) {
		IncomeDTO obj = service.saveIncome(income);
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequest().path("/{year}/{month}").buildAndExpand(obj.getYear(), obj.getMonth()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> updateIncome(@PathVariable Integer id,@RequestBody IncomeDTO income) {
		service.updateIncome(id, income);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> updateIncome(@PathVariable Integer id) {
		service.deleteIncome(id);
		return ResponseEntity.ok().build();
	}
	
	
}
