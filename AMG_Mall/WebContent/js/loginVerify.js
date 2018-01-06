/**
 * 登录验证
 */
nameVerify = false;//用户名验证
passwordVerify = false;//密码验证
securityCodeVerify = false;//验证码验证
window.onload=function(){
	/** 用户名验证 */
	inputusername.onblur=function(){
		userNameFormat = /^[a-zA-z][a-zA-Z0-9_]{3,15}$/; //用户名正则表达式
		var username=inputusername.value; //昵称
		if(!userNameFormat.exec(username)){
			loginUser.innerHTML = "<font color='red' size='-1'>格式有误</font>";
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
				if(result.success == "false"){
					loginUser.innerHTML="";
					inputusername.style.border="1px solid #EEE";
					nameVerify = true;
				}else{
					loginUser.innerHTML="<font color='red' size='-1'>用户名不存在</font>";
					inputusername.style.border="1px solid red";
					nameVerify = false;
				}
			}
		});
	}
	
	/** 密码验证 */
	inputpassword.onblur=function(){
		if(inputpassword.value!=""){
			loginPassword.innerHTML="";
			inputpassword.style.border="1px solid #EEE";
			passwordVerify = true;
		}else{
			loginPassword.innerHTML="<font color='red' size='-1'>请输入密码</font>";
			inputpassword.style.border="1px solid red";
			passwordVerify = false;
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
					loginSecurityCode.innerHTML="<font color='red' size='-1'>验证码输入有误</font>";
					tcode.style.border="1px solid red";
					changeImage();//验证码输入错误刷新图片
					securityCodeVerify = false;
				}else{
					loginSecurityCode.innerHTML="<font color='green' size='-1'>ok</font>";
					tcode.style.border="1px solid #EEE";
					securityCodeVerify = true;
				}
			}
		});
	}
}

function bdtj(){
	if(nameVerify && passwordVerify && securityCodeVerify){
		frm.submit(); //验证通过  提交
	}else{
		layer.open({
			title: '提示'
				,content: '请填写完整'
		});  
//		alert("请填写完整");
	}
}
