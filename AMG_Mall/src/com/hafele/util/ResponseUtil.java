package com.hafele.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��14�� ����2:09:39
* ��Ӧ
*/
public class ResponseUtil {
	public static void write(HttpServletResponse response,Object o){
		response.setContentType("text/html;charset=UTF-8");
		try {
			PrintWriter out = response.getWriter();
			out.print(o.toString());
			System.out.println("servlet��ӦΪ��"+o.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
