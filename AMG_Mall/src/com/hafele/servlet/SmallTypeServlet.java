package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafele.dao.SmallTypeDao;
import com.hafele.util.ResponseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��12��1�� ����1:52:15
* ��ƷС��Servlet
*/
@SuppressWarnings("serial")
public class SmallTypeServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String MethodName = request.getServletPath();
		MethodName = MethodName.substring(1, MethodName.length() - 6);
		System.out.println("MethodName��"+MethodName);
		try {
			Method method = getClass().getDeclaredMethod(MethodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	public void selList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("id", "");
		jsonObject.put("name", "����ѡ�����...");
		jsonArray.add(jsonObject);
		ResponseUtil.write(response, jsonArray);
		
	}
	
	public void idSelList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bigTypeId = request.getParameter("bigTypeId");
		JSONArray jsonArray=new JSONArray();
		JSONObject jsonObject=new JSONObject();
		if(bigTypeId.equals("")){
			jsonObject.put("id", "");
			jsonObject.put("name", "����ѡ�����...");
			jsonArray.add(jsonObject);
		}else{
			jsonObject.put("id", "");
			jsonObject.put("name", "��ѡ��...");
			jsonArray.add(jsonObject);
			JSONArray jsonArray2 = SmallTypeDao.bigTypeIdsel(Integer.parseInt(bigTypeId)); //��ȡdao���ص�json����
			jsonArray.addAll(jsonArray2);
		}
		ResponseUtil.write(response, jsonArray);
		
	}
}
