package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hafele.bean.ShoppingCart;
import com.hafele.util.Conn;


/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��27�� ����2:58:35
* ���ﳵ���ݿ����
*/
public class ShoppingCartDao {

	/**
	 * ��ѯ��ǰ����  �Ƿ���ڹ�����Ŀ
	 * @return
	 */
	public static int count(int userId, int goodsId) {
		String sql = "select num from t_shoppingCart where userId=? and goodsId=?";
		Connection con = Conn.getCon();
		int i = 0;
		ResultSet rs = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setInt(2, goodsId);
			rs = ps.executeQuery();
			
			if(rs.next()){
				i = rs.getInt("num");
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
		System.out.println("��ѯ�����û�����Ϊ��"+i);
		return i;
	}

	/**
	 * �޸Ĺ���������
	 * @param shoppingCart
	 * @return 
	 * @return
	 */
	public static int updateNum(ShoppingCart shoppingCart) {
		String sql = "update t_shoppingCart set num=num+? where userId=? and goodsId=?";
		
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, shoppingCart.getNum());
			ps.setInt(2, shoppingCart.getUserId());
			ps.setInt(3, shoppingCart.getGoodsId());
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
	 * ��ӹ�����
	 * @param shoppingCart
	 * @return 
	 * @return
	 */
	public static int add(ShoppingCart shoppingCart) {
		String sql = "insert into t_shoppingCart values(?,?,?,?)";
		Connection con = Conn.getCon();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, shoppingCart.getUserId());
			ps.setInt(2, shoppingCart.getGoodsId());
			ps.setInt(3, shoppingCart.getNum());
			ps.setDouble(4, shoppingCart.getGoodsPrice());
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
	 * �����û�ID��ѯȫ�����ﳵ��Ŀ
	 * 
	 */
	public static List<ShoppingCart> selList(int userId){
		String sql = "select * from t_shoppingCart where userId=?";
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<ShoppingCart> list = new ArrayList<ShoppingCart>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			while(rs.next()){
				ShoppingCart s = new ShoppingCart(userId, rs.getInt("goodsId"), rs.getInt("num"), rs.getDouble("goodsPrice"));
				System.out.println(s);
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

}
