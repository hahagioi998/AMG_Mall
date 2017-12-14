package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hafele.bean.BigTypeBean;
import com.hafele.bean.GoodsBean;
import com.hafele.bean.SmallTypeBean;
import com.hafele.util.Conn;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��30�� ����2:57:22
* ��Ʒ�������ݿ����
*/
public class BigTypeDao {

	/**
	 * ��ѯ���д���  ��С�� ������ǰ����Ʒ
	 * @return bigTypeʵ�弯��
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List selList(){
		String sql = "select * from t_bigType";
		System.out.println("sql��ѯ��䣺"+sql);
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<BigTypeBean> list = new ArrayList<BigTypeBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String style = rs.getString("style");
				String proPic = rs.getString("proPic");
				System.out.println("id="+id+",name="+name+"style="+style+"proPic="+proPic);
				ArrayList<SmallTypeBean> smallTypeList = (ArrayList<SmallTypeBean>) SmallTypeDao.bigTypeIdIsSel(id);
				ArrayList<GoodsBean> goodsList = (ArrayList<GoodsBean>) GoodsDao.bigTypeIdSel(id);
				
				BigTypeBean bigType = new BigTypeBean();
				bigType.setId(id);
				bigType.setName(name);
				bigType.setRemarks(style);
				bigType.setImgUrl(proPic);
				bigType.setSmallTypeList(smallTypeList);  //����С�༯��
				bigType.setGoods(goodsList);  //����ǰ����Ʒ
				
				list.add(bigType);
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
	 * ��ѯ���д���  ��С��  ����ҳ�����
	 * @return bigTypeʵ�弯��
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List bigselList(){
		String sql = "select * from t_bigType";
		System.out.println("sql��ѯ��䣺"+sql);
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<BigTypeBean> list = new ArrayList<BigTypeBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println("id="+id+",name="+name);
				ArrayList<SmallTypeBean> smallTypeList = (ArrayList<SmallTypeBean>) SmallTypeDao.bigTypeIdselList(id);
				
				BigTypeBean bigType = new BigTypeBean();
				bigType.setId(id);
				bigType.setName(name);
				bigType.setSmallTypeList(smallTypeList);  //����С�༯��
				list.add(bigType);
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
	 * ���ݴ���ID��ѯ��������
	 * @return
	 */
	public static String bidIsName(String bid) {
		String sql = "select name from t_bigType where id = "+bid;
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
