package com.at.et.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.at.et.dao.UserDao;
import com.at.et.entities.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void addUser(User user)
	{
		userDao.addUser(user);
	}
	public User getUser(String userEmail)
	{
		return userDao.getUser(userEmail);
	}

}
