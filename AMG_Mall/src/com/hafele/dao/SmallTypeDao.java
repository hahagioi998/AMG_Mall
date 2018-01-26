package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hafele.bean.DetailTypeBean;
import com.hafele.bean.SmallTypeBean;
import com.hafele.util.Conn;
import com.hafele.util.JsonUtil;

import net.sf.json.JSONArray;


/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月30日 下午3:40:00
* 商品小类数据库操作
*/
public class SmallTypeDao {
	/**
	 * 查询总行数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List bigTypeIdIsSel(int bigTypeId){
		Connection con = Conn.getCon();
		String sql = "select * from t_smallType where bigTypeId = ?";
		ResultSet rs = null;
		List<SmallTypeBean> list = new ArrayList<SmallTypeBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bigTypeId);
			rs = ps.executeQuery();
			while(rs.next()){
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 String remarks = rs.getString("remarks");
				 ArrayList<DetailTypeBean> detailTypeList = (ArrayList<DetailTypeBean>) DetailTypeDao.bigTypeIdIsSel(id);
				 SmallTypeBean s = new SmallTypeBean(name, bigTypeId, remarks);
				 s.setId(id);
				 s.setDetailTypeList(detailTypeList);
				 list.add(s);
				 System.out.println("id="+id+",name="+name+",remarks="+remarks+",bigTypeId="+bigTypeId);
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
		return list;
	}

	/**
	 * 查询sql 返回list集合
	 * @param sql
	 * @return
	 */
	@SuppressWarnings({ "rawtypes"})
	public static List bigTypeIdselList(int bigTypeId){
		String sql = "select * from t_smallType where bigTypeId = "+bigTypeId;
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<SmallTypeBean> list = new ArrayList<SmallTypeBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				SmallTypeBean s = new SmallTypeBean();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				System.out.println("小类ID："+s.getId()+"    小类名称："+s.getName());
				list.add(s);
			}
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
		return list;
		
	}

	/**
	 * 根据小类ID查询小类名称
	 * @return
	 */
	public static String sidIsName(String sid) {
		String sql = "select name from t_smallType where id = "+sid;
		Connection con = Conn.getCon();
		ResultSet rs = null;
		String name = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			name = rs.getString("name");
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
		return name;
	}

	/**
	 * 按大类ID查询 返回json
	 * @param bigTypeId
	 * @return
	 */
	public static JSONArray bigTypeIdsel(int bigTypeId) {
		String sql = "select * from t_smallType where bigTypeId = "+bigTypeId;
		return sel(sql);
	}
	
	/**
	 * 查询sql 返回json集合
	 * @param sql
	 * @return
	 */
	public static JSONArray sel(String sql){
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
}
