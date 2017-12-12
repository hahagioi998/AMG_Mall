package com.hafele.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafele.bean.GoodsBean;
import com.hafele.bean.ShoppingCart;
import com.hafele.dao.GoodsDao;
import com.hafele.dao.ShoppingCartDao;
import com.hafele.dao.UsersDao;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��27�� ����5:40:07
* 
*/
@SuppressWarnings("serial")
public class GoodsPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); //��ȡ������ID
		GoodsBean g = GoodsDao.goodsIdSel(id);
		System.out.println("��Ʒ���ƣ�"+g.getName()+"  ��Ʒ�۸�"+g.getPrice()+"  ͼƬ·����"+g.getProPic()+"  ��Ʒ���ࣺ"+g.getBrand()+"  ��Ʒ������"+g.getSales()+"  �������"+g.getViews()+"  ��Ʒ��棺"+g.getStock()+"  ��Ʒ������"+g.getContents()+"  ����ID��"+g.getBigTypeId()+"  �������ƣ�"+g.getBigTypeName()+"  С��ID��"+g.getSmallTypeId()+"  С�����ƣ�"+g.getSmallTypeName());
		List<GoodsBean> xgGoods = GoodsDao.bigTypeIdSelxg(g.getBigTypeId()); //��ȡ�����Ʒ
		
		request.setAttribute("GoodsBean", g);
		request.setAttribute("xgGoods", xgGoods);
		GoodsDao.addViews(id); //�������1
		
		//��ȡ���ﳵ
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>(); //���ﳵ����
		if(username==null){
			//�û�û�е�¼
			//��ȡ���ﳵ
			HashMap<String, GoodsBean> shoppingCart = (HashMap)request.getSession().getAttribute("shoppingCart");
			Set keyList = shoppingCart.keySet();
			Iterator it = keyList.iterator();
			
			while(it.hasNext()){
				String hid = (String)it.next();
				GoodsBean hgoods = shoppingCart.get(hid);
				int num = hgoods.getNum(); //��ȡ�����Ʒ������
				GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(Integer.parseInt(hid)); //�����ݿ����
				hgoods2.setNum(num);
				goodsList.add(hgoods2);
			}
			
		}else{
			//�û��Ѿ���¼
			int userId = UsersDao.nameIsId(username);
			//��ȡ���ﳵ�����й�����Ŀ
			List<ShoppingCart> list = ShoppingCartDao.selList(userId);
			for(ShoppingCart s: list){
				GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(s.getGoodsId()); //�����ݿ����
				hgoods2.setNum(s.getNum());
				goodsList.add(hgoods2);
			}
		}
		request.setAttribute("shoppingCartGoodsList", goodsList);
		
		request.getRequestDispatcher("goods.jsp").forward(request, response);
	}

}
