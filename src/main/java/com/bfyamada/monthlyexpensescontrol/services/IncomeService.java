package com.bfyamada.monthlyexpensescontrol.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.Income;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.repositories.IncomeRepository;
import com.bfyamada.monthlyexpensescontrol.services.exceptions.ObjectNotFoundException;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository repo;
    
    public List<Income> findBySpreadSheetId(Integer year, Integer month){
    	return repo.findBySpreadSheet(new SpreadSheet(year, month));
    }

    public Income findById(String id){
        Income income = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Income nor Found"));
        return income;
    }

    public Income saveIncome(Income income){
        return repo.save(income);
    }

    public boolean deleteIncome(String id){
        repo.delete(findById(id));
        return true;
    }





}
