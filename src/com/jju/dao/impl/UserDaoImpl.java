package com.jju.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.jju.dao.IUserDao;
import com.jju.domain.User;
import com.jju.util.JdbcUtils;

/**
 * 对user的操作
 * @author aspire
 *
 */
public class UserDaoImpl implements IUserDao {
	
	QueryRunner qr = new QueryRunner();
	List<User> users = new ArrayList<User>();
	Connection connection = JdbcUtils.getConnection();
	

	/**
	 * 获取所有用户信息
	 */
	public List<User> getUsers() {
		
		Connection connection = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			
			
			stm = connection.createStatement();
			rs = stm.executeQuery("select * from users");
			
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				
				users.add(user);
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(rs, stm, connection);
		}
		
		return null;
	}


	/**
	 * 获取指定用户信息
	 */
	public User getOneUser() {
		
		try {
			return qr.query(connection, "select * from users where id = ?",
					new BeanHandler<User>(User.class), 1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public void updateUser() {
		String sql = "update users set username=?,password=? where id=?";
		try {
			qr.update(connection, sql, "张三","123456", 2);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * 插入一个新的用户信息
	 */
	@Override
	public void insertUser() {
		String sql = "insert into users(id,username,password) values(?,?,?)";
		try {
			qr.update(connection, sql, 2,"李四","333333");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * 删除一个用户信息
	 */
	@Override
	public void deleteUser() {
		String sql = "delete from users where id=?";
		try {
			qr.update(connection,sql,2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public User findByUsername(String username) {
		String sql = "select * from users where username=?";
		try {
			return qr.query(connection, sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("用户名错误");
		}
	}
	
}
