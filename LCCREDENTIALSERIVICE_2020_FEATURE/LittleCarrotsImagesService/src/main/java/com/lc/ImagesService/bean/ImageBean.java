/**
 * 
 */
package com.lc.ImagesService.bean;

import java.io.File;
import java.io.InputStream;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsImagesService
 * 2020
 */
public class ImageBean {

	private long imgid;
	private long productid;
	private byte[] file;
	/**
	 * 
	 */
	public ImageBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param imgid
	 * @param productid
	 * @param file
	 */
	public ImageBean(long imgid, long productid, byte[] file) {
		super();
		this.imgid = imgid;
		this.productid = productid;
		this.file = file;
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
	 * @return the file
	 */
	public byte[] getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(byte[] file) {
		this.file = file;
	}

	
	
}
