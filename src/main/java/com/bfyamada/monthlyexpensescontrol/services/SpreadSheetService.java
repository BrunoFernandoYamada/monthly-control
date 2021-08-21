package com.bfyamada.monthlyexpensescontrol.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheetID;
import com.bfyamada.monthlyexpensescontrol.core.enums.Month;
import com.bfyamada.monthlyexpensescontrol.repositories.SpreadSheetRepository;
import com.bfyamada.monthlyexpensescontrol.services.exceptions.ObjectNotFoundException;

@Service
public class SpreadSheetService {


    @Autowired
    private SpreadSheetRepository spreadSheetRepository;

    public SpreadSheet findByYearAndMonth(Integer year, Integer month) {
        return spreadSheetRepository.findById(new SpreadSheetID(year,month)).orElseThrow(() -> new ObjectNotFoundException("SpreedSheet not found!"));
    }

    public List<SpreadSheet> findByYear(Integer year){
        return spreadSheetRepository.findByYear(year);
    }

    public Page<SpreadSheet> findAll(Pageable pageable){
        return spreadSheetRepository.findAll(pageable);
    }

    public SpreadSheet saveSpreadSheet(SpreadSheet spreadSheet){
        validateSpreadSheet(spreadSheet);
        return spreadSheetRepository.save(spreadSheet);
    }
    



    private void validateSpreadSheet(SpreadSheet spreadSheet){

        SpreadSheet sheet = spreadSheetRepository.findById(new SpreadSheetID(spreadSheet.getId().getMonth(), spreadSheet.getId().getYear())).orElse(null);
        if(!(sheet == null)){
            throw new IllegalArgumentException("The spreadsheet for requested month and year already exists!");
        }

        try{
            Month.toEnum(spreadSheet.getId().getMonth());
        }
        catch (IllegalArgumentException ex){
            throw ex;
        }
    }

}
