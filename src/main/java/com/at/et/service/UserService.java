package com.at.et.service;

import org.springframework.transaction.annotation.Transactional;
import com.at.et.entities.User;

@Transactional
public interface UserService {

	public void addUser(User user);
	public User getUser(String userEmail);
}
