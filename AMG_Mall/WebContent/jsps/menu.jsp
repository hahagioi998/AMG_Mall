<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!--Begin Menu Begin-->
<div class="menu_bg">
	<div class="menu">
		<!--Begin 商品分类详情 Begin-->
		<div class="nav">
			<div class="nav_t">全部商品分类</div>
			<div class="leftNav" style="display: none;">
				<ul>
					<!-- 商品分类循环go -->
					<c:forEach items="${floor }" var="bigType">
						<li>
							<div class="fj">
								<span class="n_img"><span></span><img
									src="${bigType.imgUrl }" /></span> <span class="fl"><a
									href="search?bid=${bigType.id }&p=1" target="_blank"></a>${bigType.name }</span>
							</div>
							<div class="zj" style="top:${bigType.remarks };">
								<div class="zj_l">
									<c:forEach items="${bigType.smallTypeList }" var="smallType">
										<div class="zj_l_c">
											<h2>
												<a href="search?sid=${smallType.id }&p=1" target="_blank">${smallType.name }</a>
											</h2>
											<c:forEach items="${smallType.detailTypeList }"
												var="detailType">
												<a href="search?did=${detailType.id }&p=1" target="_blank">${detailType.name}</a>|
											</c:forEach>
										</div>
									</c:forEach>
								</div>
								<div class="zj_r">
									<a href="#"><img src="images/n_img1.jpg" width="236"
										height="200" /></a> <a href="#"><img src="images/n_img2.jpg"
										width="236" height="200" /></a>
								</div>
							</div>
						</li>
					</c:forEach>
					<!-- 商品分类循环end -->
				</ul>
			</div>
		</div>
		<!--End 商品分类详情 End-->
		<ul class="menu_r">
			<li><a href="index.jsp">首页</a></li>
			<li><a href="Food.html">美食</a></li>
			<li><a href="Fresh.html">生鲜</a></li>
			<li><a href="HomeDecoration.html">家居</a></li>
			<li><a href="SuitDress.html">女装</a></li>
			<li><a href="MakeUp.html">美妆</a></li>
			<li><a href="Digital.html">数码</a></li>
			<li><a href="GroupBuying.html">团购</a></li>
		</ul>
		<div class="m_ad">双十二狂欢！</div>
	</div>
</div>
<!--End Menu End-->
