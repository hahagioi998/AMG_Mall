package com.hafele.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hafele.bean.SlideBean;
import com.hafele.util.Conn;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月30日 下午2:58:03
* 类说明
*/
public class SlideDao {

	/**
	 * 查询首页幻灯
	 * @param sql
	 * @return slide 幻灯对象集合
	 */
	public static List<SlideBean> selList() {
		String sql = "select * from t_slide";
		System.out.println("sql查询语句："+sql);
		Connection con = Conn.getCon();
		ResultSet rs = null;
		List<SlideBean> list = new ArrayList<SlideBean>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String name = rs.getString("name");
				String url = rs.getString("url");
				String proPic = rs.getString("proPic");
				System.out.println("name="+name+",url="+url+",proPic="+proPic);
				SlideBean slide = new SlideBean(name, proPic, url);
				list.add(slide);
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
