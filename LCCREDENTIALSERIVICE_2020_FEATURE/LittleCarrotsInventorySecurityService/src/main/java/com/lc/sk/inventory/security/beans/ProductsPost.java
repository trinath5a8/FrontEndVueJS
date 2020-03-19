package com.lc.sk.inventory.security.beans;

import java.io.Serializable;

public class ProductsPost implements Serializable{
	
	private long descriptionid;

	private long batchid;

	private String genderid;

	private long catid;

	private long subcatid;

	private long seasonid;

	private long occasionid;

	private String ageid;

	private long materialid;

	private long colorid;

	private long custid;

	private boolean status;

	public ProductsPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductsPost(long descriptionid, long batchid, String genderid, long catid, long subcatid, long seasonid,
			long occasionid, String ageid, long materialid, long colorid, long custid, boolean status) {
		super();
		this.descriptionid = descriptionid;
		this.batchid = batchid;
		this.genderid = genderid;
		this.catid = catid;
		this.subcatid = subcatid;
		this.seasonid = seasonid;
		this.occasionid = occasionid;
		this.ageid = ageid;
		this.materialid = materialid;
		this.colorid = colorid;
		this.custid = custid;
		this.status = status;
	}

	public long getDescriptionid() {
		return descriptionid;
	}

	public void setDescriptionid(long descriptionid) {
		this.descriptionid = descriptionid;
	}

	public long getBatchid() {
		return batchid;
	}

	public void setBatchid(long batchid) {
		this.batchid = batchid;
	}

	public String getGenderid() {
		return genderid;
	}

	public void setGenderid(String genderid) {
		this.genderid = genderid;
	}

	public long getCatid() {
		return catid;
	}

	public void setCatid(long catid) {
		this.catid = catid;
	}

	public long getSubcatid() {
		return subcatid;
	}

	public void setSubcatid(long subcatid) {
		this.subcatid = subcatid;
	}

	public long getSeasonid() {
		return seasonid;
	}

	public void setSeasonid(long seasonid) {
		this.seasonid = seasonid;
	}

	public long getOccasionid() {
		return occasionid;
	}

	public void setOccasionid(long occasionid) {
		this.occasionid = occasionid;
	}

	public String getAgeid() {
		return ageid;
	}

	public void setAgeid(String ageid) {
		this.ageid = ageid;
	}

	public long getMaterialid() {
		return materialid;
	}

	public void setMaterialid(long materialid) {
		this.materialid = materialid;
	}

	public long getColorid() {
		return colorid;
	}

	public void setColorid(long colorid) {
		this.colorid = colorid;
	}

	public long getCustid() {
		return custid;
	}

	public void setCustid(long custid) {
		this.custid = custid;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductsPost [descriptionid, batchid, genderid, catid, subcatid, seasonid, occasionid, ageid, materialid, colorid, custid, status]";
	}
	
	

}
