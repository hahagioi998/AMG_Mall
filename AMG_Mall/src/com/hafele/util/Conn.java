package com.hafele.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月15日 上午9:39:19
* 连接数据库
*/
public class Conn {
	@Test
	public static Connection getCon(){
		Connection con= null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=zhaiShop","sa","hafele");
			System.out.println(con);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String[] args) {
		getCon();
	}
}
