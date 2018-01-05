package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hafele.bean.UserBean;
import com.hafele.util.Conn;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月14日 下午5:10:45
* 用户数据库操作类
*/
public class UsersDao {

	/**
	 * 查询总行数
	 * @return i
	 */
	@SuppressWarnings("unused")
	public static int count(String sql) {
		Connection con = Conn.getCon();
		int i = 0;
		ResultSet rs = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			if(rs!=null){
				i = rs.getInt("count");
			}else{
				i = 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		System.out.println("查询到的用户行数为："+i);
		return i;
	}

	/**
	 * 添加买家用户
	 * @param u
	 * @return i
	 */
	public static int adduser(UserBean u){
		String sql = "insert into t_user (userName,password,phone,email)values(?,?,?,?)";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getPhone());
			ps.setString(4, u.getEmail());
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}

	/**
	 * 用户登录
	 * @param username
	 * @return password
	 * */
	public static String login(String username) {
		String sql = "select * from t_user where userName=?";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		String password = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			password = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return password;
	}

	/**
	 * 获取用户ID
	 * @param username
	 * @return id
	 * */
	public static int nameIsId(String username) {
		String sql = "select id from t_user where userName=?";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		int id = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			id = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return id;
	}

	public static String adminLogin(String userName) {
		String sql = "select * from t_user where userName=? and userType=0";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		String password = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
			password = rs.getString("password");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return password;
	}
}
