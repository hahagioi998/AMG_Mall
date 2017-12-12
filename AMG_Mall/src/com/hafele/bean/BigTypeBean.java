package com.hafele.bean;

import java.util.ArrayList;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��30�� ����2:57:10
* ��Ʒ��������ģ��
*/
public class BigTypeBean {
	private int id;
	private String name; //��������
	private String remarks;  //��������
	private String imgUrl; //����ͼƬ
	private String style; //��ʽ
	private ArrayList<SmallTypeBean> smallTypeList; //С�༯��
	private ArrayList<DetailTypeBean> detailTypeList; //ϸ���༯��
	private ArrayList<GoodsBean> goods; //����ǰʮ��Ʒ
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
