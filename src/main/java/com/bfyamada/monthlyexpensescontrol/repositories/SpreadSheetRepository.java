package com.bfyamada.monthlyexpensescontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheetID;

@Repository
public interface SpreadSheetRepository extends JpaRepository<SpreadSheet, SpreadSheetID> {
	@Query(value = "Select * From SpreadSheet ss where ss.id.year :=currentYear",nativeQuery = true )
    List<SpreadSheet> findAllByYear(@Param("currentYear") Integer currentYear);
}
