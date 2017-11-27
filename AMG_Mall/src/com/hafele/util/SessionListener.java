package com.hafele.util;

import java.util.HashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hafele.bean.GoodsBean;


/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月15日 上午9:51:33
* 
*/
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO 自动生成的方法存根
		System.out.println("创建了session对象");
		HashMap<String, GoodsBean> shoppingCart = new HashMap<String, GoodsBean>();
		arg0.getSession().setAttribute("shoppingCart", shoppingCart);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO 自动生成的方法存根
		System.out.println("销毁了session对象");
	}

}

