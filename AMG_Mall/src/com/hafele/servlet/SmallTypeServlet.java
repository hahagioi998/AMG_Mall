package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年12月1日 下午1:52:15
* 类说明
*/
@SuppressWarnings("serial")
public class SmallTypeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String MethodName = request.getServletPath();
		MethodName = MethodName.substring(1, MethodName.length() - 6);
		System.out.println("MethodName："+MethodName);
		try {
			Method method = getClass().getDeclaredMethod(MethodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
