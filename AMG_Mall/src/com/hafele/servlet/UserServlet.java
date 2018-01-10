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
* @version 创建时间：2017年11月16日 上午9:49:41
* 用户Servlet
*/
@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("收到请求");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String MethodName = request.getServletPath();
		MethodName = MethodName.substring(1, MethodName.length() - 5);
		System.out.println("MethodName："+MethodName);
		try {
			Method method = getClass().getDeclaredMethod(MethodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	/**
	 * 注册用户
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
			//注册成功
			request.setAttribute("registState", 1);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//注册失败
			request.setAttribute("registState", 2);
			request.getRequestDispatcher("regist.jsp").forward(request, response);
		}
		
	}
	
	/**
	 * ajax 用户名校验
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void regist(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("接收到要注册的用户名为："+name);
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
	 * ajax 验证码校验
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void SecurityCode(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String SecurityCode = request.getParameter("SecurityCode"); //接收到的验证码
		System.out.println("接收到的验证码为："+SecurityCode);
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
	 * 管理员登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void adminLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String SecurityCode = request.getParameter("SecurityCode"); //接收到的验证码
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		String securityCode = com.hafele.util.SecurityCode.getImg(request, response);
		if(SecurityCode.equalsIgnoreCase(securityCode)){
			System.out.println("验证码验证通过");
			//验证码正确
			String password2 = UsersDao.adminLogin(name);
			System.out.println("接收到的名字："+name);
			System.out.println("接收的密码为："+password);
			System.out.println("返回的密码为："+password2);
			if(password.equals(password2)){
				//密码正确
				request.getSession().setAttribute("stateOK", 0);
				response.sendRedirect("admin/main.jsp");
				request.getSession().setAttribute("adminName", name);
			}else{
				//密码错误 或者非管理员
				request.getSession().setAttribute("state", 2);
				response.sendRedirect("/AMG_Mall/admin");
			}
		}else{
			//验证码错误
			request.getSession().setAttribute("state", 1);
			response.sendRedirect("/AMG_Mall/admin");
		}
		
		
	}
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void mainLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("进入登录...");
		String username = request.getParameter("username");//接收到的用户名
		String password = request.getParameter("password");//接受到的密码
		String password2 = UsersDao.login(username);
		if(password2.equals(password)) {
			//登陆成功
			request.getSession().setAttribute("username", username);
			HashMap<String, GoodsBean> shoppingCart = (HashMap<String, GoodsBean>) request.getSession().getAttribute("shoppingCart");
			int userId = UsersDao.nameIsId(username);//获取用户ID
			//判断未登录之前购物车是否有购物项
			int shoppingCartSize = shoppingCart.size();
			if(shoppingCartSize > 0) {
				Set keyList = shoppingCart.keySet();
				Iterator it = keyList.iterator();
				while(it.hasNext()) {
					String hid = (String)it.next();
					GoodsBean hgoods = shoppingCart.get(hid);
					int i = ShoppingCartDao.count(userId, hgoods.getId());
					if(i>0){
						//存在购物项  增加数量
						ShoppingCartDao.updateNum(new ShoppingCart(userId, hgoods.getId(), hgoods.getNum(), 0));
					}else{
						//不存在  添加购物项
						ShoppingCartDao.add(new ShoppingCart(userId, hgoods.getId(), hgoods.getNum(), hgoods.getPrice()));
					}
				}
				shoppingCart.clear(); //清空当前session的购物车
			}
			response.sendRedirect("/AMG_Mall"); //重定向到首页
		}else {
			//登录失败密码输入有误
			request.getSession().setAttribute("loginFail", username);
			response.sendRedirect("login.jsp"); //重定向到登录
		}
	}
	
	/**
	 * 查询所有 and 模糊搜索
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void sel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p = request.getParameter("page"); //需求页码
		String rows = request.getParameter("rows"); //每页多少条
		String sel = request.getParameter("s_userName"); //如果是查询这不为空
		System.out.println("收到请求："+p+"  "+rows+"  "+sel);
		if(sel==null){
			JSONObject result = new JSONObject();
			String sql = "select count(*) count from t_user";
			int count = UsersDao.count(sql); //获取条数
			
			JSONArray jsonArray = UsersDao.selAll(Integer.parseInt(p), Integer.parseInt(rows)); //获取dao返回的json集合
			
			result.put("rows", jsonArray);
			result.put("total", count);
			ResponseUtil.write(response, result);
		}else{
			JSONObject result = new JSONObject();
			String sql = "select count(*) count from t_user where userName like '%"+sel+"%'";
			System.out.println("查询行数sql为："+sql);
			int count = UsersDao.count(sql); //获取条数
			JSONArray jsonArray = UsersDao.nameSel(Integer.parseInt(p), Integer.parseInt(rows),sel); //获取dao返回的json集合
			result.put("rows", jsonArray);
			result.put("total", count);
			ResponseUtil.write(response, result);
		}
	}
	
	/**
	 * 添加管理员用户
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
		System.out.println("添加用户接收到："+userName+trueName+sex+birthday+statusID+phone+address+email+ password);
		
		UserBean u = new UserBean(userName, trueName, sex, birthday, statusID, phone, address, email, 1+"", password);
		int i = UsersDao.add(u);
		JSONObject result=new JSONObject();
		if(i==0){
			result.put("errorMsg", "删除失败");
		}else{
			result.put("success", "true");
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * 修改管理员用户
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
			result.put("errorMsg", "删除失败");
		}else{
			result.put("success", "true");
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * 单个删除 and 多个删除
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
			//是个数组
			i = UsersDao.manyDel(id);
			/*String [] ids = id.split(",");
			for(String j : ids){
				usersDao.del(Integer.parseInt(j));
			}
			i = 1;*/
		}else{
			i = UsersDao.del(Integer.parseInt(id));
		}
		System.out.println("接收到的为："+id);
		JSONObject result=new JSONObject();
		if(i==0){
			result.put("errorMsg", "删除失败");
		}else{
			result.put("success", "true");
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * 退出登录
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
