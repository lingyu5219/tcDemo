package com.center.po.edumgt;

import java.util.Date;

import com.center.po.query.QueryCondition;
/**
 * 
* ClassName: Batch <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2017年3月15日 下午12:36:47 <br/>
*
* @author Tony
* @version
 */
public class Batch extends QueryCondition{
	private int batchId;
	private int yearId;
	private String yearTitle;
	private int majorId;
	private String majorName;
	private String batchName;
	private int createBy;
	private String createByName;
	private String createTime;
	private String remark;
	public int getBatchId() {
	
		return batchId;
	}
	public void setBatchId(int batchId) {
	
		this.batchId = batchId;
	}
	public int getYearId() {
	
		return yearId;
	}
	public void setYearId(int yearId) {
	
		this.yearId = yearId;
	}
	public String getYearTitle() {
	
		return yearTitle;
	}
	public void setYearTitle(String yearTitle) {
	
		this.yearTitle = yearTitle;
	}
	public int getMajorId() {
	
		return majorId;
	}
	public void setMajorId(int majorId) {
	
		this.majorId = majorId;
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
	public int getCreateBy() {
	
		return createBy;
	}
	public void setCreateBy(int createBy) {
	
		this.createBy = createBy;
	}
	public String getCreateByName() {
	
		return createByName;
	}
	public void setCreateByName(String createByName) {
	
		this.createByName = createByName;
	}
	
	public String getCreateTime() {
	
		return createTime;
	}
	public void setCreateTime(String createTime) {
	
		this.createTime = createTime;
	}
	public String getRemark() {
	
		return remark;
	}
	public void setRemark(String remark) {
	
		this.remark = remark;
	}
	
}
