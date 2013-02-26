package com.at.et.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.at.et.entities.ExpenseType;

@Transactional
public interface ExpenseTypeService 
{
	public void addExpenseType(ExpenseType expenseType);
	public List<ExpenseType> getAllExpenseType();
	public void deleteExpenseType(Integer id);
	public void editExpenseType(ExpenseType expenseType);
	public ExpenseType getExpenseType(Integer id);
}
