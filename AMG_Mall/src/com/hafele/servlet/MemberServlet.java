package com.hafele.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
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
* @version 创建时间：2017年12月25日 下午2:55:24
* 管理中心Servlet
*/
@SuppressWarnings("serial")
public class MemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("收到请求");
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String MethodName = request.getServletPath();
		MethodName = MethodName.substring(1, MethodName.length() - 7);
		System.out.println("管理中心Servlet——MethodName："+MethodName);
		try {
			Method method = getClass().getDeclaredMethod(MethodName,
					HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}
	
	/**
	 * 我的订单
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void order(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_order.jsp").forward(request, response); //转发到我的订单
		
	}
	
	/**
	 * 收货地址
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void address(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_address.jsp").forward(request, response); //转发到收货地址
		
	}
	
	/**
	 * 我的收藏
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void collect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_collect.jsp").forward(request, response); //转发到我的收藏
		
	}
	
	/**
	 * 我的佣金
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void commission(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_commission.jsp").forward(request, response); //转发到我得佣金
		
	}
	
	/**
	 * 推广链接
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void links(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_links.jsp").forward(request, response); //转发到推广链接
		
	}
	
	/**
	 * 我的会员
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void member(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_member.jsp").forward(request, response); //转发到我的会员
		
	}
	
	/**
	 * 会员列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void member_list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_member_list.jsp").forward(request, response); //转发到会员列表
		
	}
	
	/**
	 * 资金管理
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void money(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_money.jsp").forward(request, response); //转发到资金管理
		
	}
	
	/**
	 * 确认支付
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void money_pay(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_money_pay.jsp").forward(request, response); //转发到确认支付
		
	}
	
	/**
	 * 在线充值
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void money_charge(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_money_charge.jsp").forward(request, response); //转发到在线充值
		
	}
	
	/**
	 * 我的留言
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void msg(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_msg.jsp").forward(request, response); //转发到我的留言
		
	}
	
	/**
	 * 我的红包
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void packet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_packet.jsp").forward(request, response); //转发到我的红包
		
	}
	
	/**
	 * 我的业绩
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void results(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_results.jsp").forward(request, response); //转发到我的业绩
		
	}
	
	/**
	 * 账户安全
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void safe(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_safe.jsp").forward(request, response); //转发到账户安全
		
	}
	
	/**
	 * 用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username"); //获取登录的用户名
		List<GoodsBean> goodsList = getShoppingCart(username,request);
		
		request.setAttribute("shoppingCartGoodsList", goodsList);// 购物车信息
		request.getRequestDispatcher("member_user.jsp").forward(request, response); //转发到用户信息
		
	}
	
	/**
	 * 获取购物车商品信息
	 * @param username
	 * @param request
	 * @return goodsList
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<GoodsBean> getShoppingCart(String username, HttpServletRequest request) {
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
		return goodsList;
	}
}
