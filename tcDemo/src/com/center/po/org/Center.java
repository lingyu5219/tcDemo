
/**
* Project Name:trainingCenter
* File Name:Center.java
* Package Name:com.center.po.org
* Date:2016年12月22日下午1:50:57
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.org;

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
public class Center extends QueryCondition {
	private int centerId;
	private String centerName;
	private String centerAddress;
	
	private String createTime;
	private String remark;
	private int createBy;
	
	public int getCenterId() {
		return centerId;
	}
	public void setCenterId(int centerId) {
		this.centerId = centerId;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	
	
}

