package com.jju.service.impl;

import java.util.List;

import com.jju.dao.IUserDao;
import com.jju.dao.impl.UserDaoImpl;
import com.jju.domain.User;
import com.jju.service.IUserService;

public class UserServiceImpl implements IUserService {
	private IUserDao useDao = new UserDaoImpl();

	@Override
	public List<User> finAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub

	}

	/**
	 * 用户登录
	 */
	public User login(String username) {
		User user = useDao.findByUsername(username);
		return user;
	}

}
