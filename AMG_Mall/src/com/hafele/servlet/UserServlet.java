package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafele.bean.GoodsBean;
import com.hafele.bean.ShoppingCart;
import com.hafele.bean.UserBean;
import com.hafele.dao.ShoppingCartDao;
import com.hafele.dao.UsersDao;
import com.hafele.util.ResponseUtil;

import net.sf.json.JSONObject;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��16�� ����9:49:41
* �û�Servlet
*/
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�յ�����");
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
	
	/**
	 * ע���û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void registuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		UserBean u = new UserBean();
		u.setUserName(username);
		u.setPassword(password);
		u.setEmail(email);
		u.setPhone(phone);
		int i = UsersDao.adduser(u);
		if(i==1){
			//ע��ɹ�
			request.setAttribute("registState", 1);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//ע��ʧ��
			request.setAttribute("registState", 2);
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * ajax �û���У��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("���յ�Ҫע����û���Ϊ��"+name);
		int i = UsersDao.count("select count(*) count from t_user where userName = '"+name+"'");
		JSONObject result=new JSONObject();
		if(i==0){
			result.put("success", "true");
		}else{
			result.put("success", "false");
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * ajax ��֤��У��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SecurityCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String SecurityCode = request.getParameter("SecurityCode"); //���յ�����֤��
		System.out.println("���յ�����֤��Ϊ��"+SecurityCode);
		String securityCode = com.hafele.util.SecurityCode.getImg(request, response);
		JSONObject result=new JSONObject();
		if(SecurityCode.equalsIgnoreCase(securityCode)){
			result.put("code", "true");
		}else{
			result.put("code", "false");
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * �û���¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mainLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�����¼...");
		String username = request.getParameter("username");//���յ����û���
		String password = request.getParameter("password");//���ܵ�������
		String password2 = UsersDao.login(username);
		if(password2.equals(password)) {
			//��½�ɹ�
			request.getSession().setAttribute("username", username);
			HashMap<String, GoodsBean> shoppingCart = (HashMap<String, GoodsBean>) request.getSession().getAttribute("shoppingCart");
			int userId = UsersDao.nameIsId(username);//��ȡ�û�ID
			//�ж�δ��¼֮ǰ���ﳵ�Ƿ��й�����
			int shoppingCartSize = shoppingCart.size();
			if(shoppingCartSize > 0) {
				Set keyList = shoppingCart.keySet();
				Iterator it = keyList.iterator();
				while(it.hasNext()) {
					String hid = (String)it.next();
					GoodsBean hgoods = shoppingCart.get(hid);
					int i = ShoppingCartDao.count(userId, hgoods.getId());
					if(i>0){
						//���ڹ�����  ��������
						ShoppingCartDao.updateNum(new ShoppingCart(userId, hgoods.getId(), hgoods.getNum(), 0));
					}else{
						//������  ��ӹ�����
						ShoppingCartDao.add(new ShoppingCart(userId, hgoods.getId(), hgoods.getNum(), hgoods.getPrice()));
					}
				}
				shoppingCart.clear(); //��յ�ǰsession�Ĺ��ﳵ
			}
			response.sendRedirect("/AMG_Mall"); //�ض�����ҳ
		}else {
			//��¼ʧ��������������
			request.getSession().setAttribute("loginFail", username);
			response.sendRedirect("login.jsp"); //�ض��򵽵�¼
		}
	}
	
	/**
	 * �˳���¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void logout(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("/AMG_Mall");
		
	}
}
