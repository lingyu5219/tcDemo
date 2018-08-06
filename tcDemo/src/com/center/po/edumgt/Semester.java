
/**
* Project Name:trainingCenter
* File Name:Center.java
* Package Name:com.center.po.org
* Date:2016年12月22日下午1:50:57
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.edumgt;

import com.center.po.query.QueryCondition;

/**
* ClassName:Center <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月22日 下午1:50:57 <br/>
* @author niit
* @version
* @see
*/
public class Semester extends QueryCondition {
	
	private int semesterId;
	private String description;
	private int createBy;
	private String createTime;
	private String remark;
	public int getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
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

