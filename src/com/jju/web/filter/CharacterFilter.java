package com.jju.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class CharacterFilter implements Filter {
	private String encoding = "UTF-8";
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest re, ServletResponse rs,
			FilterChain chain) throws IOException, ServletException {
		//必须转成HTTP协议的request类,因为放行后的servlet有可能会使用http协议的
		HttpServletRequest request = (HttpServletRequest) re;
		HttpServletResponse response = (HttpServletResponse) rs;
	    //解决POST请求参数中文编码问题
		request.setCharacterEncoding(encoding);
		//输出编码及通知客户端编码
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);

		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
}

