package com.ssafy.ssafit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.ssafit.model.dao.UserDao;
import com.ssafy.ssafit.model.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return userDao.selectAll();
	}

	@Override
	public User getUser(String id) {
		// TODO Auto-generated method stub
		return userDao.selectUser(id);
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}



}
