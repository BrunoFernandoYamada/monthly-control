package com.bfyamada.monthlyexpensescontrol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bfyamada.monthlyexpensescontrol.core.domain.Income;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer> {
	 List<Income> findBySpreadSheet(SpreadSheet spreadSheet);

	Income findByLine(int line);
}
