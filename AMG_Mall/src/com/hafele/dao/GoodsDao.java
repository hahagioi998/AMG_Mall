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
* @version 创建时间：2017年11月14日 下午5:04:55
* 商品数据库操作类
*/
public class GoodsDao {

	/**
	 * 根据ID返回商品详情
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
				String name = rs.getString("name");  //商品名称
				double price = rs.getDouble("price");  //商品价格
				String proPic = rs.getString("proPic");  //商品图片
				String brand = rs.getString("brand");  //商品品牌
				int sales = rs.getInt("sales");  //商品销量
				int views = rs.getInt("views");  //商品浏览量
				int stock =  rs.getInt("stock");  //商品库存
				String contents = rs.getString("contents");  //商品描述
				int bigTypeId = rs.getInt("bigTypeId");  //大类ID
				String bigTypeName = rs.getString("bigTypeName");  //大类名称
				int smallTypeId = rs.getInt("smallTypeId");  //小类ID
				String smallTypeName = rs.getString("smallTypeName");  //小类名称
				
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
	 * 相关商品
	 * 根据大类id查询 返回前6个商品  按销量
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
				System.out.println("相关商品: id="+id+"    name="+name+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, name, price, proPic);
				list.add(g);
				System.out.println("商品页相关商品6个查询完毕");
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
	 * 浏览量加1
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
	 * 根据ID返回商品详情
	 * @param id
	 * @return
	 */
	public static GoodsBean shoppingCartGoodsIdSel(int id) {
		//名称  单价  ID 图片
		String sql = "select name,price,proPic from t_goods where id=?";
		Connection con = Conn.getCon();
		ResultSet rs = null;
		GoodsBean goods = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");  //商品名称
				double price = rs.getDouble("price");  //商品价格
				String proPic = rs.getString("proPic");  //商品图片
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
	 * 根据大类id查询 返回前六个商品  按最新发布
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
	 * 查找销售量排名前十的商品
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
				System.out.println("相关商品: id="+id+"    name="+name+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, name, price, proPic);
				list.add(g);
				System.out.println("搜索页前10商品查询完毕");
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
	 * 查找特卖商品前八的商品
	 * @return
	 */
	public static List<GoodsBean> specialSale() {
		String sql = "select top 6 id,name,price,proPic from t_goods where state='特卖'  order by sales desc";
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
				System.out.println("相关商品: id="+id+"    name="+name+"    price="+price+"    proPic="+proPic);
				GoodsBean g = new  GoodsBean(id, name, price, proPic);
				list.add(g);
				System.out.println("搜索页前8商品查询完毕");
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
	 * 分页查询  根据大类查询
	 * @param name 商品名称 
	 * @param p 需求页码
	 * @return
	 */
	public static PageBean bidPageSel(String bid, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //查询的总条数
		String sql = "select count(*) count from t_goods where bigTypeId ="+bid;
		count = count(sql); //获取条数
		System.out.println("获取到查询的条数为："+count);
		pb.setCount(count); //放入总条数
		pb.setP(p); //放入当前页码
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
		System.out.println("分页查询语句为："+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //实例化一个商品集合
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()) {
				//图片 名称 价格 ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("相关商品: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
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
	 * 分页查询  根据小类查询
	 * @param name 商品名称 
	 * @param p 需求页码
	 * @return
	 */
	public static PageBean sidPageSel(String sid, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //查询的总条数
		String sql = "select count(*) count from t_goods where smallTypeId ="+sid;
		count = count(sql); //获取条数
		System.out.println("获取到查询的条数为："+count);
		pb.setCount(count); //放入总条数
		pb.setP(p); //放入当前页码
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
		System.out.println("分页查询语句为："+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //实例化一个商品集合
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()){
				//图片 名称 价格 ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("相关商品: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
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
	 * 分页查询  根据细类查询
	 * @param name 商品名称 
	 * @param p 需求页码
	 * @return
	 */
	public static PageBean didPageSel(String did, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //查询的总条数
		String sql = "select count(*) count from t_goods where detailTypeId ="+did;
		count = count(sql); //获取条数
		System.out.println("获取到查询的条数为："+count);
		pb.setCount(count); //放入总条数
		pb.setP(p); //放入当前页码
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
		System.out.println("分页查询语句为："+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //实例化一个商品集合
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()){
				//图片 名称 价格 ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("相关商品: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
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
	 * 分页查询  根据商品名称查询
	 * @param name 商品名称 
	 * @param p 需求页码
	 * @return
	 */
	public static PageBean pageSel(String name, int p, String order) {
		Connection conn = Conn.getCon();
		PreparedStatement ps = null;
		ResultSet rs = null;
		PageBean pb = new PageBean();
		int count = 0; //查询的总条数
		String sql = "select count(*) count from t_goods where name like '%"+name+"%'";
		count = count(sql); //获取条数
		System.out.println("获取到查询的条数为："+count);
		pb.setCount(count); //放入总条数
		pb.setP(p); //放入当前页码
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
		System.out.println("分页查询语句为："+sql2);
		List<GoodsBean> list = new ArrayList<GoodsBean>(); //实例化一个商品集合
		try {
			ps = conn.prepareStatement(sql2);
			rs = ps.executeQuery();
			while(rs.next()){
				//图片 名称 价格 ID
				int id = rs.getInt("id");
				String sname = rs.getString("name");
				double price = rs.getDouble("price");
				String proPic = rs.getString("proPic");
				System.out.println("相关商品: id="+id+"    sname="+sname+"    price="+price+"    proPic="+proPic);
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
	 * 查询总行数
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
		System.out.println("查询到的用户行数为："+i);
		return i;
	}

}
