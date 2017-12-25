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
<title>我的会员</title>
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
						<li><a href="member_member.jsp" class="now">我的会员</a></li>
						<li><a href="member_results.jsp">我的业绩</a></li>
						<li><a href="member_commission.jsp">我的佣金</a></li>
						<li><a href="member_cash.jsp">申请提现</a></li>
					</ul>
				</div>
			</div>
			<div class="m_right">
				<p></p>

				<div class="mem_tit">
					我的会员<span class="m_num">共 588人</span>
				</div>
				<ul class="members">
					<li>
						<div class="nums">（106）</div>
						<div class="m_type">
							<a href="Member_Member_List.html">一级会员</a>
						</div>
					</li>
					<li>
						<div class="nums">（86）</div>
						<div class="m_type">
							<a href="#">二级会员</a>
						</div>
					</li>
					<li>
						<div class="nums">（106）</div>
						<div class="m_type">
							<a href="#">三级会员</a>
						</div>
					</li>
					<li>
						<div class="nums">（106）</div>
						<div class="m_type">
							<a href="#">四级会员</a>
						</div>
					</li>
					<li>
						<div class="nums">（106）</div>
						<div class="m_type">
							<a href="#">五级会员</a>
						</div>
					</li>
				</ul>
			</div>
		</div>
		<!--End 用户中心 End-->
		<%@ include file="jsps/footer.jsp"%>
	</div>

</body>
</html>