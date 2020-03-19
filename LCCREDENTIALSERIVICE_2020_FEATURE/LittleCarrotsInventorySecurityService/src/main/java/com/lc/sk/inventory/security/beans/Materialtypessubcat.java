package com.lc.sk.inventory.security.beans;

import java.io.Serializable;

public class Materialtypessubcat implements Serializable{
	
	private long METERIALID;
	private String METERIAL_NAME;
	private String DESCRIPTION;
	private String OCCASSION;
	private String OCCASSION_SUBCATEGORY;
	private String SEASON;
	private String SEASON_SUBCATEGORY;
	private String CATEGORY;
	
	
	public Materialtypessubcat() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Materialtypessubcat(long mETERIALID, String mETERIAL_NAME, String dESCRIPTION, String oCCASSION,
			String oCCASSION_SUBCATEGORY, String sEASON, String sEASON_SUBCATEGORY, String cATEGORY) {
		super();
		METERIALID = mETERIALID;
		METERIAL_NAME = mETERIAL_NAME;
		DESCRIPTION = dESCRIPTION;
		OCCASSION = oCCASSION;
		OCCASSION_SUBCATEGORY = oCCASSION_SUBCATEGORY;
		SEASON = sEASON;
		SEASON_SUBCATEGORY = sEASON_SUBCATEGORY;
		CATEGORY = cATEGORY;
	}


	public long getMETERIALID() {
		return METERIALID;
	}


	public void setMETERIALID(long mETERIALID) {
		METERIALID = mETERIALID;
	}


	public String getMETERIAL_NAME() {
		return METERIAL_NAME;
	}


	public void setMETERIAL_NAME(String mETERIAL_NAME) {
		METERIAL_NAME = mETERIAL_NAME;
	}


	public String getDESCRIPTION() {
		return DESCRIPTION;
	}


	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}


	public String getOCCASSION() {
		return OCCASSION;
	}


	public void setOCCASSION(String oCCASSION) {
		OCCASSION = oCCASSION;
	}


	public String getOCCASSION_SUBCATEGORY() {
		return OCCASSION_SUBCATEGORY;
	}


	public void setOCCASSION_SUBCATEGORY(String oCCASSION_SUBCATEGORY) {
		OCCASSION_SUBCATEGORY = oCCASSION_SUBCATEGORY;
	}


	public String getSEASON() {
		return SEASON;
	}


	public void setSEASON(String sEASON) {
		SEASON = sEASON;
	}


	public String getSEASON_SUBCATEGORY() {
		return SEASON_SUBCATEGORY;
	}


	public void setSEASON_SUBCATEGORY(String sEASON_SUBCATEGORY) {
		SEASON_SUBCATEGORY = sEASON_SUBCATEGORY;
	}


	public String getCATEGORY() {
		return CATEGORY;
	}


	public void setCATEGORY(String cATEGORY) {
		CATEGORY = cATEGORY;
	}


	@Override
	public String toString() {
		return "Materialtypessubcat [METERIALID=" + METERIALID + ", METERIAL_NAME=" + METERIAL_NAME + ", DESCRIPTION="
				+ DESCRIPTION + ", OCCASSION=" + OCCASSION + ", OCCASSION_SUBCATEGORY=" + OCCASSION_SUBCATEGORY
				+ ", SEASON=" + SEASON + ", SEASON_SUBCATEGORY=" + SEASON_SUBCATEGORY + ", CATEGORY=" + CATEGORY + "]";
	}




	
	
	
	
	

}
