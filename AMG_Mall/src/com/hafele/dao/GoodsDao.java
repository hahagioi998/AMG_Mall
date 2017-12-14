package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hafele.bean.GoodsBean;
import com.hafele.bean.PageBean;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * ��ҳ��ѯ  ���ݴ����ѯ
	 * @param name ��Ʒ���� 
	 * @param p ����ҳ��
	 * @return
	 */
	public static PageBean bidPageSel(String bid, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //��ѯ��������
		String sql = "select count(*) count from t_goods where bigTypeId ="+bid;
		count = count(sql); //��ȡ����
		System.out.println("��ȡ����ѯ������Ϊ��"+count);
		pb.setCount(count); //����������
		pb.setP(p); //���뵱ǰҳ��
		System.out.println("pb.getP()="+pb.getP());
		String sql2 = null;
		if(order.equals("1")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
				+"from t_goods "
				+"where bigTypeId ="+bid
				+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where bigTypeId ="+bid+" order by views desc) "
				+"order by views desc";
		}else if(order.equals("2")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where bigTypeId ="+bid
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where bigTypeId ="+bid+" order by id desc) "
					+"order by id desc";
		}else if(order.equals("3")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where bigTypeId ="+bid
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where bigTypeId ="+bid+" order by price desc) "
					+"order by price desc";
		}else if(order.equals("4")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where bigTypeId ="+bid
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where bigTypeId ="+bid+" order by sales desc) "
					+"order by sales desc";
		}
		System.out.println("��ҳ��ѯ���Ϊ��"+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //ʵ����һ����Ʒ����
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				//ͼƬ ���� �۸� ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("�����Ʒ: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new GoodsBean(id, sname, price, proPic);
				list.add(g);
			}
			pb.setData(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return pb;
	}

	/**
	 * ��ҳ��ѯ  ����С���ѯ
	 * @param name ��Ʒ���� 
	 * @param p ����ҳ��
	 * @return
	 */
	public static PageBean sidPageSel(String sid, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //��ѯ��������
		String sql = "select count(*) count from t_goods where smallTypeId ="+sid;
		count = count(sql); //��ȡ����
		System.out.println("��ȡ����ѯ������Ϊ��"+count);
		pb.setCount(count); //����������
		pb.setP(p); //���뵱ǰҳ��
		System.out.println("pb.getP()="+pb.getP());
		String sql2 = null;
		if(order.equals("1")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
				+"from t_goods "
				+"where smallTypeId ="+sid
				+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where smallTypeId ="+sid+" order by views desc) "
				+"order by views desc";
		}else if(order.equals("2")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where smallTypeId ="+sid
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where smallTypeId ="+sid+" order by id desc) "
					+"order by id desc";
		}else if(order.equals("3")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where smallTypeId ="+sid
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where smallTypeId ="+sid+" order by price desc) "
					+"order by price desc";
		}else if(order.equals("4")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where smallTypeId ="+sid
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where smallTypeId ="+sid+" order by sales desc) "
					+"order by sales desc";
		}
		System.out.println("��ҳ��ѯ���Ϊ��"+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //ʵ����һ����Ʒ����
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()){
				//ͼƬ ���� �۸� ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("�����Ʒ: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, sname, price, proPic);
				list.add(g);
			}
			pb.setData(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return pb;
	}

	/**
	 * ��ҳ��ѯ  ����ϸ���ѯ
	 * @param name ��Ʒ���� 
	 * @param p ����ҳ��
	 * @return
	 */
	public static PageBean didPageSel(String did, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //��ѯ��������
		String sql = "select count(*) count from t_goods where detailTypeId ="+did;
		count = count(sql); //��ȡ����
		System.out.println("��ȡ����ѯ������Ϊ��"+count);
		pb.setCount(count); //����������
		pb.setP(p); //���뵱ǰҳ��
		System.out.println("pb.getP()="+pb.getP());
		String sql2 = null;
		if(order.equals("1")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
				+"from t_goods "
				+"where detailTypeId ="+did
				+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where detailTypeId ="+did+" order by views desc) "
				+"order by views desc";
		}else if(order.equals("2")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where detailTypeId ="+did
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where detailTypeId ="+did+" order by id desc) "
					+"order by id desc";
		}else if(order.equals("3")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where detailTypeId ="+did
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where detailTypeId ="+did+" order by price desc) "
					+"order by price desc";
		}else if(order.equals("4")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where detailTypeId ="+did
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where detailTypeId ="+did+" order by sales desc) "
					+"order by sales desc";
		}
		System.out.println("��ҳ��ѯ���Ϊ��"+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //ʵ����һ����Ʒ����
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()){
				//ͼƬ ���� �۸� ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("�����Ʒ: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, sname, price, proPic);
				list.add(g);
			}
			pb.setData(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return pb;
	}

	/**
	 * ��ҳ��ѯ  ������Ʒ���Ʋ�ѯ
	 * @param name ��Ʒ���� 
	 * @param p ����ҳ��
	 * @return
	 */
	public static PageBean pageSel(String name, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //��ѯ��������
		String sql = "select count(*) count from t_goods where name like '%"+name+"%'";
		count = count(sql); //��ȡ����
		System.out.println("��ȡ����ѯ������Ϊ��"+count);
		pb.setCount(count); //����������
		pb.setP(p); //���뵱ǰҳ��
		System.out.println("pb.getP()="+pb.getP());
		String sql2 = null;
		if(order.equals("1")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
				+"from t_goods "
				+"where name like '%"+name+"%' "
				+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where name like '%"+name+"%' order by views desc) "
				+"order by views desc";
		}else if(order.equals("2")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where name like '%"+name+"%' "
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where name like '%"+name+"%' order by id desc) "
					+"order by id desc";
		}else if(order.equals("3")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where name like '%"+name+"%' "
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where name like '%"+name+"%' order by price desc) "
					+"order by price desc";
		}else if(order.equals("4")){
			sql2 = "select top "+pb.getPagesize()+" id,name,price,proPic "
					+"from t_goods "
					+"where name like '%"+name+"%' "
					+" and name not in(select top "+(pb.getP()-1)*pb.getPagesize()+" name from t_goods where name like '%"+name+"%' order by sales desc) "
					+"order by sales desc";
		}
		System.out.println("��ҳ��ѯ���Ϊ��"+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //ʵ����һ����Ʒ����
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()){
				//ͼƬ ���� �۸� ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("�����Ʒ: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, sname, price, proPic);
				list.add(g);
			}
			pb.setData(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return pb;
	}
	
	/**
	 * ��ѯ������
	 * @return
	 */
	@SuppressWarnings("unused")
	public static int count(String sql){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		System.out.println("��ѯ�����û�����Ϊ��"+i);
		return i;
	}

}
