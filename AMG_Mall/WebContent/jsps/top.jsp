<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--Begin 头部代码（最顶部、logo、搜索、导航菜单） Begin-->
<div class="soubg">
	<div class="sou">
		<!--Begin 所在收货地区 Begin-->
		<span class="s_city_b"> <span class="fl">送货至：</span> <span
			class="s_city"> <span>广东</span>
				<div class="s_city_bg">
					<div class="s_city_t"></div>
					<div class="s_city_c">
						<h2>请选择所在的收货地区</h2>
						<table border="0" class="c_tab"
							style="width: 235px; margin-top: 10px;" cellspacing="0"
							cellpadding="0">
							<tr>
								<th>A</th>
								<td class="c_h"><span>安徽</span><span>澳门</span></td>
							</tr>
							<tr>
								<th>B</th>
								<td class="c_h"><span>北京</span></td>
							</tr>
							<tr>
								<th>C</th>
								<td class="c_h"><span>重庆</span></td>
							</tr>
							<tr>
								<th>F</th>
								<td class="c_h"><span>福建</span></td>
							</tr>
							<tr>
								<th>G</th>
								<td class="c_h"><span class="c_check">广东</span><span>广西</span><span>贵州</span><span>甘肃</span></td>
							</tr>
							<tr>
								<th>H</th>
								<td class="c_h"><span>河北</span><span>河南</span><span>黑龙江</span><span>海南</span><span>湖北</span><span>湖南</span></td>
							</tr>
							<tr>
								<th>J</th>
								<td class="c_h"><span>江苏</span><span>吉林</span><span>江西</span></td>
							</tr>
							<tr>
								<th>L</th>
								<td class="c_h"><span>辽宁</span></td>
							</tr>
							<tr>
								<th>N</th>
								<td class="c_h"><span>内蒙古</span><span>宁夏</span></td>
							</tr>
							<tr>
								<th>Q</th>
								<td class="c_h"><span>青海</span></td>
							</tr>
							<tr>
								<th>S</th>
								<td class="c_h"><span>上海</span><span>山东</span><span>山西</span><span>四川</span><span>陕西</span></td>
							</tr>
							<tr>
								<th>T</th>
								<td class="c_h"><span>台湾</span><span>天津</span></td>
							</tr>
							<tr>
								<th>X</th>
								<td class="c_h"><span>西藏</span><span>香港</span><span>新疆</span></td>
							</tr>
							<tr>
								<th>Y</th>
								<td class="c_h"><span>云南</span></td>
							</tr>
							<tr>
								<th>Z</th>
								<td class="c_h"><span>浙江</span></td>
							</tr>
						</table>
					</div>
				</div>
		</span>
		</span>
		<!--End 所在收货地区 End-->
		<c:if test="${username == null }">
			<span class="fr"> <span class="fl">你好，请<a
					href="login.jsp">登录</a>&nbsp; <a href="regist.jsp"
					style="color: #ff4e00;">免费注册</a>&nbsp;|&nbsp;<a href="#">我的订单</a>&nbsp;|
			</span>
		</c:if>
		<c:if test="${username != null }">
			<span class="fr"> <span class="fl">Hi,<a href="#">${username}</a>&nbsp;
					<a href="logout.user" style="color: #ff4e00;">退出</a>&nbsp;|&nbsp;<a
					href="#">我的订单</a>&nbsp;|
			</span>
		</c:if>
		<span class="ss">
			<div class="ss_list">
				<a href="#">收藏夹</a>
				<div class="ss_list_bg">
					<div class="s_city_t"></div>
					<div class="ss_list_c">
						<ul>
							<li><a href="#">收藏的店铺</a></li>
							<li><a href="#">收藏的宝贝</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="ss_list">
				<a href="#">客户服务</a>
				<div class="ss_list_bg">
					<div class="s_city_t"></div>
					<div class="ss_list_c">
						<ul>
							<li><a href="#">帮助中心</a></li>
							<li><a href="#">售后服务</a></li>
							<li><a href="#">在线客服</a></li>
							<li><a href="#">意见建议</a></li>
							<li><a href="#">电话客服</a></li>
							<li><a href="#">客服邮箱</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="ss_list">
				<a href="#">网站导航</a>
				<div class="ss_list_bg">
					<div class="s_city_t"></div>
					<div class="ss_list_c">
						<ul>
							<li><a href="#">网站导航</a></li>
							<li><a href="#">网站导航</a></li>
						</ul>
					</div>
				</div>
			</div>
		</span> <span class="fl">|&nbsp;关注我们：</span> <span class="s_sh"><a
			href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span> <span
			class="fr">|&nbsp;<a href="#">手机版&nbsp;<img
				src="images/s_tel.png" align="absmiddle" /></a></span> </span>
	</div>
