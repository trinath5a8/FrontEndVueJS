package com.lc.sk.inventory.security.beans;

import java.io.Serializable;

public class Sizes implements Serializable {

	private long sizeid;

	private String ageid;

	private String sizeno;

	private String height;

	private String weight;

	private String chest;

	private String waist;

	private String hip;

	public Sizes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sizes(long sizeid, String ageid, String sizeno, String height, String weight, String chest, String waist,
			String hip) {
		super();
		this.sizeid = sizeid;
		this.ageid = ageid;
		this.sizeno = sizeno;
		this.height = height;
		this.weight = weight;
		this.chest = chest;
		this.waist = waist;
		this.hip = hip;
	}

	public long getSizeid() {
		return sizeid;
	}

	public void setSizeid(long sizeid) {
		this.sizeid = sizeid;
	}

	public String getAgeid() {
		return ageid;
	}

	public void setAgeid(String ageid) {
		this.ageid = ageid;
	}

	public String getSizeno() {
		return sizeno;
	}

	public void setSizeno(String sizeno) {
		this.sizeno = sizeno;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getWaist() {
		return waist;
	}

	public void setWaist(String waist) {
		this.waist = waist;
	}

	public String getHip() {
		return hip;
	}

	public void setHip(String hip) {
		this.hip = hip;
	}

	@Override
	public String toString() {
		return "Sizes [sizeid=" + sizeid + ", ageid=" + ageid + ", sizeno=" + sizeno + ", height=" + height
				+ ", weight=" + weight + ", chest=" + chest + ", waist=" + waist + ", hip=" + hip + "]";
	}

}
