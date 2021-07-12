package com.bfyamada.monthlyexpensescontrol.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.services.SpreadSheetService;

@RestController
@RequestMapping(value = "/spreadsheets")
public class SpreadSheetController {

	@Autowired
	private SpreadSheetService service;
	
	@GetMapping
	public ResponseEntity<Page<SpreadSheet>> findAll(Pageable pageable){
		Page<SpreadSheet> sheet = service.findAll(pageable);
		return ResponseEntity.ok().body(sheet);
	}

	@GetMapping(value = "/current-year")
	public ResponseEntity<List<SpreadSheet>> getSpreadSheetCurrentYear() {
		return ResponseEntity.ok().body(service.findAllByYear());
	}

	@PostMapping
	public ResponseEntity<SpreadSheet> saveSpreadSheet(@RequestBody SpreadSheet spreadSheet) {
		SpreadSheet obj = service.saveSpreadSheet(spreadSheet);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{year}/{month}")
				.buildAndExpand(obj.getId().getYear(), obj.getId().getMonth()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
