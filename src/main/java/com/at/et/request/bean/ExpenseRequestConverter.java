package com.at.et.request.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.at.et.entities.Expense;
import com.at.et.request.ExpenseRequest;

public class ExpenseRequestConverter 
{
	private static final String DATE_PATTERNS = "yyyy-MM-dd";
	private static Date date;
	/**
	 * This method is converting the request to entity
	 * @param expenseRequest
	 * @return expense entity
	 * @throws ParseException 
	 */
	public static Expense convert(ExpenseRequest expenseRequest) throws ParseException
	{
		Expense expense = new Expense();
		expense.setId(expenseRequest.getId());
		expense.setDate(parseDate(expenseRequest.getDate()));
		expense.setPaid(expenseRequest.getPaid());
		expense.setReimbursable(expenseRequest.getReimbursable());
		expense.setStatus(expenseRequest.getStatus());
		expense.setTitle(expenseRequest.getTitle());
		expense.setTotal(expenseRequest.getTotal());
		
		return expense;
	}
	
	/**
	 * This method is converting string date to Date date
	 * @param expenseDate
	 * @return
	 * @throws ParseException
	 */
	private static Date parseDate(String expenseDate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERNS);
		date = sdf.parse(expenseDate);
		return date;
	}
}
