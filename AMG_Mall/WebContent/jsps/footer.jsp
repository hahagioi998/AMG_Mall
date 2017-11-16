<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--Begin 网站底部内容块 Begin-->
<div class="b_btm_bg b_btm_c">
	<div class="b_btm">
		<table border="0"
			style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
			cellspacing="0" cellpadding="0">
			<tr>
				<td width="72"><img src="images/b1.png" width="62" height="62" /></td>
				<td><h2>正品保障</h2> 正品行货 放心购买</td>
			</tr>
		</table>
		<table border="0"
			style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
			cellspacing="0" cellpadding="0">
			<tr>
				<td width="72"><img src="images/b2.png" width="62" height="62" /></td>
				<td><h2>满38包邮</h2> 满38包邮 免运费</td>
			</tr>
		</table>
		<table border="0"
			style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
			cellspacing="0" cellpadding="0">
			<tr>
				<td width="72"><img src="images/b3.png" width="62" height="62" /></td>
				<td><h2>天天低价</h2> 天天低价 畅选无忧</td>
			</tr>
		</table>
		<table border="0"
			style="width: 210px; height: 62px; float: left; margin-left: 75px; margin-top: 30px;"
			cellspacing="0" cellpadding="0">
			<tr>
				<td width="72"><img src="images/b4.png" width="62" height="62" /></td>
				<td><h2>准时送达</h2> 收货时间由你做主</td>
			</tr>
		</table>
	</div>
</div>
<div class="b_nav">
	<dl>
		<dt>
			<a href="#">新手上路</a>
		</dt>
		<dd>
			<a href="#">售后流程</a>
		</dd>
		<dd>
			<a href="#">购物流程</a>
		</dd>
		<dd>
			<a href="#">订购方式</a>
		</dd>
		<dd>
			<a href="#">隐私声明</a>
		</dd>
		<dd>
			<a href="#">推荐分享说明</a>
		</dd>
	</dl>
	<dl>
		<dt>
			<a href="#">配送与支付</a>
		</dt>
		<dd>
			<a href="#">货到付款区域</a>
		</dd>
		<dd>
			<a href="#">配送支付查询</a>
		</dd>
		<dd>
			<a href="#">支付方式说明</a>
		</dd>
	</dl>
	<dl>
		<dt>
			<a href="#">会员中心</a>
		</dt>
		<dd>
			<a href="#">资金管理</a>
		</dd>
		<dd>
			<a href="#">我的收藏</a>
		</dd>
		<dd>
			<a href="#">我的订单</a>
		</dd>
	</dl>
	<dl>
		<dt>
			<a href="#">服务保证</a>
		</dt>
		<dd>
			<a href="#">退换货原则</a>
		</dd>
		<dd>
			<a href="#">售后服务保证</a>
		</dd>
		<dd>
			<a href="#">产品质量保证</a>
		</dd>
	</dl>
	<dl>
		<dt>
			<a href="#">联系我们</a>
		</dt>
		<dd>
			<a href="#">网站故障报告</a>
		</dd>
		<dd>
			<a href="#">购物咨询</a>
		</dd>
		<dd>
			<a href="#">投诉与建议</a>
		</dd>
	</dl>
	<div class="b_tel_bg">
		<a href="#" class="b_sh1">新浪微博</a> <a href="#" class="b_sh2">腾讯微博</a>
		<p>
			服务热线：<br /> <span>400-870-8882</span>
		</p>
	</div>
	<div class="b_er">
		<div class="b_er_c">
			<img src="images/er.png" width="118" height="118" />
		</div>
		<img src="images/ss.png" />
	</div>
</div>
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
<!--End 网站底部内容块 End -->
<!-- 回到顶部代码 开始 -->
<div class="go-top dn" id="go-top">
	<a href="javascript:;" class="uc-2vm"></a>
	<div class="uc-2vm-pop dn">
		<h3 class="title-2wm">用微信扫一扫</h3>
		<div class="logo-2wm-box">
			<img src="images/weixin.jpg" alt="IT技术宅" width="118" height="118">
		</div>
	</div>
	<a href="#" target="_blank" class="feedback"></a> <a
		href="javascript:;" class="go"></a>
</div>
<script>
$(function(){
	$(window).on('scroll',function(){
		var st = $(document).scrollTop();
		if( st>0 ){
			if( $('#main-container').length != 0  ){
				var w = $(window).width(),mw = $('#main-container').width();
				if( (w-mw)/2 > 70 )
					$('#go-top').css({'left':(w-mw)/2+mw+20});
				else{
					$('#go-top').css({'left':'auto'});
				}
			}
			$('#go-top').fadeIn(function(){
				$(this).removeClass('dn');
			});
		}else{
			$('#go-top').fadeOut(function(){
				$(this).addClass('dn');
			});
		}	
	});
	$('#go-top .go').on('click',function(){
		$('html,body').animate({'scrollTop':0},500);
	});

	$('#go-top .uc-2vm').hover(function(){
		$('#go-top .uc-2vm-pop').removeClass('dn');
	},function(){
		$('#go-top .uc-2vm-pop').addClass('dn');
	});
});
</script>
