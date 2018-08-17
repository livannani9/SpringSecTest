package com.entities;
/**
 * 
 * @author Livan nani
 *
 */
public class University {

	private Integer uid;
	private String uname;
	private String uaddress;

	
	@Override
	public String toString() {
		return "uid=" + uid + ", uname=" + uname + ", uaddress=" + uaddress + "";
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	
}
