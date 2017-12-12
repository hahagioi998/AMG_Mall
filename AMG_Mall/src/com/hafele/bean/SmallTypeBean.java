package com.hafele.bean;

import java.util.ArrayList;

/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��11��30�� ����3:17:25
* ��ƷС������ģ��
*/
public class SmallTypeBean {
	private int id;
	private String name;
	private int bigTypeId;
	private String remarks;
	private ArrayList<DetailTypeBean> detailTypeList; //ϸ���༯��
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
