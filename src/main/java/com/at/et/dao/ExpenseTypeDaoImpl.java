package com.at.et.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.at.et.entities.ExpenseType;

@Repository("expenseTypeDao")
@Component
public class ExpenseTypeDaoImpl implements ExpenseTypeDao {

	@Autowired
   	protected SessionFactory sessionFactory;
   	
	/**
	 * This dao method saves a new expense type in the database
	 */
	public void addExpenseType(ExpenseType expenseType)
	{
		sessionFactory.getCurrentSession().save(expenseType);
	}
	
	/**
	 * This dao method returns a list of all the expense types that are present
	 * in the database
	 */
	public List<ExpenseType> getAllExpenseType()
	{
		Query query = sessionFactory.getCurrentSession().createQuery("from ExpenseType");
		return query.list();
	}
	
	/**
	 * This dao method deletes the expense type corresponding to the 
	 * id that it gets from the params
	 */
	public void deleteExpenseType(Integer id)
	{
		ExpenseType expenseType = (ExpenseType) sessionFactory.getCurrentSession().get(ExpenseType.class, id);

		sessionFactory.getCurrentSession().delete(expenseType);
	}
	
	/**
	 * This dao method edits the expense type
	 */
	public void editExpenseType(ExpenseType expenseType)
	{
		ExpenseType existingExpenseType = (ExpenseType) sessionFactory.getCurrentSession().get(ExpenseType.class, expenseType.getId());
		existingExpenseType.setDescription(expenseType.getDescription());
		existingExpenseType.setName(expenseType.getName());
		existingExpenseType.setStatus(expenseType.getStatus());
		
		sessionFactory.getCurrentSession().save(existingExpenseType);
	}
	
	/**
	 * This dao method returns the expense type corresponding to the id
	 * that it gets from the params
	 */
	public ExpenseType getExpenseType(Integer id)
	{
		return (ExpenseType) sessionFactory.getCurrentSession().get(ExpenseType.class, id);
	}
}