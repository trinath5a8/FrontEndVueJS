/**
 * 
 */
package com.lc.ImagesService.bean;

/**
 * @author Mastanvali Shaik
 * LittleCarrotsImagesService
 * 2020
 */
public class ResponseBean {

	private String message;
	private int responsecode;
	private long timestamp;
	/**
	 * 
	 */
	public ResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param message
	 * @param responsecode
	 * @param timestamp
	 */
	public ResponseBean(String message, int responsecode, long timestamp) {
		super();
		this.message = message;
		this.responsecode = responsecode;
		this.timestamp = timestamp;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the responsecode
	 */
	public int getResponsecode() {
		return responsecode;
	}
	/**
	 * @param responsecode the responsecode to set
	 */
	public void setResponsecode(int responsecode) {
		this.responsecode = responsecode;
	}
	/**
	 * @return the timestamp
	 */
	public long getTimestamp() {
		return timestamp;
	}
	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ResponseBean [message=" + message + ", responsecode=" + responsecode + ", timestamp=" + timestamp + "]";
	}
	
	
}
