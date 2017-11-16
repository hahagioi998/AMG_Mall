package com.hafele.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafele.bean.GoodsBean;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月14日 下午1:21:58
* 首页Servlet
*/
@SuppressWarnings("serial")
public class IndexServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入了首页servlet");
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>(); //购物车集合
		request.setAttribute("shoppingCartGoodsList", goodsList);//gwcGoodsList
		request.getRequestDispatcher("/index.jsp").forward(request, response); //转发到首页
	}
	
}
