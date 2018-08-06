
/**
* Project Name:trainingCenter
* File Name:ScoreQuery.java
* Package Name:com.center.po.perfmgt
* Date:2017年1月12日下午7:49:55
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.po.perfmgt;

/**
* ClassName:ScoreQuery <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2017年1月12日 下午7:49:55 <br/>
* @author qian
* @version
* @see
*/
public class ScoreQuery  extends Score{
	private int userId;
	private String stuId;
	private String stuName;
	private String courseName;
	private String batchName;
	private String majorName;
	private String termName;
	private String yearName;
	private int flag;
	public int getUserId() {
	
		return userId;
	}
	public void setUserId(int userId) {
	
		this.userId = userId;
	}
	public String getStuId() {
	
		return stuId;
	}
	public void setStuId(String stuId) {
	
		this.stuId = stuId;
	}
	public String getStuName() {
	
		return stuName;
	}
	public void setStuName(String stuName) {
	
		this.stuName = stuName;
	}
	public String getCourseName() {
	
		return courseName;
	}
	public void setCourseName(String courseName) {
	
		this.courseName = courseName;
	}
	public String getBatchName() {
	
		return batchName;
	}
	public void setBatchName(String batchName) {
	
		this.batchName = batchName;
	}
	public String getMajorName() {
	
		return majorName;
	}
	public void setMajorName(String majorName) {
	
		this.majorName = majorName;
	}
	public String getTermName() {
	
		return termName;
	}
	public void setTermName(String termName) {
	
		this.termName = termName;
	}
	public String getYearName() {
	
		return yearName;
	}
	public void setYearName(String yearName) {
	
		this.yearName = yearName;
	}
	public int getFlag() {
	
		return flag;
	}
	public void setFlag(int flag) {
	
		this.flag = flag;
	}

	
}

