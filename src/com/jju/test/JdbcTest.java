package com.jju.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jju.dao.IUserDao;
import com.jju.dao.impl.UserDaoImpl;
import com.jju.domain.User;

public class JdbcTest {
	private IUserDao userDao = new UserDaoImpl();
	
	@Test
	public void queryTest(){
		List<User> users = userDao.getUsers();
		for (User user : users) {
			System.out.println(user.getId()+user.getUsername()+user.getPassword());
		}
	}
	
	@Test
	public void findOneTest(){
		User user = userDao.getOneUser();
		System.out.println(user.getId()+user.getUsername()+user.getPassword());
	}
	@Test
	public void updateTest(){
		userDao.updateUser();
	}
	
	@Test
	public void deleteTest(){
		userDao.deleteUser();
	}
	
	@Test
	public void insertTest(){
		userDao.insertUser();
	}
}






