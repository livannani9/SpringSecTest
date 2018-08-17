/**
 * 
 */
package com.entities;

/**
 * @author Livan Nani
 *
 */
public class Student {

	private Integer stdid;
	private String stdname;
	private String stdcollege;
	private String stdbranch;
	private University university;
	
	
	
	public Student() {

	}
	
	
	public Student(String stdbranch) {

		this.stdbranch = stdbranch;
	}


	@Override
	public String toString() {
		return "stdid=" + stdid + ", stdname=" + stdname + ", stdcollege=" + stdcollege + ", stdbranch="
				+ stdbranch + ", university=" + university + "";
	}
	
	
	public University getUniversity() {
		return university;
	}
	public void setUniversity(University university) {
		this.university = university;
	}
	public Integer getStdid() {
		return stdid;
	}
	public void setStdid(Integer stdid) {
		this.stdid = stdid;
	}
	public String getStdname() {
		return stdname;
	}
	public void setStdname(String stdname) {
		this.stdname = stdname;
	}
	public String getStdcollege() {
		return stdcollege;
	}
	public void setStdcollege(String stdcollege) {
		this.stdcollege = stdcollege;
	}
	public String getStdbranch() {
		return stdbranch;
	}
	public void setStdbranch(String stdbranch) {
		this.stdbranch = stdbranch;
	}
	
}
