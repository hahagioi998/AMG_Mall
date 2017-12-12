package com.hafele.bean;
/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月27日 下午2:56:49
* 购物车模块
*/
public class ShoppingCart {
	private int userId;
	private int goodsId;
	private int num;
	private double goodsPrice;
	public ShoppingCart(int userId, int goodsId, int num, double goodsPrice) {
		this.userId = userId;
		this.goodsId = goodsId;
		this.num = num;
		this.goodsPrice = goodsPrice;
	}
	
	public ShoppingCart() {
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	@Override
	public String toString() {
		return "shoppingCart [userId=" + userId + ", goodsId=" + goodsId + ", num="
				+ num + ", goodsPrice=" + goodsPrice + "]";
	}
}
