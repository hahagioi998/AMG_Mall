package com.hafele.util;

import java.util.HashMap;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hafele.bean.GoodsBean;


/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��15�� ����9:51:33
* 
*/
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO �Զ����ɵķ������
		System.out.println("������session����");
		HashMap<String, GoodsBean> shoppingCart = new HashMap<String, GoodsBean>();
		arg0.getSession().setAttribute("shoppingCart", shoppingCart);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO �Զ����ɵķ������
		System.out.println("������session����");
	}

}

