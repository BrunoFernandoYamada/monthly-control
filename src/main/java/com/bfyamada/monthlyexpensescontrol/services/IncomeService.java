package com.bfyamada.monthlyexpensescontrol.services;

import java.math.BigDecimal;
import java.util.List;

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
    
    public List<Income> findBySpreadSheetId(Integer year, Integer month){
    	return repo.findBySpreadSheet(new SpreadSheet(year, month));
    }

    public Income findById(String id){
        Income income = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Income nor Found"));
        return income;
    }

    public Income saveIncome(IncomeDTO incomeDto){
    	SpreadSheet spreadsheet = spreadsheetService.findByYearAndMonth(incomeDto.getYear(), incomeDto.getYear());
    	if(spreadsheet == null) {
    		spreadsheet = new SpreadSheet(incomeDto.getYear(), incomeDto.getMonth(), incomeDto.getValue(), new BigDecimal(0), incomeDto.isReceived()? incomeDto.getValue(): new BigDecimal(0), new BigDecimal(0), false, incomeDto.getValue());  		
    		spreadsheetService.saveSpreadSheet(spreadsheet);
    	}else {
    		spreadsheet.setTotalIncome(spreadsheet.getTotalIncome().add(incomeDto.getValue()));
    		if(incomeDto.isReceived()) {
    			spreadsheet.setTotalPaid(incomeDto.getValue());
    		}
    		spreadsheetService.saveSpreadSheet(spreadsheet);
    	}
        return repo.save(fromDTO(incomeDto));
    }

    public boolean deleteIncome(String id){
        repo.delete(findById(id));
        return true;
    }

    public Income fromDTO(IncomeDTO dto) {
		return new Income(null, dto.getName(), dto.getDescription(), dto.getValue(), dto.isReceived(), new SpreadSheet(dto.getYear(), dto.getMonth()));		
	}




}
