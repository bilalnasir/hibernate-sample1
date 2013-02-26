package com.at.et.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User 
{
	private static final long serialVersionUID = -5527566248002296042L;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	
	private Set<Expense> expense = new HashSet<Expense>();
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "is_enable", columnDefinition="BIT")
	private Boolean isEnable;
	
	@Column(name = "user_password")
	private String userPassword;
	
	public User()
	{
		
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getEmailAddress()
	{
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	public Boolean getIsEnable()
	{
		return isEnable;
	}
	
	public void setIsEnabled(Boolean isEnable)
	{
		this.isEnable = isEnable;
	}
	
	public String getUserPassword()
	{
		return userPassword;
	}
	
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	
	public Set<Expense> getExpense() 
	{
		return this.expense;
	}
	
	public void setExpense(Set<Expense> expense) {
		this.expense = expense;
	}
	
	public  String toString()
	{
		return "Details of the user-> id:" + this.id+" firstname:"+this.firstName +" Last Name: "+this.lastName+" email-id:"+this.emailAddress+" phone number: "+this.phoneNumber+" user_password: "+this.userPassword+" isEnable:"+this.isEnable;
	}
	
	
}

