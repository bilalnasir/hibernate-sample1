package com.at.et.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.at.et.dao.ExpenseDao;
import com.at.et.entities.Expense;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseDao expenseDao;
	
	public void addExpense(Expense expense)
	{
		expenseDao.addExpense(expense);
	}
	
	public List<Expense> getAllExpenses()
	{
		return expenseDao.getAllExpenses();
	}

	public Expense getExpense(Integer id)
	{
		return expenseDao.getExpense(id);
	}
	
	public void deleteExpense(Integer id)
	{
		expenseDao.deleteExpense(id);
	}
	
	public void editExpense(Expense expense)
	{
		expenseDao.editExpense(expense);
	}
}
