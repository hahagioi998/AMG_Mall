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
import com.hafele.bean.PageBean;
import com.hafele.bean.ShoppingCart;
import com.hafele.dao.BigTypeDao;
import com.hafele.dao.DetailTypeDao;
import com.hafele.dao.GoodsDao;
import com.hafele.dao.ShoppingCartDao;
import com.hafele.dao.SmallTypeDao;
import com.hafele.dao.UsersDao;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��12��9�� ����2:58:38
* ����Servlet
*/
@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String s = request.getParameter("name"); //��ȡ��������Ʒ����
		int p = Integer.parseInt(request.getParameter("p")); //��ȡ�����ҳ��
		String order = request.getParameter("order"); //��ȡ����ʽ
		System.out.println("��ȡĬ�ϵ�����ʽ��:"+order);
		String bid = request.getParameter("bid");
		String sid = request.getParameter("sid");
		String did = request.getParameter("did");
		List<GoodsBean> salesTop = GoodsDao.salesTop(); //ǰ������
		PageBean pageDate = null;
		if(order==null){
			order="1";
		}
		if(bid!=null){
			//���ݴ���ID��ѯ
			pageDate = GoodsDao.bidPageSel(bid, p, order);
			request.setAttribute("bigTypeName", BigTypeDao.bidIsName(bid));  //�������Ʒ��뵽������
		}else if(sid!=null){
			//����С��ID��ѯ
			pageDate = GoodsDao.sidPageSel(sid, p, order);
			request.setAttribute("smallTypeName", SmallTypeDao.sidIsName(sid));  //С�����Ʒ�������
		}else if(did!=null) {
			//����ϸ��ID��ѯ
			pageDate = GoodsDao.didPageSel(did, p, order);
			request.setAttribute("detailTypeName", DetailTypeDao.didIsName(did)); //ϸ�����Ʒ�������
		}else{
			//��Ʒ���Ʋ�ѯ
			/*
			1:���ȶ�����
			2:������ʱ��
			3:���۸�����
			4:����������
			 */
			pageDate = GoodsDao.pageSel(s, p,order); //�õ���ѯҳ������
			}
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
			for(ShoppingCart s1: list){
				GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(s1.getGoodsId()); //�����ݿ����
				hgoods2.setNum(s1.getNum());
				goodsList.add(hgoods2);
			}
		}
		request.setAttribute("shoppingCartGoodsList", goodsList);
		request.setAttribute("PageDate", pageDate);  //���뵽������
		request.setAttribute("salesTop", salesTop); //����ǰ5����
		request.setAttribute("order", order); //��������ʽ
		
		
		

		String type = "name";  //��ʶ����������   ����Ʒ���Ʋ�ѯ  ������ID��ѯ  ��С��ID��ѯ  ��ϸ��ID��ѯ
		String tname = s; //�������ƻ�����ѯ������
		if(s==null){
			if(bid!=null){
				s=bid;
				type="bid";
				tname=(String)request.getAttribute("bigTypeName");
			}else if(sid!=null){
				s=sid;	
				type="sid";
				tname=(String)request.getAttribute("smallTypeName");
			}else if(did!=null) {
				s=did;
				type="did";
				tname=(String) request.getAttribute("detailTypeName");
			}
		}
		request.setAttribute("s", s); //�����������ƻ�ID
		request.setAttribute("type", type); //������������
		request.setAttribute("tname", tname); //������������
		request.getRequestDispatcher("search.jsp").forward(request, response);  //ת����jsp

	}
}
