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
<title>确认支付</title>
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
						<li><a href="member_order.jsp" class="now">我的订单</a></li>
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
						<li><a href="member_links.jsp">推广链接</a></li>
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

				<table border="0" class="ma_tab"
					style="width: 930px; margin-top: 50px;" cellspacing="0"
					cellpadding="0">
					<tr>
						<td align="right" width="130" style="padding-right: 30px;">您的充值金额为</td>
						<td>￥ 999.00</td>
					</tr>
					<tr>
						<td align="right" style="padding-right: 30px;">您选择的支付方式为</td>
						<td>支付宝</td>
					</tr>
					<tr>
						<td align="right" style="padding-right: 30px;">支付手续费用为</td>
						<td>￥ 0.00</td>
					</tr>
					<tr valign="top">
						<td align="right" style="padding-right: 30px;">支付方式描述</td>
						<td>支付宝网站(www.alipay.com) 是国内先进的网上支付平台。<br />
							支付宝收款接口：在线即可开通，<font color="#ff4e00">零预付，免年费，</font>单笔阶梯费率，无流量限制。<br />
							<a href="#" style="color: #ff4e00;">立即在线申请</a>
						</td>
					</tr>
				</table>

				<p align="center">
					<input type="submit" value="立即使用支付宝支付" class="btn_tj" />
				</p>
			</div>
		</div>
		<!--End 用户中心 End-->
		<%@ include file="jsps/footer.jsp"%>
	</div>
</body>
</html>