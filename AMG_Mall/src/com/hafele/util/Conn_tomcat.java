package com.hafele.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月15日 上午9:45:05
* 服务器连接池
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

