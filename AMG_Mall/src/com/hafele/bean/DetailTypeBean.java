package com.hafele.bean;
/**
* @author Dragon Wen E-mail:18475536452@163.com
* @version ����ʱ�䣺2017��12��8�� ����10:38:00
* ��Ʒϸ����ģ������
*/
public class DetailTypeBean {
	private int id;
	private String name;
	private int detailTypeId;
	private String remarks;
	public DetailTypeBean() {
	}
	public DetailTypeBean(String name, int detailTypeId, String remarks) {
		this.name = name;
		this.detailTypeId = detailTypeId;
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
	public int getDetailTypeId() {
		return detailTypeId;
	}
	public void setDetailTypeId(int detailTypeId) {
		this.detailTypeId = detailTypeId;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
