<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--Begin 头部代码（最顶部、logo、搜索、导航菜单） Begin-->
<div class="soubg">
	<div class="sou">
		<!--Begin 所在收货地区 Begin-->
		<span class="s_city_b"> <span class="fl">送货至：</span> <span
			class="s_city"> <span id="allmap" style="display:none;"></span><span id="place">广州市</span>
			<div id="in_city" style="display: none"></div>
		</span>
		</span>
		<!--End 所在收货地区 End-->
		<c:if test="${username == null }">
			<span class="fr"> <span class="fl">你好，请<a
					href="login.jsp">登录</a>&nbsp; <a href="regist.jsp"
					style="color: #ff4e00;">免费注册</a>&nbsp;|&nbsp;<a href="login.jsp">我的订单</a>&nbsp;|
			</span>
		</c:if>
		<c:if test="${username != null }">
			<span class="fr"> <span class="fl">Hi,<a href="user.member">${username}</a>&nbsp;
					<a href="logout.user" style="color: #ff4e00;">退出</a>&nbsp;|&nbsp;<a
					href="order.member">我的订单</a>&nbsp;|
			</span>
		</c:if>
		<span class="ss">
			<div class="ss_list">
				<c:if test="${username == null }">
					<a href="login.jsp">收藏夹</a>
					<div class="ss_list_bg">
						<div class="s_city_t"></div>
						<div class="ss_list_c">
							<ul>
								<li><a href="login.jsp">收藏的店铺</a></li>
								<li><a href="login.jsp">收藏的宝贝</a></li>
							</ul>
						</div>
					</div>
				</c:if>
				<c:if test="${username != null }">
					<a href="collect.member">收藏夹</a>
					<div class="ss_list_bg">
						<div class="s_city_t"></div>
						<div class="ss_list_c">
							<ul>
								<li><a href="collect.member">收藏的店铺</a></li>
								<li><a href="collect.member">收藏的宝贝</a></li>
							</ul>
						</div>
					</div>
				</c:if>
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
		</span>
		<span class="fl">|&nbsp;关注我们：</span>
		<span class="s_sh">
			<a href="#" class="sh1">新浪</a>
			<a href="#" class="sh2">微信</a>
		</span>
		<span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="images/s_tel.png" align="absmiddle" /></a></span>
	</div>
</div>
<div class="top">
	<div class="logo">
		<a href="index.jsp"><img src="images/logo.png" /></a>
	</div>
	<div class="search">
		<form action="search" name="Searchform" method="post">
			<input type="text" value="" class="s_ipt" /><input value="搜索" class="s_btn" />
			<input type="hidden" name="p" value="1" />
		</form>
		<span class="fl"><a href="#">针织衣</a><a href="#">Iphone X</a><a
			href="#">羽绒服</a><a href="#">客厅灯</a><a href="#">口红</a><a href="#">手机</a></span>
	</div>
	<div class="i_car">
		<div class="car_t">
			<a rel="nofollow" href="index.cart" class="shopping_cart"
				id="shopping_cart" style="display:">&nbsp;&nbsp;&nbsp;购物车
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
<script type="text/javascript" src="js/cityTemplate.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=VMZKb8WGIDGISvZhGow7Yzln72MNwUN6"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("input.s_btn").click(function() {
			var words = $("input.s_ipt").val();
			if (words) {
				document.Searchform.submit();
			} else {
				alert("搜索内容不能为空")
			}

		});
	});
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
	
	//城市选择
	var cityA = $(".city_a_le1 a"); //城市
	var pla = $("#place");  //出发地
	// 默认值
	inCity.width = "296";  //城市选择框  宽
	inCity.height = "auto";  //城市选择框  高
	inCity.id = "#in_city";  //城市选择框  父级ID
	inCity.Children = '.city_a_le1';  //城市名box
	// 初始化 城市HTML模板
	$(inCity.id).prepend(inCity._template.join(''));
	inCity.Hot(cityA);
	
	//城市 导航
	var apay = $(".screen a");

	var placeThis; //当前选择标签
	apay.click(function(obj){  //城市导航
		inCity.payment($(this));
	})

	inCity.place(pla); //城市名
	inCity.cityClick(cityA); //显示赋值城市
	
	// 百度地图API功能
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.331398,39.897445);
	map.centerAndZoom(point,12);

	function myFun(result){
		var cityName = result.name;
		map.setCenter(cityName);
		document.getElementById("place").innerHTML=cityName
	}
	var myCity = new BMap.LocalCity();
	myCity.get(myFun);
</script>
