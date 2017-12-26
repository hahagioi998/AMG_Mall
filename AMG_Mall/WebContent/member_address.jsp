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
<title>收货地址</title>
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
						<li><a href="address.member" class="now">收货地址</a></li>
						<li><a href="#">缺货登记</a></li>
						<li><a href="#">跟踪订单</a></li>
					</ul>
				</div>
				<div class="left_m">
					<div class="left_m_t t_bg2">会员中心</div>
					<ul>
						<li><a href="user.member">用户信息</a></li>
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
				<p></p>
				<div class="mem_tit">收货地址</div>
				<div class="address">
					<div class="a_close">
						<a href="#"><img src="images/a_close.png" /></a>
					</div>
					<table border="0" class="add_t" align="center"
						style="width: 98%; margin: 10px auto;" cellspacing="0"
						cellpadding="0">
						<tr>
							<td colspan="2" style="font-size: 14px; color: #ff4e00;">杨杨公司</td>
						</tr>
						<tr>
							<td align="right" width="80">收货人姓名：</td>
							<td>杨杨</td>
						</tr>
						<tr>
							<td align="right">配送区域：</td>
							<td>四川成都市武侯区三环以内</td>
						</tr>
						<tr>
							<td align="right">详细地址：</td>
							<td>科华北路66号世外桃源写字楼3楼</td>
						</tr>
						<tr>
							<td align="right">手机：</td>
							<td>12345678998</td>
						</tr>
						<tr>
							<td align="right">电话：</td>
							<td>028-12345678</td>
						</tr>
						<tr>
							<td align="right">电子邮箱：</td>
							<td>123456789@qq.com</td>
						</tr>
						<tr>
							<td align="right">标志建筑：</td>
							<td>世外桃源</td>
						</tr>
					</table>

					<p align="right">
						<a href="#" style="color: #ff4e00;">设为默认</a>&nbsp; &nbsp; &nbsp;
						&nbsp; <a href="#" style="color: #ff4e00;">编辑</a>&nbsp; &nbsp;
						&nbsp; &nbsp;
					</p>

				</div>

				<div class="mem_tit">
					<a href="#"><img src="images/add_ad.gif" /></a>
				</div>
				<table border="0" class="add_tab" style="width: 930px;"
					cellspacing="0" cellpadding="0">
					<tr>
						<td width="135" align="right">配送地区</td>
						<td colspan="3" style="font-family: '宋体';"><select class="jj"
							name="country" style="background-color: #f6f6f6;">
								<option value="0" selected="selected">请选择...</option>
								<option value="1">中国</option>
								<option value="2">中国</option>
								<option value="3">中国</option>
								<option value="4">中国</option>
						</select> <select class="jj" name="province">
								<option value="0" selected="selected">请选择...</option>
								<option value="1">四川</option>
								<option value="2">重庆</option>
								<option value="3">北京</option>
								<option value="4">云南</option>
						</select> <select class="jj" name="city">
								<option value="0" selected="selected">请选择...</option>
								<option value="1">成都</option>
								<option value="2">宜宾</option>
								<option value="3">南充</option>
								<option value="4">绵阳</option>
						</select> <select class="jj" name="area">
								<option value="0" selected="selected">请选择...</option>
								<option value="1">武侯区</option>
								<option value="2">成华区</option>
								<option value="3">锦江区</option>
								<option value="4">青羊区</option>
						</select> （必填）</td>
					</tr>
					<tr>
						<td align="right">收货人姓名</td>
						<td style="font-family: '宋体';"><input type="text" value="姓名"
							class="add_ipt" />（必填）</td>
						<td align="right">电子邮箱</td>
						<td style="font-family: '宋体';"><input type="text"
							value="12345678@qq.com" class="add_ipt" />（必填）</td>
					</tr>
					<tr>
						<td align="right">详细地址</td>
						<td style="font-family: '宋体';"><input type="text"
							value="世外桃源" class="add_ipt" />（必填）</td>
						<td align="right">邮政编码</td>
						<td style="font-family: '宋体';"><input type="text"
							value="610000" class="add_ipt" /></td>
					</tr>
					<tr>
						<td align="right">手机</td>
						<td style="font-family: '宋体';"><input type="text"
							value="1361234587" class="add_ipt" />（必填）</td>
						<td align="right">电话</td>
						<td style="font-family: '宋体';"><input type="text"
							value="028-12345678" class="add_ipt" /></td>
					</tr>
					<tr>
						<td align="right">标志建筑</td>
						<td style="font-family: '宋体';"><input type="text"
							value="世外桃源大酒店" class="add_ipt" /></td>
						<td align="right">最佳送货时间</td>
						<td style="font-family: '宋体';"><input type="text" value=""
							class="add_ipt" /></td>
					</tr>
				</table>
				<p align="right">
					<a href="#">删除</a>&nbsp; &nbsp; <a href="#" class="add_b">确认修改</a>
				</p>



			</div>
		</div>
		<!--End 用户中心 End-->
		<%@ include file="jsps/footer.jsp"%>
	</div>
</body>
</html>