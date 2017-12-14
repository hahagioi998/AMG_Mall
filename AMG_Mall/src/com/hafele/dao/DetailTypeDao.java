package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hafele.bean.DetailTypeBean;
import com.hafele.util.Conn;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年12月8日 上午10:41:09
* 商品细节类数据库操作
*/
public class DetailTypeDao {
	
	/**
	 * 查询总行数
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List bigTypeIdIsSel(int smallTypeId){
		Connection con = Conn.getCon();
		String sql = "select * from t_detailType where smallTypeId = ?";
		ResultSet rs = null;
		List<DetailTypeBean> list = new ArrayList<DetailTypeBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, smallTypeId);
			rs = ps.executeQuery();
			while(rs.next()){
				 int id = rs.getInt("id");
				 String name = rs.getString("name");
				 String remarks = rs.getString("remarks");
				 DetailTypeBean d = new DetailTypeBean(name, smallTypeId, remarks);
				 d.setId(id);
				 list.add(d);
				 System.out.println("id="+id+",name="+name+",remarks="+remarks+",bigTypeId="+smallTypeId);
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
	 * 根据细类ID查询细类名称
	 * @return
	 */
	public static String didIsName(String did) {
		String sql = "select name from t_detailType where id = "+did;
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

}
