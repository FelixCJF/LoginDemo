package com.jju.service;

import java.util.List;

import com.jju.domain.User;

public interface IUserService {
	public List<User> finAllUsers();
	public User findUser();
	public void insertUser();
	public void deleteUser();
	public void updateUser();
	public User login(String username);
}
