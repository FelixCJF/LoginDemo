package com.jju.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.login.LoginContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jju.domain.User;
import com.jju.service.IUserService;
import com.jju.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private IUserService userService = new UserServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String op = request.getParameter("op");
		if ("login".equalsIgnoreCase(op)) {
			Login(request, response);
		}
		
	}

	private void Login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
 		User user = userService.login(username);
 		if (!password.equals(user.getPassword())) {
			throw new RuntimeException("用户名或密码不匹配");
		}
		out.write("登录成功,两秒后转向主页");
		response.setHeader("Refresh", "2;URL="+request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
