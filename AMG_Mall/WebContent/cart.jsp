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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>查看购物车</title>
<link rel="icon" href="images/title_icon.png" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<link href="css/common.css" rel="stylesheet" />
<link href="css/top.css" rel="stylesheet" />
<link href="css/menu.css" rel="stylesheet" />
<link href="css/footer.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script>

<script type="text/javascript" src="js/n_nav.js"></script>

<script type="text/javascript" src="js/num.js">
    	var jq = jQuery.noConflict();
    </script>

<script type="text/javascript" src="js/shade.js"></script>
</head>
<body>
	<%@ include file="jsps/top.jsp"%>
	<%@ include file="jsps/menu.jsp"%>
	<div class="i_bg">
		<div class="content mar_20">
			<img src="images/img1.jpg" />
		</div>

		<!--Begin 第一步：查看购物车 Begin -->
		<div class="content mar_20">
			<table border="0" class="car_tab"
				style="width: 1200px; margin-bottom: 50px;" cellspacing="0"
				cellpadding="0">
				<tr>
					<td class="car_th" width="490">商品名称</td>
					<td class="car_th" width="140">属性</td>
					<td class="car_th" width="150">购买数量</td>
					<td class="car_th" width="130">小计</td>
					<td class="car_th" width="140">返还积分</td>
					<td class="car_th" width="150">操作</td>
				</tr>
				<tr>
					<td>
						<div class="c_s_img">
							<img src="images/c_1.jpg" width="73" height="73" />
						</div> Rio 锐澳 水蜜桃味白兰地鸡尾酒（预调酒） 275ml
					</td>
					<td align="center">颜色：灰色</td>
					<td align="center">
						<div class="c_num">
							<input type="button" value="" onclick="jianUpdate1(jq(this));"
								class="car_btn_1" /> <input type="text" value="1" name=""
								class="car_ipt" /> <input type="button" value=""
								onclick="addUpdate1(jq(this));" class="car_btn_2" />
						</div>
					</td>
					<td align="center" style="color: #ff4e00;">￥620.00</td>
					<td align="center">26R</td>
					<td align="center"><a onclick="ShowDiv('MyDiv','fade')">删除</a>&nbsp;
						&nbsp;<a href="#">加入收藏</a></td>
				</tr>
				<tr class="car_tr">
					<td>
						<div class="c_s_img">
							<img src="images/c_2.jpg" width="73" height="73" />
						</div> Rio 锐澳 水蜜桃味白兰地鸡尾酒（预调酒） 275ml
					</td>
					<td align="center">颜色：灰色</td>
					<td align="center">
						<div class="c_num">
							<input type="button" value="" onclick="jianUpdate1(jq(this));"
								class="car_btn_1" /> <input type="text" value="1" name=""
								class="car_ipt" /> <input type="button" value=""
								onclick="addUpdate1(jq(this));" class="car_btn_2" />
						</div>
					</td>
					<td align="center" style="color: #ff4e00;">￥620.00</td>
					<td align="center">26R</td>
					<td align="center"><a href="#">删除</a>&nbsp; &nbsp;<a href="#">加入收藏</a></td>
				</tr>
				<tr>
					<td>
						<div class="c_s_img">
							<img src="images/c_3.jpg" width="73" height="73" />
						</div> Rio 锐澳 水蜜桃味白兰地鸡尾酒（预调酒） 275ml
					</td>
					<td align="center">颜色：灰色</td>
					<td align="center">
						<div class="c_num">
							<input type="button" value="" onclick="jianUpdate1(jq(this));"
								class="car_btn_1" /> <input type="text" value="1" name=""
								class="car_ipt" /> <input type="button" value=""
								onclick="addUpdate1(jq(this));" class="car_btn_2" />
						</div>
					</td>
					<td align="center" style="color: #ff4e00;">￥620.00</td>
					<td align="center">26R</td>
					<td align="center"><a href="#">删除</a>&nbsp; &nbsp;<a href="#">加入收藏</a></td>
				</tr>
				<tr class="car_tr">
					<td>
						<div class="c_s_img">
							<img src="images/c_4.jpg" width="73" height="73" />
						</div> Rio 锐澳 水蜜桃味白兰地鸡尾酒（预调酒） 275ml
					</td>
					<td align="center">颜色：灰色</td>
					<td align="center">
						<div class="c_num">
							<input type="button" value="" onclick="jianUpdate1(jq(this));"
								class="car_btn_1" /> <input type="text" value="1" name=""
								class="car_ipt" /> <input type="button" value=""
								onclick="addUpdate1(jq(this));" class="car_btn_2" />
						</div>
					</td>
					<td align="center" style="color: #ff4e00;">￥620.00</td>
					<td align="center">26R</td>
					<td align="center"><a href="#">删除</a>&nbsp; &nbsp;<a href="#">加入收藏</a></td>
				</tr>
				<tr height="70">
					<td colspan="6"
						style="font-family: 'Microsoft YaHei'; border-bottom: 0;"><label
						class="r_rad"><input type="checkbox" name="clear"
							checked="checked" /></label><label class="r_txt">清空购物车</label> <span
						class="fr">商品总价：<b style="font-size: 22px; color: #ff4e00;">￥2899</b></span>
					</td>
				</tr>
				<tr valign="top" height="150">
					<td colspan="6" align="right"><a href="index.jsp"><img
							src="images/buy1.gif" /></a>&nbsp; &nbsp; <a href="cart_two.jsp"><img
							src="images/buy2.gif" /></a></td>
				</tr>
			</table>

		</div>
		<!--End 第一步：查看购物车 End-->


		<!--Begin 弹出层-删除商品 Begin-->
		<div id="fade" class="black_overlay"></div>
		<div id="MyDiv" class="white_content">
			<div class="white_d">
				<div class="notice_t">
					<span class="fr" style="margin-top: 10px; cursor: pointer;"
						onclick="CloseDiv('MyDiv','fade')"><img
						src="images/close.gif" /></span>
				</div>
				<div class="notice_c">

					<table border="0" align="center" style="font-size: 16px;"
						cellspacing="0" cellpadding="0">
						<tr valign="top">
							<td>您确定要把该商品移除购物车吗？</td>
						</tr>
						<tr height="50" valign="bottom">
							<td><a href="#" class="b_sure">确定</a><a href="#"
								class="b_buy">取消</a></td>
						</tr>
					</table>

				</div>
			</div>
		</div>
		<!--End 弹出层-删除商品 End-->
		<%@ include file="jsps/footer.jsp"%>
	</div>
</body>
</html>