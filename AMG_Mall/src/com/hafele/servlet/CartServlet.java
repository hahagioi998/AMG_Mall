package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
* @version ����ʱ�䣺2017��11��28�� ����10:55:08
* 
*/
@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String MethodName = request.getServletPath();
		MethodName = MethodName.substring(1, MethodName.length() - 5);
		System.out.println("MethodName��"+MethodName);
		try {
			Method method = getClass().getDeclaredMethod(MethodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		request.getRequestDispatcher("cart.jsp").forward(request, response);  //ת����jsp
		
	}
	
//	@SuppressWarnings("unchecked")
//	public void tijiao(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HashMap<String, GoodsBean> shoppingCart = (HashMap)request.getSession().getAttribute("shoppingCart");
//		//��ȡ�û���
//		String username = (String)request.getSession().getAttribute("username");
//		String id = request.getParameter("cartItemIds");
//		int userId = UsersDao.nameIsId(username);
//		String [] ids = id.split(",");
//		//��ȡ���ﳵ
//		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
//		 DecimalFormat df = new DecimalFormat("#.00");  //��ֹ�۸�����쳣
//		 double ze = 0; //�ܶ�
//		for(String j : ids){
//			//���� gwc�����жϹ��ﳵ�еĹ���������session�� ���������ݿ���
//			int num = 0;
//			if(shoppingCart.size()==0){
//				//�������������ݿ���
//				ShoppingCart s = ShoppingCartDao.goodsIdSel(userId, Integer.parseInt(j));
//				num = s.getNum();
//			}else{
//				//����������session��
//				GoodsBean hgoods = shoppingCart.get(j);
//				num = hgoods.getNum(); //��ȡ�����Ʒ������
//			}
//			
//			GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(Integer.parseInt(j)); //�����ݿ����
//			hgoods2.setNum(num);
//			double hj = num*hgoods2.getPrice();
//			ze +=hj;
//			hgoods2.setTotal(Double.parseDouble(df.format(hj)));
//			System.out.println("����֮ǰ�ܶ"+hj+"����֮��"+df.format(hj));
//			goodsList.add(hgoods2);
//			if(shoppingCart.size()==0){
//				ShoppingCartDao.del(userId, Integer.parseInt(j));
//			}else{
//				shoppingCart.remove(j);//ɾ����Ʒ  ���ﳵ
//			}
//			
//		}
//		//��ӡ���ﳵ
//		System.out.println("��ӡ�������ﳵ");
//		for (int i = 0; i < goodsList.size(); i++) {
//			GoodsBean gb = goodsList.get(i);
//			System.out.println("ID="+gb.getId()+",name="+gb.getName()+",proce="+gb.getPrice()+",proPic="+gb.getProPic()+",num="+gb.getNum());
//		}
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//����һ������
//		String orderId = sjs(); //���ɶ�����
//		OrderBean or = new OrderBean(orderId, userId, Double.parseDouble(df.format(ze)), 1, "", sdf.format(d), 1);
//		OrderDao.add(or);
//		//���뵽��Ʒ��������
//		for(GoodsBean g : goodsList){
//			OrderItemBean o = new OrderItemBean(g.getId(), g.getName(), g.getProPic(), g.getPrice(), g.getNum(), g.getTotal(), orderId);
//			OrderItemDao.add(o);
//		}
//		
//		//�����û�ID��ȡ��ַ��Ϣ
//		List<AddressBean> addressList= AddressDao.selAll(userId); 
//		
//		request.setAttribute("addressList", addressList);
//		request.setAttribute("addressId", orderId);
//		request.setAttribute("ze", df.format(ze));
//		request.setAttribute("shoppingCartGoodsList", goodsList);
//		request.getRequestDispatcher("order.jsp").forward(request, response);  //ת����jsp
//		
//	}
//	/**
//	 * ��������
//	 * @param request
//	 * @param response
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void buy(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
//		DecimalFormat df = new DecimalFormat("#.00");  //��ֹ�۸�����쳣
//		System.out.println("��������������");
//		int goodsId = Integer.parseInt(request.getParameter("id"));
//		int num = Integer.parseInt(request.getParameter("num"));
//		String username = (String)request.getSession().getAttribute("username");
//		GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(goodsId); //�����ݿ����
//		hgoods2.setNum(num);
//		double hj = Double.parseDouble(df.format(num*hgoods2.getPrice()));
//		hgoods2.setTotal(hj); //��ʽ��������
//		goodsList.add(hgoods2);
//		
//		
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//����һ������
//		String orderId = sjs(); //���ɶ�����
//		int userId = UsersDao.nameIsId(username);
//		OrderBean or = new OrderBean(orderId, userId, hj, 1, "", sdf.format(d), 1);
//		OrderDao.add(or);
//		//���뵽��Ʒ��������
//		for(GoodsBean g : goodsList){
//			OrderItemBean o = new OrderItemBean(g.getId(), g.getName(), g.getProPic(), g.getPrice(), g.getNum(), g.getTotal(), orderId);
//			OrderItemDao.add(o);
//		}
//		
//		//�����û�ID��ȡ��ַ��Ϣ
//		List<AddressBean> addressList= AddressDao.selAll(userId); 
//		
//		request.setAttribute("addressList", addressList);
//		request.setAttribute("addressId", orderId);
//		request.setAttribute("ze", hj);
//		request.setAttribute("shoppingCartGoodsList", goodsList);
//		request.getRequestDispatcher("order.jsp").forward(request, response);  //ת����jsp
//		
//	}
	/**
	 * ���ɶ�����  ��ǰʱ�������λ�����
	 * @return
	 */
	public static String sjs() {
		String sjs = "";
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		int x=(int)(Math.random()*100);
		if(x<10){
			x=x+9;
		}else if(x==100){
			x--;
		}
		sjs=sdf.format(d)+x;
		return sjs;
	}

}