</div>
<div class="top">
	<div class="logo">
		<a href="Index.html"><img src="images/logo.png" /></a>
	</div>
	<div class="search">
		<form>
			<input type="text" value="" class="s_ipt" /> <input type="submit"
				value="搜索" class="s_btn" />
		</form>
		<span class="fl"><a href="#">针织衣</a><a href="#">Iphone X</a><a
			href="#">羽绒服</a><a href="#">客厅灯</a><a href="#">口红</a><a href="#">手机</a></span>
	</div>
	<div class="i_car">
		<div class="car_t">
			<a rel="nofollow" href="index.cart" class="shopping_cart"
				id="shopping_cart" style="display:"> 购物车 [ <span>3</span> ]
			</a>
		</div>
		<div class="car_bg">
			<!--Begin 购物车未登录 Begin-->
			<c:if test="${username == null }">
				<div class="un_login">
					还未登录！<a href="login.jsp" style="color: #ff4e00;">马上登录</a> 查看购物车！
				</div>
			</c:if>
			<!--End 购物车未登录 End-->
			<!--Begin 购物车已登录 Begin-->
			<c:if test="${username != null }">
				<ul class="cars">
					<!-- 查询购物车 -->
					<c:forEach items="${shoppingCartGoodsList }" var="g">
						<li id="list" value="${g.id }">
							<div class="img">
								<a href="GoodsPageServlet?id=${g.id }"><img
									src="${g.proPic }" width="58" height="58" /></a>
							</div>
							<div class="name">
								<a href="GoodsPageServlet?id=${g.id }">${g.name }</a>
							</div>
							<div class="price">
								<font color="#ff4e00">￥ <span id="${g.id }Subtotal">${g.price }</span><span>&nbsp;*&nbsp;</span><span
									class="${g.id }" id="${g.id }num">${g.num }</span></font>
							</div>
						</li>
					</c:forEach>
					<c:if test="${shoppingCartGoodsList.size()==0 }">
						<p class="sc_goods_none">您的购物车还是空的，赶紧行动吧！</p>
					</c:if>
				</ul>
				<div
					<c:if test="${shoppingCartGoodsList.size()==0 }">style="display:none;"</c:if>>
					<div class="price_sum">
						共计&nbsp; <font color="#ff4e00">￥</font><span class="sum"
							id="total">0.00</span>
					</div>
					<div class="price_a">
						<a href="index.cart">去购物车结算</a>
					</div>
				</div>
			</c:if>
			<!--End 购物车已登录 End-->
		</div>
	</div>
</div>
<!--End 头部代码（最顶部、logo、搜索、导航菜单） End-->
<script type="text/javascript">
	$(function() {
		var total = 0;
		/*
		1. 获取所有的商品！循环遍历之
		 */
		$("li").each(function() {
			//2. 获取商品的值，即其他元素的前缀
			var id = $(this).val();
			//3. 再通过前缀找到小计元素，获取其文本
			var text = $("#" + id + "Subtotal").text();
			//找到数量
			var num = $("#" + id + "num").text();

			//4. 累加计算
			total += text * num;
		});
		// 5. 把总计显示在总计元素上
		$("#total").text(round(total, 2));//round()函数的作用是把total保留2位
	});
	function round(num, dec) {
		var strNum = num + '';/*把要转换的小数转换成字符串*/
		var index = strNum.indexOf("."); /*获取小数点的位置*/
		if (index < 0) {
			return num;/*如果没有小数点，那么无需四舍五入，返回这个整数*/
		}
		var n = strNum.length - index - 1;/*获取当前浮点数，小数点后的位数*/
		if (dec < n) {
			/*把小数点向后移动要保留的位数，把需要保留的小数部分变成整数部分，只留下不需要保留的部分为小数*/
			var e = Math.pow(10, dec);
			num = num * e;
			/*进行四舍五入，只保留整数部分*/
			num = Math.round(num);
			/*再把原来小数部分还原为小数*/
			return num / e;
		} else {
			return num;/*如果当前小数点后的位数等于或小于要保留的位数，那么无需处理，直接返回*/
		}
	}
</script>
