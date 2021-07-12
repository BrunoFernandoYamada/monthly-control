package com.bfyamada.monthlyexpensescontrol.services;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bfyamada.monthlyexpensescontrol.core.domain.Expense;
import com.bfyamada.monthlyexpensescontrol.core.domain.Income;
import com.bfyamada.monthlyexpensescontrol.core.domain.SpreadSheet;
import com.bfyamada.monthlyexpensescontrol.repositories.ExpenseRepository;
import com.bfyamada.monthlyexpensescontrol.repositories.IncomeRepository;
import com.bfyamada.monthlyexpensescontrol.repositories.SpreadSheetRepository;

@Service
public class DBService {
	
	@Autowired
	private SpreadSheetRepository spreadSheetRepository;
	
	@Autowired 
	private IncomeRepository incomeRepository;
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	
	public void instantiateDatabase(){
		
		
		SpreadSheet spreadSheet1 = new SpreadSheet(2021, 1, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet2 = new SpreadSheet(2021, 2, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet3 = new SpreadSheet(2021, 3, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet4 = new SpreadSheet(2021, 4, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet5 = new SpreadSheet(2021, 5, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet6 = new SpreadSheet(2021, 6, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		SpreadSheet spreadSheet7 = new SpreadSheet(2021, 7, new BigDecimal(0.0), new BigDecimal(0.0),new BigDecimal(0.0),new BigDecimal(0.0), false,new BigDecimal(0.0));
		
		Income i1 = new Income(null, "Salário", "Recebimento de Salario do mês de Julho",new BigDecimal(8000.00), true, spreadSheet1);
		Income i2 = new Income(null, "Aluguel", "Casa alugada",new BigDecimal(816.99), true, spreadSheet1);
		
		Income i3 = new Income(null, "Salário", "Recebimento de Salario do mês de Julho",new BigDecimal(8000.00), true, spreadSheet2);
		Income i4 = new Income(null, "Aluguel", "Casa alugada",new BigDecimal(816.99), true, spreadSheet2);
		
		Income i5 = new Income(null, "Salário", "Recebimento de Salario do mês de Julho",new BigDecimal(8000.00), true, spreadSheet3);
		Income i6 = new Income(null, "Aluguel", "Casa alugada",new BigDecimal(816.99), true, spreadSheet3);
		
		Income i7 = new Income(null, "Salário", "Recebimento de Salario do mês de Julho",new BigDecimal(8000.00), true, spreadSheet4);
		Income i8 = new Income(null, "Aluguel", "Casa alugada",new BigDecimal(816.99), true, spreadSheet4);
		
		Income i9 = new Income(null, "Salário", "Recebimento de Salario do mês de Julho",new BigDecimal(8000.00), true, spreadSheet5);
		Income i10 = new Income(null, "Aluguel", "Casa alugada",new BigDecimal(816.99), true, spreadSheet5);
		
		Income i11 = new Income(null, "Salário", "Recebimento de Salario do mês de Julho",new BigDecimal(8000.00), true, spreadSheet6);
		Income i12 = new Income(null, "Aluguel", "Casa alugada",new BigDecimal(816.99), true, spreadSheet6);
		
		Income i13 = new Income(null, "Salário", "Recebimento de Salario do mês de Julho",new BigDecimal(8000.00), true, spreadSheet7);
		Income i14 = new Income(null, "Aluguel", "Casa alugada",new BigDecimal(816.99), true, spreadSheet7);
		
		spreadSheet1.getIncomes().addAll(Arrays.asList(i1,i2));
		spreadSheet2.getIncomes().addAll(Arrays.asList(i3,i4));
		spreadSheet3.getIncomes().addAll(Arrays.asList(i5,i6));
		spreadSheet4.getIncomes().addAll(Arrays.asList(i7,i8));
		spreadSheet5.getIncomes().addAll(Arrays.asList(i9,i10));
		spreadSheet6.getIncomes().addAll(Arrays.asList(i11,i12));
		spreadSheet7.getIncomes().addAll(Arrays.asList(i13,i14));
		
		Expense e1 = new Expense(null, "Aluguél", null, new BigDecimal(1250.00), false, spreadSheet1);
		Expense e2 = new Expense(null, "Luz", null, new BigDecimal(250.00), false, spreadSheet1);
		Expense e3 = new Expense(null, "Gás", null, new BigDecimal(105.00), false, spreadSheet1);
		
		Expense e4 = new Expense(null, "Aluguél", null, new BigDecimal(1250.00), false, spreadSheet2);
		Expense e5 = new Expense(null, "Luz", null, new BigDecimal(250.00), false, spreadSheet2);
		Expense e6 = new Expense(null, "Gás", null, new BigDecimal(105.00), false, spreadSheet2);
		
		Expense e7 = new Expense(null, "Aluguél", null, new BigDecimal(1250.00), false, spreadSheet3);
		Expense e8 = new Expense(null, "Luz", null, new BigDecimal(250.00), false, spreadSheet3);
		Expense e9 = new Expense(null, "Gás", null, new BigDecimal(105.00), false, spreadSheet3);
		
		Expense e10 = new Expense(null, "Aluguél", null, new BigDecimal(1250.00), false, spreadSheet4);
		Expense e11 = new Expense(null, "Luz", null, new BigDecimal(250.00), false, spreadSheet4);
		Expense e12 = new Expense(null, "Gás", null, new BigDecimal(105.00), false, spreadSheet4);
		
		Expense e13 = new Expense(null, "Aluguél", null, new BigDecimal(1250.00), false, spreadSheet5);
		Expense e14 = new Expense(null, "Luz", null, new BigDecimal(250.00), false, spreadSheet5);
		Expense e15 = new Expense(null, "Gás", null, new BigDecimal(105.00), false, spreadSheet5);
		
		Expense e16 = new Expense(null, "Aluguél", null, new BigDecimal(1250.00), false, spreadSheet6);
		Expense e17 = new Expense(null, "Luz", null, new BigDecimal(250.00), false, spreadSheet6);
		Expense e18 = new Expense(null, "Gás", null, new BigDecimal(105.00), false, spreadSheet6);
		
		Expense e19 = new Expense(null, "Aluguél", null, new BigDecimal(1250.00), false, spreadSheet7);
		Expense e20 = new Expense(null, "Luz", null, new BigDecimal(250.00), false, spreadSheet7);
		Expense e21 = new Expense(null, "Gás", null, new BigDecimal(105.00), false, spreadSheet7);
		
		spreadSheet1.getExpenses().addAll(Arrays.asList(e1, e2, e3));
		spreadSheet2.getExpenses().addAll(Arrays.asList(e4, e5, e6));
		spreadSheet3.getExpenses().addAll(Arrays.asList(e7, e8, e9));
		spreadSheet4.getExpenses().addAll(Arrays.asList(e10, e11, e12));
		spreadSheet5.getExpenses().addAll(Arrays.asList(e13, e14, e15));
		spreadSheet6.getExpenses().addAll(Arrays.asList(e16 , e17, e18));
		spreadSheet7.getExpenses().addAll(Arrays.asList(e19, e20, e21));
		
		
		spreadSheetRepository.saveAll(Arrays.asList(spreadSheet1,spreadSheet2, spreadSheet3, spreadSheet4, spreadSheet5, spreadSheet6, spreadSheet7));
		
		incomeRepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5 , i6, i7, i8, i9, i10, i11, i12, i13, i14));
		expenseRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20, e21));
	}
	
	
	
	


}
