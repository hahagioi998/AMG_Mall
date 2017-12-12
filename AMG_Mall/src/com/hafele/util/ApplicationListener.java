package com.hafele.util;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.hafele.bean.BigTypeBean;
import com.hafele.bean.GoodsBean;
import com.hafele.bean.SlideBean;
import com.hafele.dao.BigTypeDao;
import com.hafele.dao.GoodsDao;
import com.hafele.dao.SlideDao;


/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月30日 下午2:54:12
* application监控
*/
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根
		System.out.println("application容器销毁");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO 自动生成的方法存根
		System.out.println("application容器初始化");
		//获取上下文对象  放入首页的内容
		List<BigTypeBean> floor = BigTypeDao.selList(); //获取楼层大类集合
		List<BigTypeBean> bigTypes = BigTypeDao.bigselList(); //获取大类及小类级联
		List<SlideBean> slideList = SlideDao.selList();  //获取幻灯图片集合
		List<GoodsBean> hotList = GoodsDao.salesTop(); //获取热门商品集合
		List<GoodsBean> specialSale = GoodsDao.specialSale(); //获取特卖商品集合
		
		ServletContext application = arg0.getServletContext();
		application.setAttribute("floor", floor);
		application.setAttribute("slideList", slideList);
		application.setAttribute("bigTypes", bigTypes);
		application.setAttribute("hotList", hotList);
		application.setAttribute("specialSale", specialSale);
		System.out.println("已放入application");
	}

}

