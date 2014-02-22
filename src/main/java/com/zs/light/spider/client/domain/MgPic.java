package com.zs.light.spider.client.domain;

import java.io.Serializable;
import java.util.Date;

public class MgPic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4275390859320676769L;
	
	private int idmg98Pics;
	
	private String address;
	
	private String filename;
	
	private String status;
	
	private Date updateDate;

	public int getIdmg98Pics() {
		return idmg98Pics;
	}

	public void setIdmg98Pics(int idmg98Pics) {
		this.idmg98Pics = idmg98Pics;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "mgPic [idmg98Pics=" + idmg98Pics + ", address=" + address
				+ ", filename=" + filename + ", status=" + status
				+ ", updateDate=" + updateDate + "]";
	}
	
}