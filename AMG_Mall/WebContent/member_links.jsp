<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>推广链接</title>
<link rel="icon" href="images/title_icon.png" type="image/x-icon" />

<link href="css/style.css" rel="stylesheet" />
<link href="css/top.css" rel="stylesheet" />
<link href="css/footer.css" rel="stylesheet" />
<link href="css/login_regist.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<script type="text/javascript" src="js/select.js"></script>
</head>
<body>
	<%@ include file="jsps/top.jsp"%>
	<div class="i_bg bg_color">
		<!--Begin 用户中心 Begin -->
		<div class="m_content">
			<div class="m_left">
				<div class="left_n">管理中心</div>
				<div class="left_m">
					<div class="left_m_t t_bg1">订单中心</div>
					<ul>
						<li><a href="member_order.jsp">我的订单</a></li>
						<li><a href="member_address.jsp">收货地址</a></li>
						<li><a href="#">缺货登记</a></li>
						<li><a href="#">跟踪订单</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg2">会员中心</div>
					<ul>
						<li><a href="member_user.jsp">用户信息</a></li>
						<li><a href="member_collect.jsp">我的收藏</a></li>
						<li><a href="member_msg.jsp">我的留言</a></li>
						<li><a href="member_links.jsp" class="now">推广链接</a></li>
						<li><a href="#">我的评论</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg3">账户中心</div>
					<ul>
						<li><a href="member_safe.jsp">账户安全</a></li>
						<li><a href="member_packet.jsp">我的红包</a></li>
						<li><a href="member_money.jsp">资金管理</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg4">分销中心</div>
					<ul>
						<li><a href="member_member.jsp">我的会员</a></li>
						<li><a href="member_results.jsp">我的业绩</a></li>
						<li><a href="member_commission.jsp">我的佣金</a></li>
						<li><a href="member_cash.jsp">申请提现</a></li>
					</ul>
				</div>
			</div>
			<div class="m_right">
				<p></p>
				<div class="mem_tit">分成明细</div>
				<p style="padding: 0 40px; margin: 0 auto 20px auto;">
					本网店为鼓励推荐新用户注册，现开展 <b>推荐订单分</b> 成活动，活动流程如下： <br />
					<br /> １、在浏览商品时，点击推荐此商品，获得推荐代码，将其发送到论坛、博客上。<br /> ２、访问者点击链接，访问网店。<br />
					３、在访问者点击链接的 <b>24小时</b> 内，若该访问者在本站有订单，即认定该订单是您推荐的。<br />
					４、您将获得该订单金额的 <b>5%</b> 、积分的 <b>7%</b> 的奖励。<br />
					５、提成由管理员人工审核发放，请您耐心等待。<br /> ６、您可以通过分成明细来查看您的介绍、分成情况。<br />
				</p>

				<div class="mem_tit">分成明细</div>
				<table border="0" class="order_tab"
					style="width: 930px; text-align: center; margin-bottom: 30px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="20%">订单号</td>
						<td width="20%">现金分成</td>
						<td width="20%">积分分成</td>
						<td width="20%">分成模式</td>
						<td width="20%">分成状态</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>

				<div class="mem_tit">代码</div>
				<table border="0" class="order_tab"
					style="width: 930px; margin-bottom: 30px;" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="30%" style="color: #ff4e00; text-indent: 20px;">爱码购商城</td>
						<td width="70%"><input type="text"
							value="<a href='http://fx.028dgg.net/?u=76' target='_blank'>AMG商城</a>"
							class="code_ipt" /> 网页签名代码</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>



			</div>
		</div>
		<!--End 用户中心 End-->
		<%@ include file="jsps/footer.jsp"%>
	</div>
</body>
</html>