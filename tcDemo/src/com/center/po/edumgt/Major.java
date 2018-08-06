
/**
* Project Name:trainingCenter
* File Name:major.java
* Package Name:com.center.po.edumgt
* Date:2016年12月26日下午2:16:27
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.edumgt;

import com.center.po.query.QueryCondition;

/**
* ClassName:major <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月26日 下午2:16:27 <br/>
* @author ChenZhenQiu
* @version
* @see
*/
public class Major extends QueryCondition{
	private int majorId;
	private String majorName;
	private int createBy;
	private String createByName;
	private String createTime;
	private String remark;
	
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
	public String getCreateByName() {
	
		return createByName;
	}
	public void setCreateByName(String createByName) {
	
		this.createByName = createByName;
	}
	
}

