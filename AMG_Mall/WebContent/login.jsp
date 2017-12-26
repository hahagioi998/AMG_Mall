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
<title>用户登录</title>

<link rel="icon" href="images/title_icon.png" type="image/x-icon" />

<link href="css/common.css" rel="stylesheet" />
<link href="css/top.css" rel="stylesheet" />
<link href="css/footer.css" rel="stylesheet" />
<link href="css/login_regist.css" rel="stylesheet" />

<script type="text/javascript" src="js/jquery-1.11.1.min_044d0927.js"></script>
<script type="text/javascript" src="js/jquery.bxslider_e88acd1b.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>

<script type="text/javascript" src="js/public.js"></script>
<script type="text/javascript" src="js/loginVerify.js"></script>
<script type="text/javascript" src="js/select.js"></script>
<script type="text/javascript" src="js/lrscroll.js"></script>
<script type="text/javascript" src="js/lrscroll_1.js"></script>

</head>
<body>
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
		<div class="login">
			<div class="log_img">
				<img src="images/l_img.png" width="611" height="425" />
			</div>
			<div class="log_c">
				<form name="frm" class="form-horizontal login-user"
					action="mainLogin.user" id="loginform" name="user" method="post">
					<table border="0"
						style="width: 460px; font-size: 14px; margin-top: 30px;"
						cellspacing="0" cellpadding="0">
						<tr height="50" valign="top">
							<td width="55">&nbsp;</td>
							<td><span class="fl" style="font-size: 24px;">登录</span> <span
								class="fr">还没有商城账号，<a href="regist.jsp"
									style="color: #ff4e00;">立即注册</a></span></td>
						</tr>
						<tr height="70">
							<td>用户名</td>
							<td><input type="text" id="inputusername" name="username"
								value="${sessionScope.loginFail}" class="l_user" /></td>
							<td><label id="loginUser"></label></td>
						</tr>
						<tr height="70">
							<td>密&nbsp; &nbsp; 码</td>
							<td><input type="password" id="inputpassword"
								name="password" value="" class="l_pwd" /></td>
							<td><label id="loginPassword"></label></td>
							<c:if test="${sessionScope.loginFail !=null}">
								<script type="text/javascript">
									nameisyz = true; //让昵称验证通过
									loginPassword.innerHTML = "<font color='red' size='-1'>密码输入有误</font>";
									inputpassword.style.border = "1px solid red";
								</script>
							</c:if>
							<c:remove var="loginFail" scope="session" />
						</tr>
						<tr height="70">
							<td>验证码</td>
							<td><input id="tcode" type="text" value="" name="code"
								placeholder="请输入验证码" class="l_ipt" /> <a href="javascript:;"
								onclick="changeImage()"
								style="font-size: 12px; font-family: '宋体';"><img
									id="CreateCheckCode" src="genImage.code"></a></td>
							<td><label id="loginSecurityCode"></label></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td style="font-size: 12px; padding-top: 20px;"><span
								style="font-family: '宋体';" class="fl"> <label
									class="r_rad"><input type="checkbox" /></label><label
									class="r_txt">请保存我这次的登录信息</label>
							</span> <span class="fr"><a href="#" style="color: #ff4e00;">忘记密码</a></span>
							</td>
						</tr>
						<tr height="60">
							<td>&nbsp;</td>
							<td><input type="button" value="登录" class="log_btn" onclick="bdtj()" /></td>
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