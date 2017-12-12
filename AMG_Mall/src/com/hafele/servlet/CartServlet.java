package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
* @version 创建时间：2017年11月28日 上午10:55:08
* 
*/
@SuppressWarnings("serial")
public class CartServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String MethodName = request.getServletPath();
		MethodName = MethodName.substring(1, MethodName.length() - 5);
		System.out.println("MethodName："+MethodName);
		try {
			Method method = getClass().getDeclaredMethod(MethodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void index(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		request.getRequestDispatcher("cart.jsp").forward(request, response);  //转发到jsp
		
	}
	
//	@SuppressWarnings("unchecked")
//	public void tijiao(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HashMap<String, GoodsBean> shoppingCart = (HashMap)request.getSession().getAttribute("shoppingCart");
//		//获取用户名
//		String username = (String)request.getSession().getAttribute("username");
//		String id = request.getParameter("cartItemIds");
//		int userId = UsersDao.nameIsId(username);
//		String [] ids = id.split(",");
//		//获取购物车
//		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
//		 DecimalFormat df = new DecimalFormat("#.00");  //防止价格出现异常
//		 double ze = 0; //总额
//		for(String j : ids){
//			//根据 gwc集合判断购物车中的购物项是在session中 还是在数据库中
//			int num = 0;
//			if(shoppingCart.size()==0){
//				//购物项存放在数据库中
//				ShoppingCart s = ShoppingCartDao.goodsIdSel(userId, Integer.parseInt(j));
//				num = s.getNum();
//			}else{
//				//购物项存放在session中
//				GoodsBean hgoods = shoppingCart.get(j);
//				num = hgoods.getNum(); //获取这个商品的数量
//			}
//			
//			GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(Integer.parseInt(j)); //从数据库查找
//			hgoods2.setNum(num);
//			double hj = num*hgoods2.getPrice();
//			ze +=hj;
//			hgoods2.setTotal(Double.parseDouble(df.format(hj)));
//			System.out.println("处理之前总额："+hj+"处理之后："+df.format(hj));
//			goodsList.add(hgoods2);
//			if(shoppingCart.size()==0){
//				ShoppingCartDao.del(userId, Integer.parseInt(j));
//			}else{
//				shoppingCart.remove(j);//删除商品  购物车
//			}
//			
//		}
//		//打印购物车
//		System.out.println("打印订单购物车");
//		for (int i = 0; i < goodsList.size(); i++) {
//			GoodsBean gb = goodsList.get(i);
//			System.out.println("ID="+gb.getId()+",name="+gb.getName()+",proce="+gb.getPrice()+",proPic="+gb.getProPic()+",num="+gb.getNum());
//		}
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//插入一条订单
//		String orderId = sjs(); //生成订单号
//		OrderBean or = new OrderBean(orderId, userId, Double.parseDouble(df.format(ze)), 1, "", sdf.format(d), 1);
//		OrderDao.add(or);
//		//插入到商品订单表中
//		for(GoodsBean g : goodsList){
//			OrderItemBean o = new OrderItemBean(g.getId(), g.getName(), g.getProPic(), g.getPrice(), g.getNum(), g.getTotal(), orderId);
//			OrderItemDao.add(o);
//		}
//		
//		//根据用户ID获取地址信息
//		List<AddressBean> addressList= AddressDao.selAll(userId); 
//		
//		request.setAttribute("addressList", addressList);
//		request.setAttribute("addressId", orderId);
//		request.setAttribute("ze", df.format(ze));
//		request.setAttribute("shoppingCartGoodsList", goodsList);
//		request.getRequestDispatcher("order.jsp").forward(request, response);  //转发到jsp
//		
//	}
//	/**
//	 * 立即购买
//	 * @param request
//	 * @param response
//	 * @throws ServletException
//	 * @throws IOException
//	 */
//	public void buy(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		List<GoodsBean> goodsList = new ArrayList<GoodsBean>();
//		DecimalFormat df = new DecimalFormat("#.00");  //防止价格出现异常
//		System.out.println("进入了立即购买");
//		int goodsId = Integer.parseInt(request.getParameter("id"));
//		int num = Integer.parseInt(request.getParameter("num"));
//		String username = (String)request.getSession().getAttribute("username");
//		GoodsBean hgoods2 = GoodsDao.shoppingCartGoodsIdSel(goodsId); //从数据库查找
//		hgoods2.setNum(num);
//		double hj = Double.parseDouble(df.format(num*hgoods2.getPrice()));
//		hgoods2.setTotal(hj); //格式化并放入
//		goodsList.add(hgoods2);
//		
//		
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		//插入一条订单
//		String orderId = sjs(); //生成订单号
//		int userId = UsersDao.nameIsId(username);
//		OrderBean or = new OrderBean(orderId, userId, hj, 1, "", sdf.format(d), 1);
//		OrderDao.add(or);
//		//插入到商品订单表中
//		for(GoodsBean g : goodsList){
//			OrderItemBean o = new OrderItemBean(g.getId(), g.getName(), g.getProPic(), g.getPrice(), g.getNum(), g.getTotal(), orderId);
//			OrderItemDao.add(o);
//		}
//		
//		//根据用户ID获取地址信息
//		List<AddressBean> addressList= AddressDao.selAll(userId); 
//		
//		request.setAttribute("addressList", addressList);
//		request.setAttribute("addressId", orderId);
//		request.setAttribute("ze", hj);
//		request.setAttribute("shoppingCartGoodsList", goodsList);
//		request.getRequestDispatcher("order.jsp").forward(request, response);  //转发到jsp
//		
//	}
	/**
	 * 生成订单号  当前时间加上两位随机数
	 * @return
	 */
	public static String sjs() {
		String sjs = "";
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		int x=(int)(Math.random()*100);
		if(x<10){
			x=x+9;
		}else if(x==100){
			x--;
		}
		sjs=sdf.format(d)+x;
		return sjs;
	}

}