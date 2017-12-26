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
<title>用户信息</title>
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
						<li><a href="order.member">我的订单</a></li>
						<li><a href="address.member">收货地址</a></li>
						<li><a href="#">缺货登记</a></li>
						<li><a href="#">跟踪订单</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg2">会员中心</div>
					<ul>
						<li><a href="user.member" class="now">用户信息</a></li>
						<li><a href="collect.member">我的收藏</a></li>
						<li><a href="msg.member">我的留言</a></li>
						<li><a href="links.member">推广链接</a></li>
						<li><a href="#">我的评论</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg3">账户中心</div>
					<ul>
						<li><a href="safe.member">账户安全</a></li>
						<li><a href="packet.member">我的红包</a></li>
						<li><a href="money.member">资金管理</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg4">分销中心</div>
					<ul>
						<li><a href="member.member">我的会员</a></li>
						<li><a href="results.member">我的业绩</a></li>
						<li><a href="commission.member">我的佣金</a></li>
						<li><a href="cash.member">申请提现</a></li>
					</ul>
				</div>
			</div>
			<div class="m_right">
				<div class="m_des">
					<table border="0" style="width: 870px; line-height: 22px;"
						cellspacing="0" cellpadding="0">
						<tr valign="top">
							<td width="115"><img src="images/user.jpg" width="90"
								height="90" /></td>
							<td>
								<div class="m_user">TRACY</div>
								<p>
									等级：注册用户 <br /> <font color="#ff4e00">您还差 270 积分达到 分红100</font><br />
									上一次登录时间: 2015-09-28 18:19:47<br /> 您还没有通过邮件认证 <a href="#"
										style="color: #ff4e00;">点此发送认证邮件</a>
								</p>
								<div class="m_notice">用户中心公告！</div>
							</td>
						</tr>
					</table>
				</div>

				<div class="mem_t">资产信息</div>
				<table border="0" class="mon_tab"
					style="width: 870px; margin-bottom: 20px;" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="33%">用户等级：<span style="color: #555555;">普通会员</span></td>
						<td width="33%">消费金额：<span>￥200元</span></td>
						<td width="33%">返还积分：<span>99R</span></td>
					</tr>
					<tr>
						<td>账户余额：<span>￥200元</span></td>
						</td>
						<td>红包个数：<span style="color: #555555;">3个</span></td>
						</td>
						<td>红包价值：<span>￥50元</span></td>
						</td>
					</tr>
					<tr>
						<td colspan="3">订单提醒： <font style="font-family: '宋体';">待付款(<span>0</span>)
								&nbsp; &nbsp; &nbsp; &nbsp; 待收货(<span>2</span>) &nbsp; &nbsp;
								&nbsp; &nbsp; 待评论(<span>1</span>)
						</font>
						</td>
					</tr>
				</table>

				<div class="mem_t">账号信息</div>
				<table border="0" class="mon_tab"
					style="width: 870px; margin-bottom: 20px;" cellspacing="0"
					cellpadding="0">
					<tr>
						<td width="40%">用户ID：<span style="color: #555555;">12345678</span></td>
						<td width="60%">邀请人：<span style="color: #555555;">邀请人姓名</span></td>
					</tr>
					<tr>
						<td>电&nbsp; &nbsp; 话：<span style="color: #555555;">1861111111</span></td>
						<td>邮&nbsp; &nbsp; 箱：<span style="color: #555555;">12345678@qq.com</span></td>
					</tr>
					<tr>
						<td>身份证号：<span style="color: #555555;">522555123456789</span></td>
						<td>注册时间：<span style="color: #555555;">2015-10-10</span></td>
					</tr>
				</table>


			</div>
		</div>
		<!--End 用户中心 End-->
		<%@ include file="jsps/footer.jsp"%>
	</div>
</body>
</html>