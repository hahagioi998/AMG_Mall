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

import net.sf.json.JSONArray;
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
	 * ����Ա��¼
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void adminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String SecurityCode = request.getParameter("SecurityCode"); //���յ�����֤��
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String securityCode = com.hafele.util.SecurityCode.getImg(request, response);
		if(SecurityCode.equalsIgnoreCase(securityCode)){
			System.out.println("��֤����֤ͨ��");
			//��֤����ȷ
			String password2 = UsersDao.adminLogin(name);
			System.out.println("���յ������֣�"+name);
			System.out.println("���յ�����Ϊ��"+password);
			System.out.println("���ص�����Ϊ��"+password2);
			if(password.equals(password2)){
				//������ȷ
				request.getSession().setAttribute("stateOK", 0);
				response.sendRedirect("admin/main.jsp");
				request.getSession().setAttribute("adminName", name);
			}else{
				//������� ���߷ǹ���Ա
				request.getSession().setAttribute("state", 2);
				response.sendRedirect("/AMG_Mall/admin");
			}
		}else{
			//��֤�����
			request.getSession().setAttribute("state", 1);
			response.sendRedirect("/AMG_Mall/admin");
		}
		
		
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
	 * ��ѯ���� and ģ������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p = request.getParameter("page"); //����ҳ��
		String rows = request.getParameter("rows"); //ÿҳ������
		String sel = request.getParameter("s_userName"); //����ǲ�ѯ�ⲻΪ��
		System.out.println("�յ�����"+p+"  "+rows+"  "+sel);
		if(sel==null){
			JSONObject result = new JSONObject();
			String sql = "select count(*) count from t_user";
			int count = UsersDao.count(sql); //��ȡ����
			
			JSONArray jsonArray = UsersDao.selAll(Integer.parseInt(p), Integer.parseInt(rows)); //��ȡdao���ص�json����
			
			result.put("rows", jsonArray);
			result.put("total", count);
			ResponseUtil.write(response, result);
		}else{
			JSONObject result = new JSONObject();
			String sql = "select count(*) count from t_user where userName like '%"+sel+"%'";
			System.out.println("��ѯ����sqlΪ��"+sql);
			int count = UsersDao.count(sql); //��ȡ����
			JSONArray jsonArray = UsersDao.nameSel(Integer.parseInt(p), Integer.parseInt(rows),sel); //��ȡdao���ص�json����
			result.put("rows", jsonArray);
			result.put("total", count);
			ResponseUtil.write(response, result);
		}
	}
	
	/**
	 * ��ӹ���Ա�û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user.userName");
		String trueName = request.getParameter("user.trueName");
		String sex = request.getParameter("user.sex");
		String birthday = request.getParameter("user.birthday");
		String statusID = request.getParameter("user.statusID");
		String phone = request.getParameter("user.phone");
		String address = request.getParameter("user.address");
		String email = request.getParameter("user.email");
		String password = request.getParameter("user.password");
		System.out.println("����û����յ���"+userName+trueName+sex+birthday+statusID+phone+address+email+ password);
		
		UserBean u = new UserBean(userName, trueName, sex, birthday, statusID, phone, address, email, 1+"", password);
		int i = UsersDao.add(u);
		JSONObject result=new JSONObject();
		if(i==0){
			result.put("errorMsg", "ɾ��ʧ��");
		}else{
			result.put("success", "true");
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * �޸Ĺ���Ա�û�
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("user.userName");
		String trueName = request.getParameter("user.trueName");
		String sex = request.getParameter("user.sex");
		String birthday = request.getParameter("user.birthday");
		String statusID = request.getParameter("user.statusID");
		String phone = request.getParameter("user.phone");
		String address = request.getParameter("user.address");
		String email = request.getParameter("user.email");
		String password = request.getParameter("user.password");
		int id = Integer.parseInt(request.getParameter("user.id"));
		UserBean u = new UserBean(userName, trueName, sex, birthday, statusID, phone, address, email, 1+"", password);
		u.setId(id);
		int i = UsersDao.update(u);
		JSONObject result=new JSONObject();
		if(i==0){
			result.put("errorMsg", "ɾ��ʧ��");
		}else{
			result.put("success", "true");
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * ����ɾ�� and ���ɾ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("ids");
		int s = id.indexOf(",");
		int i = 0;
		if(s!=-1){
			//�Ǹ�����
			i = UsersDao.manyDel(id);
			/*String [] ids = id.split(",");
			for(String j : ids){
				usersDao.del(Integer.parseInt(j));
			}
			i = 1;*/
		}else{
			i = UsersDao.del(Integer.parseInt(id));
		}
		System.out.println("���յ���Ϊ��"+id);
		JSONObject result=new JSONObject();
		if(i==0){
			result.put("errorMsg", "ɾ��ʧ��");
		}else{
			result.put("success", "true");
		}
		ResponseUtil.write(response, result);
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
