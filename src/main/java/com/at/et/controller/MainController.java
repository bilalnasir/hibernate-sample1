package com.at.et.controller;

import java.text.ParseException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.at.et.entities.Expense;
import com.at.et.entities.ExpenseType;
import com.at.et.entities.User;
import com.at.et.request.ExpenseRequest;
import com.at.et.request.bean.ExpenseRequestConverter;
import com.at.et.request.bean.ExpenseToExpenseRequestConverter;
import com.at.et.service.ExpenseService;
import com.at.et.service.ExpenseTypeService;
import com.at.et.service.UserService;

@Controller
@RequestMapping("/main")
public class MainController
{
	private Logger logger = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private ExpenseTypeService expenseTypeService;
	@Autowired
	private UserService userService;

	/**
	 * This function fetches all the expenses from the database and
	 * returns the page showing all the details of those expenses
	 * @param model
	 * @return expensespage showing all expenses
	*/
	@RequestMapping(value="/expenses",method=RequestMethod.GET)
	public String getExpenses(Model model)
	{
		logger.debug("Request to show all expenses.");
		
		List<Expense> expenseList = expenseService.getAllExpenses();
		logger.debug("Retreive list of size {}",expenseList.size());
		
		model.addAttribute("expenses",expenseList);
		
		logger.debug("Leaving getExpenses()");
		return "expensespage";
	}
	
	/**
	 * This function create a new expense and pass it as attributes to the jsp page
	 * and returns that page
	 * @param model
	 * @return addpage to add a new expense
	 */
	@RequestMapping(value="/expenses/add", method=RequestMethod.GET)
	public String getAdd(Model model)
	{
		logger.debug("Request to get add page for expene");
		
		model.addAttribute("expenseAttribute", new ExpenseRequest());
		model.addAttribute("expenseTypeAttribute",expenseTypeService.getAllExpenseType());
		
		logger.debug("ExpenseTypes added to the model attribute with values {}",expenseTypeService.getAllExpenseType());
		return "addpage";
	}

