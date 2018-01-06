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
<title>用户注册</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="icon" href="images/title_icon.png" type="image/x-icon" />

<link href="css/common.css" rel="stylesheet" />
<link href="css/top.css" rel="stylesheet" />
<link href="css/footer.css" rel="stylesheet" />
<link href="css/login_regist.css" rel="stylesheet" />
<link href="js/layui/css/modules/layer/default/layer.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/registVerify.js"></script>
<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="js/lrscroll.js"></script>
<script type="text/javascript" src="js/lrscroll_1.js"></script>
<script src="js/layui/lay/modules/layer.js" charset="utf-8"></script>
</head>
<body>
	<script type="text/javascript">
  		var v = "${registState }";
  		if(v){
  			alert("抱歉注册失败！再试试看吧");
  		}
  	</script>
	<!--Begin Header Begin-->
	<div class="soubg">
		<div class="sou">
			<span class="fr"> <span class="fl">你好，请<a
					href="login.jsp">登录</a>&nbsp; <a href="regist.jsp"
					style="color: #ff4e00;">免费注册</a>&nbsp;
			</span> <span class="fl">|&nbsp;关注我们：</span> <span class="s_sh"><a
					href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span> <span
				class="fr">|&nbsp;<a href="#">手机版&nbsp;<img
						src="images/s_tel.png" align="absmiddle" /></a></span>
			</span>
		</div>
	</div>
	<!--End Header End-->
	<!--Begin Login Begin-->
	<div class="log_bg">
		<div class="top">
			<div class="logo">
				<a href="index.jsp"><img src="images/logo_lucency.png" /></a>
			</div>
		</div>
		<div class="regist">
			<div class="log_img">
				<img src="images/l_img.png" width="611" height="425" />
			</div>
			<div class="reg_c">
				<form name="frm" class="form-horizontal" role="form"
					action="registuser.user" method="post">
					<table border="0"
						style="width: 495px; font-size: 14px; margin-top: 20px;"
						cellspacing="0" cellpadding="0">
						<tr height="50" valign="top">
							<td width="95">&nbsp;</td>
							<td><span class="fl" style="font-size: 24px;">注册</span> <span
								class="fr">已有商城账号，<a href="login.jsp"
									style="color: #ff4e00;">我要登录</a></span></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;用户名
								&nbsp;</td>
							<td><input id="tusername" type="text" value=""
								name="username" placeholder="请输入用户名" class="l_user" /></td>
							<td><label id="registUser"></label></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;密码
								&nbsp;</td>
							<td><input id="tpassword1" type="password" value=""
								placeholder="请输入密码" name="password" class="l_pwd" /></td>
							<td><label id="registPassword1"></label></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码
								&nbsp;</td>
							<td><input id="tpassword2" type="password" value=""
								placeholder="请输入密码" class="l_pwd" /></td>
							<td><label id="registPassword2"></label></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱
								&nbsp;</td>
							<td><input id="temail" type="text" value="" name="email"
								placeholder="请输入邮箱地址" class="l_email" /></td>
							<td><label id="registEmail"></label></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;手机
								&nbsp;</td>
							<td><input id="tphone" type="text" value="" name="phone"
								placeholder="请输入手机号码" class="l_tel" /></td>
							<td><label id="registPhone"></label></td>
						</tr>
						<tr height="50">
							<td align="right">邀请人会员名 &nbsp;</td>
							<td><input type="text" value="" placeholder="请输入邀请人会员名"
								class="l_mem" /></td>
							<td><label id=""></label></td>
						</tr>
						<tr height="50">
							<td align="right">邀请人ID号 &nbsp;</td>
							<td><input type="text" value="" placeholder="请输入邀请人ID号"
								class="l_num" /></td>
							<td><label id=""></label></td>
						</tr>
						<tr height="50">
							<td align="right"><font color="#ff4e00">*</font>&nbsp;验证码
								&nbsp;</td>
							<td><input id="tcode" type="text" value="" name="code"
								placeholder="请输入验证码" class="l_ipt" /> <a href="javascript:;"
								onclick="changeImage()"
								style="font-size: 12px; font-family: '宋体';"><img
									id="CreateCheckCode" src="genImage.code"></a></td>
							<td><label id="registSecurityCode"></label></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td style="font-size: 12px; padding-top: 20px;"><span
								style="font-family: '宋体';" class="fl"> <label
									class="r_rad"><input type="checkbox" /></label><label
									class="r_txt">我已阅读并接受《用户协议》</label>
							</span></td>
						</tr>
						<tr height="60">
							<td>&nbsp;</td>
							<td><input type="button" value="立即注册" class="log_btn"
								onclick="bdtj()" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<!--End Login End-->
	<!--Begin Footer Begin-->
	<div class="btmbg">
		<div class="btm">
			备案/许可证编号：粤ICP备12009302号-1-www.hafele.com Copyright © 2015-2018 爱码购商城网
			All Rights Reserved. 复制必究 , Technical Support: 18475536452@163.com <br />
			<img src="images/b_1.gif" width="98" height="33" /><img
				src="images/b_2.gif" width="98" height="33" /><img
				src="images/b_3.gif" width="98" height="33" /><img
				src="images/b_4.gif" width="98" height="33" /><img
				src="images/b_5.gif" width="98" height="33" /><img
				src="images/b_6.gif" width="98" height="33" />
		</div>
	</div>
	<!--End Footer End -->

</body>
</html>