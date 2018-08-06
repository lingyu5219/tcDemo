package com.center.po.edumgt;

import com.center.po.query.QueryCondition;

public class Year extends QueryCondition {

	private int yearId;
	private String yearTitle;
	private int createBy;
	private String createByName;
	private String createTime;
	private String remark;
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
