<%@page import="com.hafele.bean.GoodsBean"%>
<%@page import="com.hafele.bean.SmallTypeBean"%>
<%@page import="com.hafele.bean.BigTypeBean"%>
<%@page import="com.hafele.bean.DetailTypeBean"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	if (request.getAttribute("shoppingCartGoodsList") == null) {
		pageContext.forward("indexServlet");
	}
%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>爱码购商城</title>

<link rel="icon" href="images/title_icon.png" type="image/x-icon" />

<link href="css/common.css" rel="stylesheet" />
<link href="css/top.css" rel="stylesheet" />
<link href="css/menu.css" rel="stylesheet" />
<link href="css/footer.css" rel="stylesheet" />
<link href="css/index.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>

<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="js/lrscroll.js"></script>
<script type="text/javascript" src="js/iban.js"></script>
<script type="text/javascript" src="js/one_floor.js"></script>
<script type="text/javascript" src="js/two_floor.js"></script>
<script type="text/javascript" src="js/third_floor.js"></script>
<script type="text/javascript" src="js/four_floor.js"></script>
<script type="text/javascript" src="js/five_floor.js"></script>
<script type="text/javascript" src="js/six_floor.js"></script>
<script type="text/javascript" src="js/lrscroll_1.js"></script>

</head>
<body>
	<%@ include file="jsps/top.jsp"%>
	<!--Begin Menu Begin-->
	<div class="menu_bg">
		<div class="menu">
			<!--Begin 商品分类详情 Begin-->
			<div class="nav">
				<div class="nav_t">全部商品分类</div>
				<div class="leftNav">
					<ul>
						<!-- 商品分类循环go -->
						<c:forEach items="${floor }" var="bigType">
							<li>
								<div class="fj">
									<span class="n_img"><span> </span><img
										src="${bigType.imgUrl }" /> </span> <span class="fl">${bigType.name }</span>
								</div>
								<div class="zj" style="top:${bigType.remarks };">
									<div class="zj_l">
										<c:forEach items="${bigType.smallTypeList }" var="smallType">
											<div class="zj_l_c">
												<h2>
													<a href="search?sid=${smallType.id }&p=1" target="_blank">${smallType.name }</a>
												</h2>
												<c:forEach items="${smallType.detailTypeList }"
													var="detailType">
													<a href="search?did=${detailType.id }&p=1" target="_blank">${detailType.name}</a>|
											</c:forEach>
											</div>
										</c:forEach>
									</div>
									<div class="zj_r">
										<a href="#"><img src="images/n_img1.jpg" width="236"
											height="200" /></a> <a href="#"><img src="images/n_img2.jpg"
											width="236" height="200" /></a>
									</div>
								</div>
							</li>
						</c:forEach>
						<!-- 商品分类循环end -->
					</ul>
				</div>
			</div>
			<!--End 商品分类详情 End-->
			<ul class="menu_r">
				<li><a href="index.jsp">首页</a></li>
				<li><a href="Food.html">美食</a></li>
				<li><a href="Fresh.html">生鲜</a></li>
				<li><a href="HomeDecoration.html">家居</a></li>
				<li><a href="SuitDress.html">女装</a></li>
				<li><a href="MakeUp.html">美妆</a></li>
				<li><a href="Digital.html">数码</a></li>
				<li><a href="GroupBuying.html">团购</a></li>
			</ul>
			<div class="m_ad">双十二狂欢！</div>
		</div>
	</div>
	<!--End Menu End-->
	<div class="i_bg bg_color">
		<div class="i_ban_bg">
			<!--Begin Banner Begin-->
			<div class="banner">
				<div class="top_slide_wrap">
					<ul class="slide_box bxslider">
						<c:forEach items="${slideList }" var="u">
							<li><a href="${u.url }" target="_blank"><img
									src="${u.proPic }" width="740" height="401" /></a></li>
						</c:forEach>
					</ul>
					<div class="op_btns clearfix">
						<a href="#" class="op_btn op_prev"><span></span></a> <a href="#"
							class="op_btn op_next"><span></span></a>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				//var jq = jQuery.noConflict();
				(function() {
					$(".bxslider").bxSlider({
						auto : true,
						prevSelector : jq(".top_slide_wrap .op_prev")[0],
						nextSelector : jq(".top_slide_wrap .op_next")[0]
					});
				})();
			</script>
			<!--End Banner End-->
			<div class="inews">
				<div class="news_t">
					<span class="fr"><a href="#">更多 ></a></span>新闻资讯
				</div>
				<ul>
					<li><span>[ 特惠 ]</span><a href="#">掬一轮明月 表无尽惦念</a></li>
					<li><span>[ 公告 ]</span><a href="#">好奇金装成长裤新品上市</a></li>
					<li><span>[ 特惠 ]</span><a href="#">大牌闪购 · 抢！</a></li>
					<li><span>[ 公告 ]</span><a href="#">发福利 买车就抢千元油卡</a></li>
					<li><span>[ 公告 ]</span><a href="#">家电低至五折</a></li>
				</ul>
				<div class="charge_t">
					话费充值
					<div class="ch_t_icon"></div>
				</div>
				<form>
					<table border="0" style="width: 205px; margin-top: 10px;"
						cellspacing="0" cellpadding="0">
						<tr height="35">
							<td width="33">号码</td>
							<td><input type="text" value="" class="c_ipt" /></td>
						</tr>
						<tr height="35">
							<td>面值</td>
							<td><select class="jj" name="city">
									<option value="0" selected="selected">100元</option>
									<option value="1">50元</option>
									<option value="2">30元</option>
									<option value="3">20元</option>
									<option value="4">10元</option>
							</select> <span style="color: #ff4e00; font-size: 14px;">￥99.5</span></td>
						</tr>
						<tr height="35">
							<td colspan="2"><input type="submit" value="立即充值"
								class="c_btn" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<!--Begin 热门商品 Begin-->
		<div class="content mar_10">
			<div class="h_l_img">
				<div class="img">
					<a href="product.jsp" target="_blank"><img
						src="images/l_img.jpg" width="188" height="188" /></a>
				</div>
				<div class="pri_bg">
					<span class="price fl">￥53.00</span> <span class="fr">16R</span>
				</div>
			</div>
			<div class="hot_pro">
				<div id="featureContainer">
					<div id="feature">
						<div id="block">
							<div id="botton-scroll">
								<ul class="featureUL">
									<c:forEach items="${hotList }" var="hot">
										<li class="featureBox">
											<div class="box">
												<div class="h_icon">
													<img src="images/hot.png" width="50" height="50" />
												</div>
												<div class="imgbg">
													<a href="GoodsPageServlet?id=${hot.id }" target="_blank"
														title="${hot.name }"><img src="${hot.proPic }"
														width="160" height="136" /></a>
												</div>
												<div class="name">
													<a href="GoodsPageServlet?id=${hot.id }" target="_blank"
														title="${hot.name }">
														<h2>${hot.name }</h2> 德亚全脂纯牛奶200ml*48盒
													</a>
												</div>
												<div class="price">
													<font>￥<span>${hot.price }</span></font> &nbsp; 26R
												</div>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>
						<a class="h_prev" href="javascript:void();">Previous</a> <a
							class="h_next" href="javascript:void();">Next</a>
					</div>
				</div>
			</div>
		</div>
		<!--Begin 限时特卖 Begin-->
		<div class="i_t mar_10">
			<span class="fl">限时特卖</span> <span class="i_mores fr"><a
				href="#">更多</a></span>
		</div>
		<div class="content">
			<div class="i_sell">
				<div id="imgPlay">
					<ul class="imgs" id="actor">
						<li><a href="#"><img src="images/tm_r.jpg" width="211"
								height="357" /></a></li>
						<li><a href="#"><img src="images/tm_b1.jpg" width="211"
								height="357" /></a></li>
						<li><a href="#"><img src="images/tm_b2.jpg" width="211"
								height="357" /></a></li>
					</ul>
					<div class="previ">上一张</div>
					<div class="nexti">下一张</div>
				</div>
			</div>
			<div class="sell_right">
				<c:forEach items="${specialSale }" var="specialSale"
					varStatus="sale">
					<div class="sell_${sale.index+1 }">
						<div class="s${sale.index+1 }_img">
							<a href="GoodsPageServlet?id=${specialSale.id }" target="_blank"
								title="${specialSale.name }"><img
								src="${specialSale.proPic }" width="185" height="155" /></a>
						</div>
						<div class="s_price">
							￥<span>${specialSale.price }</span>
						</div>
						<div class="s_name">
							<h2>
								<a href="GoodsPageServlet?id=${specialSale.id }" target="_blank"
									title="${specialSale.name }">${specialSale.name }</a>
							</h2>
							倒计时：<span>1200</span> 时 <span>30</span> 分 <span>28</span> 秒
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<!--End 限时特卖 End-->
		<div class="content mar_20">
			<img src="images/mban_1.jpg" width="1200" height="110" />
		</div>
		<!--Begin 楼层分类 Begin-->
		<c:forEach items="${floor }" var="bigType" varStatus="big">
			<div class="i_t mar_10">
				<span class="floor_num">${big.index+1 }F</span> <span class="fl">${bigType.name }</span>
				<span class="i_mores fr"> <c:forEach
						items="${bigType.smallTypeList }" var="smallType">
						<a href="search?sid=${smallType.id }&p=1" target="_blank">${smallType.name}</a>&nbsp; &nbsp;&nbsp; 
				</c:forEach>
				</span>
			</div>
			<div class="content">
				<div class="ban${big.index+1 }_left">
					<div class="ban${big.index+1 }">
						<div id="imgPlay${big.index+1 }">
							<ul class="imgs" id="actor${big.index+1 }">
								<c:forEach items="${bigType.goods }" var="goods">
									<li><a href="GoodsPageServlet?id=${goods.id }"
										target="_blank" title="${goods.name }"><img
											src="${goods.proPic }" width="211" height="286" /></a></li>
								</c:forEach>
							</ul>
							<div class="prev${big.index+1 }">上一张</div>
							<div class="next${big.index+1 }">下一张</div>
						</div>
					</div>
					<div class="fresh_txt">
						<div class="fresh_txt_c">
							<c:forEach items="${bigType.smallTypeList }" var="smallType">
								<a href="search?sid=${smallType.id }&p=1" target="_blank">${smallType.name}</a>&nbsp;
							</c:forEach>
						</div>
					</div>
				</div>
				<div class="fresh_mid">
					<ul>
						<c:forEach items="${bigType.goods }" var="goods">
							<li>
								<div class="name">
									<a href="GoodsPageServlet?id=${goods.id }" target="_blank"
										title="${goods.name }">${goods.name }</a>
								</div>
								<div class="price">
									<font>￥<span>${goods.price }</span></font> &nbsp; 26R
								</div>
								<div class="img">
									<a href="GoodsPageServlet?id=${goods.id }" target="_blank"
										title="${goods.name }"><img src="${goods.proPic }"
										width="185" height="155" /></a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="fresh_right">
					<ul>
						<li><a href="#"><img src="images/fre_b1.jpg" width="260"
								height="220" /></a></li>
						<li><a href="#"><img src="images/fre_b2.jpg" width="260"
								height="220" /></a></li>
					</ul>
				</div>
			</div>
		</c:forEach>
		<!--End 楼层分类 End-->
		<!--Begin 猜你喜欢 Begin-->
		<div class="i_t mar_10">
			<span class="fl">猜你喜欢</span>
		</div>
		<div class="like">
			<div id="featureContainer1">
				<div id="feature1">
					<div id="block1">
						<div id="botton-scroll1">
							<ul class="featureUL">
								<li class="featureBox">
									<div class="box">
										<div class="imgbg">
											<a href="#"><img src="images/hot1.jpg" width="160"
												height="136" /></a>
										</div>
										<div class="name">
											<a href="#">
												<h2>德国进口</h2> 德亚全脂纯牛奶200ml*48盒
											</a>
										</div>
										<div class="price">
											<font>￥<span>189</span></font> &nbsp; 26R
										</div>
									</div>
								</li>
								<li class="featureBox">
									<div class="box">
										<div class="imgbg">
											<a href="#"><img src="images/hot2.jpg" width="160"
												height="136" /></a>
										</div>
										<div class="name">
											<a href="#">
												<h2>iphone 6S</h2> Apple/苹果 iPhone 6s Plus公开版
											</a>
										</div>
										<div class="price">
											<font>￥<span>5288</span></font> &nbsp; 25R
										</div>
									</div>
								</li>
								<li class="featureBox">
									<div class="box">
										<div class="imgbg">
											<a href="#"><img src="images/hot3.jpg" width="160"
												height="136" /></a>
										</div>
										<div class="name">
											<a href="#">
												<h2>倩碧特惠组合套装</h2> 倩碧补水组合套装8折促销
											</a>
										</div>
										<div class="price">
											<font>￥<span>368</span></font> &nbsp; 18R
										</div>
									</div>
								</li>
								<li class="featureBox">
									<div class="box">
										<div class="imgbg">
											<a href="#"><img src="images/hot4.jpg" width="160"
												height="136" /></a>
										</div>
										<div class="name">
											<a href="#">
												<h2>品利特级橄榄油</h2> 750ml*4瓶装组合 西班牙原装进口
											</a>
										</div>
										<div class="price">
											<font>￥<span>280</span></font> &nbsp; 30R
										</div>
									</div>
								</li>
								<li class="featureBox">
									<div class="box">
										<div class="imgbg">
											<a href="#"><img src="images/hot4.jpg" width="160"
												height="136" /></a>
										</div>
										<div class="name">
											<a href="#">
												<h2>品利特级橄榄油</h2> 750ml*4瓶装组合 西班牙原装进口
											</a>
										</div>
										<div class="price">
											<font>￥<span>280</span></font> &nbsp; 30R
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<a class="l_prev" href="javascript:void();">Previous</a> <a
						class="l_next" href="javascript:void();">Next</a>
				</div>
			</div>
		</div>
		<!--End 猜你喜欢 End-->
		<%@ include file="jsps/footer.jsp"%>
	</div>
</body>
</html>