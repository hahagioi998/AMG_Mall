package com.hafele.bean;

import java.util.ArrayList;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version 创建时间：2017年11月30日 下午3:17:25
* 商品小类数据模型
*/
public class SmallTypeBean {
	private int id;
	private String name;
	private int bigTypeId;
	private String remarks;
	private ArrayList<DetailTypeBean> detailTypeList; //细节类集合
	public SmallTypeBean() {
	}
	public SmallTypeBean(String name, int bigTypeId, String remarks) {
		this.name = name;
		this.bigTypeId = bigTypeId;
		this.remarks = remarks;
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
	public int getBigTypeId() {
		return bigTypeId;
	}
	public void setBigTypeId(int bigTypeId) {
		this.bigTypeId = bigTypeId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public ArrayList<DetailTypeBean> getDetailTypeList() {
		return detailTypeList;
	}
	public void setDetailTypeList(ArrayList<DetailTypeBean> detailTypeList) {
		this.detailTypeList = detailTypeList;
	}
	
}
