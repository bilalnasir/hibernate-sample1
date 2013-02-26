package com.at.et.request;

public class ExpenseRequest 
{
	private static final long serialVersionUID = -5527566248002296042L;
	
	private Integer expenseTypeId;
	
	private Integer id;
	
	private String title;
	
	private Boolean reimbursable;
	
	private Integer total;
	
	private String date;
	
	private String status;
	
	private Boolean paid;
	
	public ExpenseRequest()
	{
		
	}
	
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public Boolean getReimbursable()
	{
		return reimbursable;
	}
	
	public void setReimbursable(Boolean reimbursable)
	{
		this.reimbursable = reimbursable;
	}
	
	public Integer getTotal()
	{
		return total;
	}
	
	public void setTotal(Integer total)
	{
		this.total = total;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public String getStatus()
	{
		return status;
	}
	
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public Boolean getPaid()
	{
		return paid;
	}
	
	public void setPaid(Boolean paid)
	{
		this.paid = paid;
	}
	
	public Integer getExpenseTypeId() {
		return this.expenseTypeId;
	}
	
	public void setExpenseTypeId(Integer expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}
	

	
	@Override
	public  String toString()
	{
		return "Details of the expense->  title:"+this.title +" Reimbursable: "+this.reimbursable+" total:"+this.total+" date: "+this.date+" status: "+this.status+" paid:"+this.paid +" Expense type id : "+expenseTypeId;
	}
	
	
}