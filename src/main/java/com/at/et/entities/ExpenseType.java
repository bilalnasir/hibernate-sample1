package com.at.et.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "expense_type")
public class ExpenseType 
{
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "expenseType")
	
	private Set<Expense> expense = new HashSet<Expense>();
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description",nullable = false)
    private String description;

    @Column(name="status",columnDefinition="BIT")
    private Boolean status;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    public Set<Expense> getExpense() 
	{
		return this.expense;
	}
    
	public void setExpense(Set<Expense> expense) {
		this.expense = expense;
	}
	@Override
	public  String toString()
	{
		return "Details of the expense_type-> id:" + this.id+" description:"+this.description +" name: "+this.name+" status:"+this.status;
	}
	
}
