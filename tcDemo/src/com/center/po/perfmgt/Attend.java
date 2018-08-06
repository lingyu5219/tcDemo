
/**
* Project Name:trainingCenter
* File Name:Attend.java
* Package Name:com.center.po.perfmgt
* Date:2016年12月23日下午9:57:53
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.perfmgt;

import com.center.po.query.QueryCondition;

/**
 * ClassName:Attend <br/>
 * Function: 考勤成绩实体类 <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月23日 下午9:57:53 <br/>
 * 
 * @author 钱兆瑞
 * @version
 * @see
 */
public class Attend extends QueryCondition{
	private String time1;
	private String time2;
	private int userId;
	private String stuName;
	private String stuNo;
	private String yearName;
	private String majorName;
	private String batchName;
	private int signinDays;
	private int lateDays;
	private int leaveDays;
	private int totalDays;
	private int flag;
	public int getUserId() {
	
		return userId;
	}
	public void setUserId(int userId) {
	
		this.userId = userId;
	}
	public String getStuName() {
	
		return stuName;
	}
	public void setStuName(String stuName) {
	
		this.stuName = stuName;
	}
	public String getStuNo() {
	
		return stuNo;
	}
	public void setStuNo(String stuNo) {
	
		this.stuNo = stuNo;
	}
	public String getYearName() {
	
		return yearName;
	}
	public void setYearName(String yearName) {
	
		this.yearName = yearName;
	}
	public String getMajorName() {
	
		return majorName;
	}
	public void setMajorName(String majorName) {
	
		this.majorName = majorName;
	}
	public String getBatchName() {
	
		return batchName;
	}
	public void setBatchName(String batchName) {
	
		this.batchName = batchName;
	}
	public int getSigninDays() {
	
		return signinDays;
	}
	public void setSigninDays(int signinDays) {
	
		this.signinDays = signinDays;
	}

	
	public int getLeaveDays() {
		
			return leaveDays;
	}
	public void setLeaveDays(int leaveDays) {
		
			this.leaveDays = leaveDays;
	}
	public int getTotalDays() {
		
			return totalDays;
	}
	public void setTotalDays(int totalDays) {
		
			this.totalDays = totalDays;
	}
	public String getTime1() {
		
			return time1;
	}
	public void setTime1(String time1) {
		
			this.time1 = time1;
	}
	public String getTime2() {
		
			return time2;
	}
	public void setTime2(String time2) {
		
			this.time2 = time2;
	}
	public int getLateDays() {
		
			return lateDays;
	}
	public void setLateDays(int lateDays) {
		
			this.lateDays = lateDays;
	}
	public int getFlag() {
		
			return flag;
	}
	public void setFlag(int flag) {
		
			this.flag = flag;
	}
	
}
