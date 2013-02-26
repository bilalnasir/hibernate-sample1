package com.at.et.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.at.et.entities.ExpenseType;

@Transactional
public interface ExpenseTypeDao{

	public void addExpenseType(ExpenseType expenseType);
	public List<ExpenseType> getAllExpenseType();
	public void deleteExpenseType(Integer id);
	public void editExpenseType(ExpenseType expenseType);
	public ExpenseType getExpenseType(Integer id);
}
