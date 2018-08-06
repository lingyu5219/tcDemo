
/**
* Project Name:trainingCenter
* File Name:StudentQuery.java
* Package Name:com.center.po.stumgt
* Date:2016年12月27日上午11:39:23
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.stumgt;
/**
* ClassName:StudentQuery <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月27日 上午11:39:23 <br/>
* @author ChenZhenQiu
* @version
* @see
*/
public class StudentQuery extends Student{
	
	private String createTimeBegin;
	private String createTimeEnd;
	
	
	public String getCreateTimeBegin() {
		return createTimeBegin;
	}
	public void setCreateTimeBegin(String createTimeBegin) {
		this.createTimeBegin = createTimeBegin;
	}
	public String getCreateTimeEnd() {
		return createTimeEnd;
	}
	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}
}

