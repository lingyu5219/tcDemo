
/**
* Project Name:trainingCenter
* File Name:Resume.java
* Package Name:com.center.po.jobmgt
* Date:2016年12月23日下午3:07:54
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.jobmgt;

import java.util.Date;

import com.center.po.query.QueryCondition;

/**
* ClassName:Resume <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午3:07:54 <br/>
* @author niit
* @version
* @see
*/
public class Resume extends QueryCondition {
	private int resumeId,stuId;
	private String resumeDescribe,createBy,remark;
	private String createTime;
	public int getResumeId() {
	
		return resumeId;
	}
	public void setResumeId(int resumeId) {
	
		this.resumeId = resumeId;
	}
	public int getStuId() {
	
		return stuId;
	}
	public void setStuId(int stuId) {
	
		this.stuId = stuId;
	}
	public String getResumeDescribe() {
	
		return resumeDescribe;
	}
	public void setResumeDescribe(String resumeDescribe) {
	
		this.resumeDescribe = resumeDescribe;
	}
	public String getCreateBy() {
	
		return createBy;
	}
	public void setCreateBy(String createBy) {
	
		this.createBy = createBy;
	}
	public String getRemark() {
	
		return remark;
	}
	public void setRemark(String remark) {
	
		this.remark = remark;
	}
	public String getCreateTime() {
	
		return createTime;
	}
	public void setCreateTime(String createTime) {
	
		this.createTime = createTime;
	}
	
}

