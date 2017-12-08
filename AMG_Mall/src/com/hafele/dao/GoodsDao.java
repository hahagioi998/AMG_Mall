package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hafele.bean.GoodsBean;
import com.hafele.util.Conn;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��14�� ����5:04:55
* ��Ʒ���ݿ������
*/
public class GoodsDao {

	/**
	 * ����ID������Ʒ����
	 * @param id
	 * @return
	 */
	public static GoodsBean goodsIdSel(int id) {
		String sql = "select *,t_bigType.name bigTypeName,t_smallType.name smallTypeName from t_goods,t_bigType,t_smallType where t_smallType.id = t_goods.smallTypeId and t_bigType.id = t_goods.bigTypeId and t_goods.id=?";
		Connection con = Conn.getCon();
		ResultSet rs = null;
		GoodsBean goods = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");  //��Ʒ����
				double price = rs.getDouble("price");  //��Ʒ�۸�
				String proPic = rs.getString("proPic");  //��ƷͼƬ
				String brand = rs.getString("brand");  //��ƷƷ��
				int sales = rs.getInt("sales");  //��Ʒ����
				int views = rs.getInt("views");  //��Ʒ�����
				int stock =  rs.getInt("stock");  //��Ʒ���
				String contents = rs.getString("contents");  //��Ʒ����
				int bigTypeId = rs.getInt("bigTypeId");  //����ID
				String bigTypeName = rs.getString("bigTypeName");  //��������
				int smallTypeId = rs.getInt("smallTypeId");  //С��ID
				String smallTypeName = rs.getString("smallTypeName");  //С������
				
				goods = new GoodsBean(name, price, proPic, brand, sales, views, stock, contents, bigTypeId, smallTypeId, null);
				goods.setBigTypeName(bigTypeName);
				goods.setSmallTypeName(smallTypeName);	
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
		return goods;
	}

	/**
	 * �����Ʒ
	 * ���ݴ���id��ѯ ����ǰ6����Ʒ  ������
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List bigTypeIdSelxg(int bigTypeId){
		String sql = "select top 6 id,name,price,proPic from t_goods where bigTypeId="+bigTypeId+"  order by sales desc";
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("�����Ʒ: id="+id+"    name="+name+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, name, price, proPic);
				list.add(g);
				System.out.println("��Ʒҳ�����Ʒ6����ѯ���");
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
	 * �������1
	 * @param id
	 */
	public static void addViews(int id){
		String sql = "update t_goods set views=views+1 where id = ?";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ����ID������Ʒ����
	 * @param id
	 * @return
	 */
	public static GoodsBean shoppingCartGoodsIdSel(int id) {
		//����  ����  ID ͼƬ
				String sql = "select name,price,proPic from t_goods where id=?";
				Connection con = Conn.getCon();
				ResultSet rs = null;
				GoodsBean goods = null;
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					rs = ps.executeQuery();
					while(rs.next()){
						String name = rs.getString("name");  //��Ʒ����
						double price = rs.getDouble("price");  //��Ʒ�۸�
						String proPic = rs.getString("proPic");  //��ƷͼƬ
						goods = new GoodsBean();
						goods.setId(id);
						goods.setName(name);
						goods.setPrice(price);
						goods.setProPic(proPic);
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
				return goods;
	}

	/**
	 * ���ݴ���id��ѯ ����ǰ������Ʒ  �����·���
	 * @param sql
	 * @return
	 */
	public static List<GoodsBean> bigTypeIdSel(int bigTypeId) {
		String sql = "select top 6 id,name,price,proPic from t_goods where bigTypeId="+bigTypeId+"  order by id desc";
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("id="+id+"    name="+name+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, name, price, proPic);
				list.add(g);
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
	 * ��������������ǰʮ����Ʒ
	 * @return
	 */
	public static List<GoodsBean> salesTop() {
		String sql = "select top 10 id,name,price,proPic from t_goods  order by sales desc";
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("�����Ʒ: id="+id+"    name="+name+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, name, price, proPic);
				list.add(g);
				System.out.println("����ҳǰ10��Ʒ��ѯ���");
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
	 * ����������Ʒǰ�˵���Ʒ
	 * @return
	 */
	public static List<GoodsBean> specialSale() {
		String sql = "select top 6 id,name,price,proPic from t_goods where state='����'  order by sales desc";
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<GoodsBean> list = new ArrayList<GoodsBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("�����Ʒ: id="+id+"    name="+name+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, name, price, proPic);
				list.add(g);
				System.out.println("����ҳǰ8��Ʒ��ѯ���");
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

}
