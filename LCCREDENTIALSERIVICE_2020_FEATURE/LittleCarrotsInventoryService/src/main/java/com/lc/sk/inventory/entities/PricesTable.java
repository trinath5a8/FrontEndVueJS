package com.lc.sk.inventory.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pricestable")
public class PricesTable implements Serializable{

	@Id
	@Column(name="priceid")
	private long priceId;
	
	@Column(name="mrp")
	private float mrp;
	
	@Column(name="productid")
	private long productId;
	
	@Column(name="lcprice")
	private float lcPrice;
	
	@Column(name="tax")
	private float tax;
	
	@Column(name="sellingprice")
	private float sellingPrice;
	
	@Column(name="finalprice")
	private float finalPrice;

	public PricesTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PricesTable(float mrp, long productId, float lcPrice, float tax, float sellingPrice,
			float finalPrice) {
		super();
		this.mrp = mrp;
		this.productId = productId;
		this.lcPrice = lcPrice;
		this.tax = tax;
		this.sellingPrice = sellingPrice;
		this.finalPrice = finalPrice;
	}

	public long getPriceId() {
		return priceId;
	}

	public void setPriceId(long priceId) {
		this.priceId = priceId;
	}

	public float getMrp() {
		return mrp;
	}

	public void setMrp(float mrp) {
		this.mrp = mrp;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
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

	@Override
	public String toString() {
		return "PricesTable [priceId=" + priceId + ", mrp=" + mrp + ", productId=" + productId + ", lcPrice=" + lcPrice
				+ ", tax=" + tax + ", sellingPrice=" + sellingPrice + ", finalPrice=" + finalPrice + "]";
	}

	
	
	
	
}
