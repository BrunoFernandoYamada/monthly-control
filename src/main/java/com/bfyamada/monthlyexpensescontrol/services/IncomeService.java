package com.bfyamada.monthlyexpensescontrol.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.Income;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.core.dto.IncomeDTO;
import com.bfyamada.monthlyexpensescontrol.repositories.IncomeRepository;
import com.bfyamada.monthlyexpensescontrol.services.exceptions.ObjectNotFoundException;

@Service
public class IncomeService {

	@Autowired
	private SpreadSheetService spreadsheetService;

	@Autowired
	private IncomeRepository repo;

	public List<IncomeDTO> findBySpreadSheetId(Integer year, Integer month) {
		List<IncomeDTO> list = repo.findBySpreadSheet(new SpreadSheet(year, month)).stream().map(dto -> toDTO(dto) ).collect(Collectors.toList());
		return list;
	}

	public IncomeDTO findById(Integer id) {
		Income income = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Income nor Found"));
		return toDTO(income);
	}

	public IncomeDTO saveIncome(IncomeDTO incomeDto) {
		
		Income inc = repo.findBySpreadSheetAndLine(new SpreadSheet(incomeDto.getYear(), incomeDto.getMonth()), incomeDto.getLine());
		
		if(inc != null) {
			throw new IllegalArgumentException("Invalid request input");
		}
		
		SpreadSheet spreadsheet = spreadsheetService.findByYearAndMonth(incomeDto.getYear(), incomeDto.getMonth());
		if (spreadsheet == null) {
			spreadsheet = new SpreadSheet(incomeDto.getYear(), incomeDto.getMonth(), incomeDto.getValue(),
					new BigDecimal(0), incomeDto.isReceived() ? incomeDto.getValue() : new BigDecimal(0),
					new BigDecimal(0), false, incomeDto.getValue());
			spreadsheetService.saveSpreadSheet(spreadsheet);
		} else {
			if(!(incomeDto.getValue() == new BigDecimal(0) || incomeDto.getValue() == null)){
				spreadsheet.setTotalIncome(spreadsheet.getTotalIncome().add(incomeDto.getValue()));
				if (incomeDto.isReceived()) {
					spreadsheet.setTotalPaid(incomeDto.getValue());
				}
			}else{
                incomeDto.setValue(new BigDecimal(0));
            }
			spreadsheetService.saveSpreadSheet(spreadsheet);
		}
		 return toDTO(repo.save(fromDTO(incomeDto)));
	}

	public boolean deleteIncome(Integer id) {
		repo.delete(fromDTO(findById(id)));
		return true;
	}

	public void updateIncome(Integer id, IncomeDTO incomeDto) {
		if(id != incomeDto.getId()) {
			throw new IllegalArgumentException("Invalida input parameters");
		}
		
		IncomeDTO inc = findById(id);
		if(inc == null) {
			throw new IllegalArgumentException("Invalid income id");
		}
		repo.save(fromDTO(incomeDto));
	}

	public Income fromDTO(IncomeDTO dto) {
		return new Income(dto.getId(), dto.getLine(), dto.getName(), dto.getValue(), dto.isReceived(),
				new SpreadSheet(dto.getYear(), dto.getMonth()));
	}
	
	public IncomeDTO toDTO(Income income) {
		return new IncomeDTO(income.getId(), income.getLine(), income.getName(), income.getValue(), income.isReceived(), income.getSpreadSheet().getYear(), income.getSpreadSheet().getMonth());
	}

}
