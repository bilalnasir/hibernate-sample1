package com.at.et.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.at.et.dao.ExpenseTypeDao;
import com.at.et.entities.ExpenseType;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
	
	@Autowired
	private ExpenseTypeDao expenseTypeDao;
	
	public void addExpenseType(ExpenseType expenseType)
	{
		expenseTypeDao.addExpenseType(expenseType);
	}
	
	public List<ExpenseType> getAllExpenseType()
	{
		return expenseTypeDao.getAllExpenseType();
	}
	
	public void deleteExpenseType(Integer id)
	{
		expenseTypeDao.deleteExpenseType(id);
	}
	
	public void editExpenseType(ExpenseType expenseType)
	{
		expenseTypeDao.editExpenseType(expenseType);
	}
	
	public ExpenseType getExpenseType(Integer id)
	{
		return expenseTypeDao.getExpenseType(id);
	}
}
