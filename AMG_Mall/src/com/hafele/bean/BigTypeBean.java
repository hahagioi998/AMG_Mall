package com.hafele.bean;

import java.util.ArrayList;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月30日 下午2:57:10
* 商品大类数据模型
*/
public class BigTypeBean {
	private int id;
	private String name; //大类名称
	private String remarks;  //大类描述
	private String imgUrl; //大类图片
	private String style; //样式
	private ArrayList<SmallTypeBean> smallTypeList; //小类集合
	private ArrayList<DetailTypeBean> detailTypeList; //细节类集合
	private ArrayList<GoodsBean> goods; //最新前十商品
	public BigTypeBean(String name, String remarks) {
		this.name = name;
		this.remarks = remarks;
	}
	public BigTypeBean() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public ArrayList<SmallTypeBean> getSmallTypeList() {
		return smallTypeList;
	}
	public void setSmallTypeList(ArrayList<SmallTypeBean> smallTypeList) {
		this.smallTypeList = smallTypeList;
	}
	public ArrayList<DetailTypeBean> getDetailTypeList() {
		return detailTypeList;
	}
	public void setDetailTypeList(ArrayList<DetailTypeBean> detailTypeList) {
		this.detailTypeList = detailTypeList;
	}
	public ArrayList<GoodsBean> getGoods() {
		return goods;
	}
	public void setGoods(ArrayList<GoodsBean> goods) {
		this.goods = goods;
	}
}
