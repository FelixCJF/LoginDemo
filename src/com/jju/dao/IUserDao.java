package com.jju.dao;

import java.util.List;

import com.jju.domain.User;

public interface IUserDao {
	public List<User> getUsers();
	public User getOneUser();
	public void updateUser();
	public void insertUser();
	public void deleteUser();
	public User findByUsername(String username);
}
