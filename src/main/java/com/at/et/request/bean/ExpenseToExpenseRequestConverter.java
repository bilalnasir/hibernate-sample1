package com.at.et.request.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.at.et.entities.Expense;
import com.at.et.request.ExpenseRequest;

public class ExpenseToExpenseRequestConverter 
{
	private static String date;
	/**
	 * This method is converting the request to entity
	 * @param expenseRequest
	 * @return expense entity
	 * @throws ParseException 
	 */
	public static ExpenseRequest convert(Expense expense) throws ParseException
	{
		ExpenseRequest expenseRequest = new ExpenseRequest();
		expenseRequest.setId(expense.getId());
		expenseRequest.setDate(parseDateString(expense.getDate()));
		expenseRequest.setPaid(expense.getPaid());
		expenseRequest.setReimbursable(expense.getReimbursable());
		expenseRequest.setStatus(expense.getStatus());
		expenseRequest.setTitle(expense.getTitle());
		expenseRequest.setTotal(expense.getTotal());
		
		return expenseRequest;
	}
	
	/**
	 * This method is converting Date date to string date
	 * @param expenseDate
	 * @return
	 * @throws ParseException
	 */
	private static String parseDateString(Date expenseDate) throws ParseException
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.format(expenseDate);
		return date;
	}
}

