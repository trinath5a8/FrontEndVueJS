/**
 * 
 */
package com.lc.sk.inventory.security.beans;

import java.io.Serializable;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsInventorySecurityService
 * 2020
 */
public class ImagesEntity implements Serializable {
	private long imgid;
	private long productid;
	private String imgurl;
	/**
	 * 
	 */
	public ImagesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param imgid
	 * @param productid
	 * @param imgurl
	 */
	public ImagesEntity(long imgid, long productid, String imgurl) {
		super();
		this.imgid = imgid;
		this.productid = productid;
		this.imgurl = imgurl;
	}
	/**
	 * @return the imgid
	 */
	public long getImgid() {
		return imgid;
	}
	/**
	 * @param imgid the imgid to set
	 */
	public void setImgid(long imgid) {
		this.imgid = imgid;
	}
	/**
	 * @return the productid
	 */
	public long getProductid() {
		return productid;
	}
	/**
	 * @param productid the productid to set
	 */
	public void setProductid(long productid) {
		this.productid = productid;
	}
	/**
	 * @return the imgurl
	 */
	public String getImgurl() {
		return imgurl;
	}
	/**
	 * @param imgurl the imgurl to set
	 */
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	@Override
	public String toString() {
		return "ImagesEntity [imgid=" + imgid + ", productid=" + productid + ", imgurl=" + imgurl + "]";
	}
	
	
}
