package com.at.et.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.at.et.entities.User;

@Repository("userDao")
@Component
public class UserDaoImpl implements UserDao 
{
	@Autowired
   	protected SessionFactory sessionFactory;
   	
	/**
	 * This dao method saves the new user to the database
	 */
	public void addUser(User user)
	{
		sessionFactory.getCurrentSession().save(user);
	}
	
	/**
	 * This dao method returns the user corresponding to the email given
	 */
	public User getUser(String userEmail)
	{
		Query query= (Query) sessionFactory.getCurrentSession().createQuery("from User where email_address= :userEmail").setString("userEmail", userEmail);
		return (User) query.list().get(0);
	}
}
