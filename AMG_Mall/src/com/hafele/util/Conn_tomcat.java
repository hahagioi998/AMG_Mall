package com.hafele.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��15�� ����9:45:05
* ���������ӳ�
*/
public class Conn_tomcat {
	public static Connection getCon(){
		Connection con = null;
		try {
			Context c = new InitialContext();
			DataSource ds = (DataSource) c.lookup("java:/comp/env/AMG_Mall");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}

