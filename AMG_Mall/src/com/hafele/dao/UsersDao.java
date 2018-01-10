package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hafele.bean.UserBean;
import com.hafele.util.Conn;
import com.hafele.util.JsonUtil;

import net.sf.json.JSONArray;

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

	public static JSONArray selAll(int p,int pageSize) {
		String sql = "select top "+pageSize+" * from t_user where id not in(select top "+(p-1)*pageSize+" id from t_user)";
		return sel(sql);
	}

	public static JSONArray nameSel(int p,int pageSize,String username) {
		String sql = "select top "+pageSize+" * from t_user where id not in(select top "+(p-1)*pageSize+" id from t_user where userName like '%"+username+"%') and userName like '%"+username+"%'";
		return sel(sql);
	}

	/**
	 * 查询sql 返回json集合
	 * @param sql
	 * @return
	 */
	private static JSONArray sel(String sql) {
		System.out.println("sql查询语句："+sql);
		Connection con = Conn.getCon();
		ResultSet rs = null;
		JSONArray jsonArray = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			jsonArray = JsonUtil.formatRsToJsonArray(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return jsonArray;
	}

	/**
	 * 添加管理员用户
	 * @param u
	 * @return
	 */
	public static int add(UserBean u){
		String sql = "insert into t_user values(?,?,?,?,?,?,?,?,?,?)";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getTrueName());
			ps.setString(3, u.getSex());
			ps.setString(4, u.getBirthday());
			ps.setString(5, u.getStatusID());
			ps.setString(6, u.getPhone());
			ps.setString(7, "");
			ps.setString(8, u.getEmail());
			ps.setInt(9, Integer.parseInt(u.getUserType()));
			ps.setString(10, u.getPassword());
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
	 * 后台修改数据
	 * @param u
	 * @return
	 */
	public static int update(UserBean u) {
		String sql = "update t_user "
				+"set userName=?,trueName=?,sex=?,birthday=?,statusID=?,phone=?,address=?,email=?,password=? "
				+"where id=? ";
			Connection con = Conn.getCon();
			PreparedStatement ps = null;
			int i = 0;
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, u.getUserName());
				ps.setString(2, u.getTrueName());
				ps.setString(3, u.getSex());
				ps.setString(4, u.getBirthday());
				ps.setString(5, u.getStatusID());
				ps.setString(6, u.getPhone());
				ps.setString(7, u.getAddress());
				ps.setString(8, u.getEmail());
				ps.setString(9, u.getPassword());
				ps.setInt(10, u.getId());
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
	 * 删除多个
	 * @param ids
	 * @return
	 */
	public static int manyDel(String ids) {
		String sql = "delete from t_user where id in("+ids+")";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = con.prepareStatement(sql);
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
	 * 根据ID删除
	 * @param id
	 * @return
	 */
	public static int del(int id) {
		System.out.println("接受到要删除的ID："+id);
		String sql = "delete t_user where id=?";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
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
}
