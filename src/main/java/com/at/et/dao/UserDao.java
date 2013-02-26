package com.at.et.dao;

import org.springframework.transaction.annotation.Transactional;
import com.at.et.entities.User;

@Transactional
public interface UserDao{

	public void addUser(User user);
	public User getUser(String userEmail);
}
