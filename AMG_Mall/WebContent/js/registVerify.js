/**
 * 注册页面form验证
 */
nameVerify = false;//用户名验证
passwordVerify = false;//密码验证
repeatPasswordVerify = false;//重复密码验证
emailVerify = false;//邮箱地址验证
phoneVerify = false;//手机号码验证
securityCodeVerify = false;//验证码验证
window.onload = function() {
	userNameFormat = /^[a-zA-z][a-zA-Z0-9_]{3,15}$/; //用户名正则表达式
	emailFormat = /\w[-\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\.)+[A-Za-z]{2,14}/;//邮箱地址正则表达式
	phoneFormat = /0?(13|14|15|18|17)[0-9]{9}/;//手机号码正则表达式
	/** 用户名验证 */
	tusername.onblur = function(){
		var username = frm.username.value;//用户名
		if(!userNameFormat.exec(username)){
			registUser.innerHTML = "<font color='red' size='-1'>格式有误</font>";
			tusername.style.border="1px solid red";
			nameVerify = false;
			return;
		}
		$.ajax({
			type:'post',
			url:'http://localhost:8080/AMG_Mall/regist.user',
			data:{name:username},
			dataType:"json",
			success:function(result){
				if(result.success == "true"){
					registUser.innerHTML="<font color='green' size='-1'>可以使用</font>";
					tusername.style.border="1px solid #EEE";
					nameVerify = true;
				}else{
					registUser.innerHTML="<font color='red' size='-1'>已被占用</font>";
					tusername.style.border="1px solid red";
					nameVerify = false;
				}
			}
		});
	}
	
	/** 密码验证 */
	tpassword1.onblur = function(){
		if(tpassword1.value!=""){
			registPassword1.innerHTML="<font color='green' size='-1'>ok</font>";
			tpassword1.style.border="1px solid #EEE";
			passwordVerify = true;
		}else{
			registPassword1.innerHTML="<font color='red' size='-1'>请输入密码</font>";
			tpassword1.style.border="1px solid red";
			passwordVerify = false;
		}
	}
	
	/** 重复密码验证 */
	tpassword2.onblur = function(){
		if(tpassword1.value==""){
			registPassword2.innerHTML="<font color='red' size='-1'>请输入上方密码</font>";
			tpassword1.style.border="1px solid red";
			repeatPasswordVerify = false;
		}else{
			if(tpassword1.value != tpassword2.value){
				registPassword2.innerHTML="<font color='red' size='-1'>两次密码不一致</font>";
				tpassword2.style.border="1px solid red";
				repeatPasswordVerify = false;
			}else{
				registPassword2.innerHTML="<font color='green' size='-1'>ok</font>";
				tpassword2.style.border="1px solid #EEE";
				repeatPasswordVerify = true;
			}
		}
	}
	
	/** 邮箱地址验证 */
	temail.onblur = function(){
		var email = frm.email.value;//邮箱地址
		if(!emailFormat.exec(email)){
			registEmail.innerHTML="<font color='red' size='-1'>邮箱格式错误</font>";
			temail.style.border="1px solid red";
			emailVerify = false;
		}else{
			registEmail.innerHTML="<font color='green' size='-1'>ok</font>";
			temail.style.border="1px solid #EEE";
			emailVerify = true;
		}
	}
	
	/** 手机号码验证 */
	tphone.onblur = function(){
		var phone = frm.phone.value;//手机号码
		if(!phoneFormat.exec(phone)){
			registPhone.innerHTML="<font color='red' size='-1'>手机格式错误</font>";
			tphone.style.border="1px solid red";
			phoneVerify = false;
		}else{
			registPhone.innerHTML="<font color='green' size='-1'>ok</font>";
			tphone.style.border="1px solid #EEE";
			phoneVerify = true;
		}
	}
	
	/** 验证码验证 */
	tcode.onblur = function(){
		var securityCode = frm.code.value;//验证码
		$.ajax({
			type:'post',
			url:'http://localhost:8080/AMG_Mall/SecurityCode.user',//发送数据的地址
			data:{SecurityCode:securityCode},
			dataType:"json",
			success:function(result){
				if(result.code == "false"){
					registSecurityCode.innerHTML="<font color='red' size='-1'>验证码输入有误</font>";
					tcode.style.border="1px solid red";
					changeImage();//验证码输入错误刷新图片
					securityCodeVerify = false;
				}else{
					registSecurityCode.innerHTML="<font color='green' size='-1'>ok</font>";
					tcode.style.border="1px solid #EEE";
					securityCodeVerify = true;
				}
			}
		});
	}
}

function bdtj() {
	if(nameVerify && passwordVerify && repeatPasswordVerify && emailVerify && phoneVerify && securityCodeVerify){
		frm.submit(); //验证通过  提交
	}else{
		alert("请填写完整");
	}
}