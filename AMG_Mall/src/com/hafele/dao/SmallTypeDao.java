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


/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��30�� ����3:40:00
* ��ƷС�����ݿ����
*/
public class SmallTypeDao {
	/**
	 * ��ѯ������
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
	 * ��ѯsql ����list����
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
				System.out.println("С��ID��"+s.getId()+"    С�����ƣ�"+s.getName());
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

	public static Object sidIsName(String sid) {
		// TODO Auto-generated method stub
		return null;
	}
}
