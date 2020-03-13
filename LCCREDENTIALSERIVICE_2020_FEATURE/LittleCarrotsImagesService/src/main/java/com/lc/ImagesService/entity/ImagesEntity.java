package com.lc.ImagesService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;


@Entity
@Table(name="images")
public class ImagesEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="imgid")
	private long imgid;
	
	@Column(name="productid")
	private long productid;
	
	@Column(name="imageurl")
	private String imgurl;

	public ImagesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImagesEntity(long productid, String imgurl) {
		super();
		this.productid = productid;
		this.imgurl = imgurl;
	}

	public long getImgid() {
		return imgid;
	}

	public void setImgid(long imgid) {
		this.imgid = imgid;
	}

	public long getProductid() {
		return productid;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "ImagesEntity [imgid=" + imgid + ", productid=" + productid + ", imgurl=" + imgurl + "]";
	}

	
	
}
