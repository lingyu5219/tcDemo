
/**
* Project Name:trainingCenter
* File Name:Position.java
* Package Name:com.center.po.hrmgt
* Date:2016年12月26日下午3:01:48
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.hrmgt;

import java.util.Date;

/**
* ClassName:Position <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月26日 下午3:01:48 <br/>
* @author 李逢杰
* @version
* @see
*/
public class Position {
	
	private int positionId;
	private String positionName;
	private Date createTime;
	private int createBy;
	private String remark;
	
	public int getPositionId() {
	
		return positionId;
	}
	public void setPositionId(int positionId) {
	
		this.positionId = positionId;
	}
	public String getPositionName() {
	
		return positionName;
	}
	public void setPositionName(String positionName) {
	
		this.positionName = positionName;
	}
	public Date getCreateTime() {
	
		return createTime;
	}
	public void setCreateTime(Date createTime) {
	
		this.createTime = createTime;
	}
	public int getCreateBy() {
	
		return createBy;
	}
	public void setCreateBy(int createBy) {
	
		this.createBy = createBy;
	}
	public String getRemark() {
	
		return remark;
	}
	public void setRemark(String remark) {
	
		this.remark = remark;
	}
	

}

