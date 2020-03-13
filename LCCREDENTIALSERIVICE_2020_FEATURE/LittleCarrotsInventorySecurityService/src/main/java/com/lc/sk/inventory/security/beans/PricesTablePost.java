package com.lc.sk.inventory.security.beans;

import java.io.Serializable;

public class PricesTablePost implements Serializable{


	private float mrp;

	private long productid;

	private float lcPrice;

	private float tax;

	private float sellingPrice;

	private float finalPrice;

	public PricesTablePost() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PricesTablePost(float mrp, long productid, float lcPrice, float tax, float sellingPrice, float finalPrice) {
		super();
		this.mrp = mrp;
		this.productid = productid;
		this.lcPrice = lcPrice;
		this.tax = tax;
		this.sellingPrice = sellingPrice;
		this.finalPrice = finalPrice;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public float getLcPrice() {
		return lcPrice;
	}

	public void setLcPrice(float lcPrice) {
		this.lcPrice = lcPrice;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public float getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(float finalPrice) {
		this.finalPrice = finalPrice;
	}


	public String toString1() {
		return "PricesTablePost [mrp, productid, lcPrice, tax, sellingPrice, finalPrice]";
	}

	@Override
	public String toString() {
		return "PricesTablePost [mrp=" + mrp + ", productid=" + productid + ", lcPrice=" + lcPrice + ", tax=" + tax
				+ ", sellingPrice=" + sellingPrice + ", finalPrice=" + finalPrice + "]";
	}

	
}
