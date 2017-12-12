package com.hafele.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hafele.bean.GoodsBean;
import com.hafele.bean.ShoppingCart;
import com.hafele.dao.GoodsDao;
import com.hafele.dao.ShoppingCartDao;
import com.hafele.dao.UsersDao;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月27日 下午5:40:07
* 
*/
@SuppressWarnings("serial")
public class GoodsPageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); //获取宝贝的ID
		GoodsBean g = GoodsDao.goodsIdSel(id);
		System.out.println("商品名称："+g.getName()+"  商品价格："+g.getPrice()+"  图片路径："+g.getProPic()+"  商品分类："+g.getBrand()+"  商品销量："+g.getSales()+"  浏览量："+g.getViews()+"  商品库存："+g.getStock()+"  商品描述："+g.getContents()+"  大类ID："+g.getBigTypeId()+"  大类名称："+g.getBigTypeName()+"  小类ID："+g.getSmallTypeId()+"  小类名称："+g.getSmallTypeName());
		List<GoodsBean> xgGoods = GoodsDao.bigTypeIdSelxg(g.getBigTypeId()); //获取相关商品
		
		request.setAttribute("GoodsBean", g);
		request.setAttribute("xgGoods", xgGoods);
		GoodsDao.addViews(id); //浏览量加1
		
		//获取购物车
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = new ArrayList<GoodsBean>(); //购物车集合
		if(username==null){
			//用户没有登录
			//获取购物车
			HashMap<String, GoodsBean> shoppingCart = (HashMap)request.getSession().getAttribute("shoppingCart");
			Set keyList = shoppingCart.keySet();
			Iterator it = keyList.iterator();
			
			while(it.hasNext()){
				String hid = (String)it.next();
				GoodsBean hgoods = shoppingCart.get(hid);
				int num = hgoods.getNum(); //获取这个商品的数量
				GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(Integer.parseInt(hid)); //从数据库查找
				hgoods2.setNum(num);
				goodsList.add(hgoods2);
			}
			
		}else{
			//用户已经登录
			int userId = UsersDao.nameIsId(username);
			//获取购物车中所有购物项目
			List<ShoppingCart> list = ShoppingCartDao.selList(userId);
			for(ShoppingCart s: list){
				GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(s.getGoodsId()); //从数据库查找
				hgoods2.setNum(s.getNum());
				goodsList.add(hgoods2);
			}
		}
		request.setAttribute("shoppingCartGoodsList", goodsList);
		
		request.getRequestDispatcher("goods.jsp").forward(request, response);
	}

}