	/**
	 * This function gets the values from the ModelAttributes and save them in the database
	 * @param expenseRequest
	 * @return addedpage
	*/
	@RequestMapping(value="/expenses/add/user",method=RequestMethod.POST)
	public String add(@ModelAttribute("expenseAttribute") ExpenseRequest expenseRequest, @RequestParam(value = "email") String email, Model model)
	{
		logger.debug("Request to add a new expense with details {}",expenseRequest.toString());
		
		Expense expense = null;
		try {
			expense = ExpenseRequestConverter.convert(expenseRequest);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Converted expense request to expense -> {}",expense);
		
		ExpenseType expenseType = expenseTypeService.getExpenseType(expenseRequest.getExpenseTypeId());
		logger.debug("got the expense type with details -> {}",expenseTypeService.getExpenseType(expenseRequest.getExpenseTypeId()));
		
		User user = userService.getUser(email);
		logger.debug("got the user with details -> {}",user.toString());
		
		expense.setExpenseType(expenseType);
		expense.setUser(user);
		
		expenseService.addExpense(expense);
		return "addedpage";
	}

	/**
	* This function fetches the id of expense from url and deletes it from 
	* the database and returns the confirmation page
	* @param id
	* @param model
	* @return deletedpage confirming expense has been deleted
	*/
	@RequestMapping(value="/expenses/delete",method=RequestMethod.GET)
	public String delete(@RequestParam(value="id",required=true) Integer id,Model model)
	{
		logger.debug("Request to delete an expense with id"+id);
		
		expenseService.deleteExpense(id);
		logger.debug("Expense with id{} has been deleted.",id);
		
		model.addAttribute("id",id);
		return "deletedpage";
	}
	
	/**
	 * This function fetches the id of the expense from the url and then fetches its 
	 * data from the database and populates into the jsp page so that they can be 
	 * edited
	 * @param id
	 * @param model
	 * @return editpage to edit an expense
	*/
	@RequestMapping(value="/expenses/edit",method=RequestMethod.GET)
	public String getEdit(@RequestParam(value="id",required=true) Integer id,Model model)
	{
		logger.debug("Request to get edit page to edit expense with id {}",id);
		
		ExpenseRequest expenseRequest = null;
		try {
			expenseRequest = ExpenseToExpenseRequestConverter.convert(expenseService.getExpense(id));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("converted expense to expenseRequest details -> {}",expenseRequest);
		
		model.addAttribute("expenseAttribute",expenseRequest);
		model.addAttribute("expenseTypeAttribute",expenseTypeService.getAllExpenseType());
		
		return "editpage";
	}

	/**
	 * This function gets the id of a expense from the url and edits the details
	 * of that expense that it got from the request parameters and returns the
	 * confirmation page showing the expense's details has been edited
	 * @param expenseRequest
	 * @param id
	 * @param model
	 * @return editedpage showing expense has been edited
	 */
	@RequestMapping(value="/expenses/edit",method=RequestMethod.POST)
	public String saveEdit(@ModelAttribute("expenseAttribute") ExpenseRequest expenseRequest,@RequestParam(value="id", required=true) Integer id,Model model)
	{
		logger.debug("Request to save the edited fields of the expense with id {} with values {}",id,expenseRequest.toString());
		
		Expense expense = null;
		try {
			expense = ExpenseRequestConverter.convert(expenseRequest);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("Converted expense {}",expense.toString());
		
		expense.setExpenseType(expenseTypeService.getExpenseType(expenseRequest.getExpenseTypeId()));
		expenseService.editExpense(expense);
		
		logger.debug("Expense has been edit with id {} and values {}",id,expense.toString());
		model.addAttribute("id",id);
		
		return "editedpage";
	}
	
	/**
	 * This function fetches all the expense types from the database and
	 * returns the page showing all the details of those expenses types
	 * @param model
	 * @return expensespage showing all expense types
	*/
	@RequestMapping(value="/expensetypes",method=RequestMethod.GET)
	public String getExpenseTypes(Model model)
	{
		logger.debug("Request to show all expense types.");
		
		List<ExpenseType> expenseTypeList = expenseTypeService.getAllExpenseType();
		logger.debug("Retreive list of size {}",expenseTypeList.size());
		
		model.addAttribute("expensetypes",expenseTypeList);
		
		logger.debug("Leaving getExpenseTypes()");
		return "expensetypepage";
	}
	
	/**
	 * This function create a new expense type and pass it as attributes to the jsp page
	 * and returns that page
	 * @param model
	 * @return addpage to add a new expense type
	 */
	@RequestMapping(value="/expensetypes/add", method=RequestMethod.GET)
	public String getAddExpenseType(Model model)
	{
		logger.debug("Request to get add page for expense type");
		
		model.addAttribute("expensetypeAttribute", new ExpenseType());
		
		return "addetpage";
	}
	
	/**
	 * This function gets the values from the ModelAttributes and save them in the database
	 * @param expenseType
	 * @return addedpage
	*/
	@RequestMapping(value="/expensetypes/add/expensetype",method=RequestMethod.POST)
	public String addExpenseType(@ModelAttribute("expensetypeAttribute") ExpenseType expenseType,Model model)
	{
		logger.debug("Request to add a new expense type with details {}",expenseType.toString());
	
		expenseTypeService.addExpenseType(expenseType);
		return "addedetpage";
	}
	
	/**
	* This function fetches the id of expense type from url and deletes it from 
	* the database and returns the confirmation page
	* @param id
	* @param model
	* @return deletedpage confirming expense type has been deleted
	*/
	@RequestMapping(value="/expensetypes/delete",method=RequestMethod.GET)
	public String deleteExpenseType(@RequestParam(value="id",required=true) Integer id,Model model)
	{
		logger.debug("Request to delete an expense with id"+id);
		
		expenseTypeService.deleteExpenseType(id);
		logger.debug("Expense type with id{} has been deleted.",id);
		
		model.addAttribute("id",id);
		return "deletedetpage";
	}
	
	/**
	 * This function fetches the id of the expense type from the url and then fetches its 
	 * data from the database and populates into the jsp page so that they can be 
	 * edited
	 * @param id
	 * @param model
	 * @return editpage to edit an expense type
	*/
	@RequestMapping(value="/expensetypes/edit",method=RequestMethod.GET)
	public String getEditExpenseType(@RequestParam(value="id",required=true) Integer id,Model model)
	{
		logger.debug("Request to get edit page to edit expense type with id {}",id);
		
		ExpenseType expenseType = expenseTypeService.getExpenseType(id);
		logger.debug("Expense type returned from service corresponding to id {} has details {}",id,expenseType.toString());
		
		model.addAttribute("expensetypeAttribute",expenseType);
		
		return "editetpage";
	}

	/**
	 * This function gets the id of an expense type from the url and edits the details
	 * of that expense type that it got from the request parameters and returns the
	 * confirmation page showing the expense types's details has been edited
	 * @param expenseType
	 * @param id
	 * @param model
	 * @return editedpage showing expense type has been edited
	 */
	@RequestMapping(value="/expensetypes/edit",method=RequestMethod.POST)
	public String saveEditExpenseType(@ModelAttribute("expensetypeAttribute") ExpenseType expenseType,@RequestParam(value="id", required=true) Integer id,Model model)
	{
		logger.debug("Request to save the edited fields of the expense type with id {} with values {}",id,expenseType.toString());
		
		expenseTypeService.editExpenseType(expenseType);
		
		model.addAttribute("id",id);
		
		return "editedetpage";
	}
			
}