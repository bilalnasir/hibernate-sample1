package com.at.et.service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.at.et.entities.Expense;

@Transactional
public interface ExpenseService 
{
	public void addExpense(Expense expense);
	public List<Expense> getAllExpenses();
	public void deleteExpense(Integer id);
	public Expense getExpense(Integer id);
	public void editExpense(Expense expense);
}
