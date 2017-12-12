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
* @version ����ʱ�䣺2017��11��30�� ����2:54:12
* application���
*/
public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO �Զ����ɵķ������
		System.out.println("application��������");
	}

	@SuppressWarnings("unchecked")
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO �Զ����ɵķ������
		System.out.println("application������ʼ��");
		//��ȡ�����Ķ���  ������ҳ������
		List<BigTypeBean> floor = BigTypeDao.selList(); //��ȡ¥����༯��
		List<BigTypeBean> bigTypes = BigTypeDao.bigselList(); //��ȡ���༰С�༶��
		List<SlideBean> slideList = SlideDao.selList();  //��ȡ�õ�ͼƬ����
		List<GoodsBean> hotList = GoodsDao.salesTop(); //��ȡ������Ʒ����
		List<GoodsBean> specialSale = GoodsDao.specialSale(); //��ȡ������Ʒ����
		
		ServletContext application = arg0.getServletContext();
		application.setAttribute("floor", floor);
		application.setAttribute("slideList", slideList);
		application.setAttribute("bigTypes", bigTypes);
		application.setAttribute("hotList", hotList);
		application.setAttribute("specialSale", specialSale);
		System.out.println("�ѷ���application");
	}

}

