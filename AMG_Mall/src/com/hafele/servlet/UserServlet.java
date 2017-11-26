package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafele.bean.UserBean;
import com.hafele.dao.UsersDao;
import com.hafele.util.ResponseUtil;

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
	public void regeuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserBean u = new UserBean();
		u.setUserName(username);u.setPassword(password);
		int i = UsersDao.adduser(u);
		if(i==1){
			//注册成功
			request.setAttribute("regeState", 1);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			//注册失败
			request.setAttribute("regeState", 2);
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
	public void rege(HttpServletRequest request, HttpServletResponse response)
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
}
