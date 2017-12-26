package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
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
* @version ����ʱ�䣺2017��12��25�� ����2:55:24
* ��������Servlet
*/
@SuppressWarnings("serial")
public class MemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�յ�����");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String MethodName = request.getServletPath();
		MethodName = MethodName.substring(1, MethodName.length() - 7);
		System.out.println("��������Servlet����MethodName��"+MethodName);
		try {
			Method method = getClass().getDeclaredMethod(MethodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	/**
	 * �ҵĶ���
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_order.jsp").forward(request, response); //ת�����ҵĶ���
		
	}
	
	/**
	 * �ջ���ַ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void address(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_address.jsp").forward(request, response); //ת�����ջ���ַ
		
	}
	
	/**
	 * �ҵ��ղ�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void collect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_collect.jsp").forward(request, response); //ת�����ҵ��ղ�
		
	}
	
	/**
	 * �ҵ�Ӷ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void commission(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_commission.jsp").forward(request, response); //ת�����ҵ�Ӷ��
		
	}
	
	/**
	 * �ƹ�����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void links(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_links.jsp").forward(request, response); //ת�����ƹ�����
		
	}
	
	/**
	 * �ҵĻ�Ա
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void member(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_member.jsp").forward(request, response); //ת�����ҵĻ�Ա
		
	}
	
	/**
	 * ��Ա�б�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void member_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_member_list.jsp").forward(request, response); //ת������Ա�б�
		
	}
	
	/**
	 * �ʽ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void money(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_money.jsp").forward(request, response); //ת�����ʽ����
		
	}
	
	/**
	 * ȷ��֧��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void money_pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_money_pay.jsp").forward(request, response); //ת����ȷ��֧��
		
	}
	
	/**
	 * ���߳�ֵ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void money_charge(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_money_charge.jsp").forward(request, response); //ת�������߳�ֵ
		
	}
	
	/**
	 * �ҵ�����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void msg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_msg.jsp").forward(request, response); //ת�����ҵ�����
		
	}
	
	/**
	 * �ҵĺ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void packet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_packet.jsp").forward(request, response); //ת�����ҵĺ��
		
	}
	
	/**
	 * �ҵ�ҵ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void results(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_results.jsp").forward(request, response); //ת�����ҵ�ҵ��
		
	}
	
	/**
	 * �˻���ȫ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void safe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_safe.jsp").forward(request, response); //ת�����˻���ȫ
		
	}
	
	/**
	 * �û���Ϣ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //��ȡ��¼���û���
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// ���ﳵ��Ϣ
		request.getRequestDispatcher("member_user.jsp").forward(request, response); //ת�����û���Ϣ
		
	}
	
	/**
	 * ��ȡ���ﳵ��Ʒ��Ϣ
	 * @param username
	 * @param request
	 * @return goodsList
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<GoodsBean> getShoppingCart(String username, HttpServletRequest request) {
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
		return goodsList;
	}
}
