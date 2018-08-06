
/**
* Project Name:trainingCenter
* File Name:PositionQuery.java
* Package Name:com.center.po.hrmgt
* Date:2017年1月10日下午6:58:07
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.po.hrmgt;

import com.center.po.query.QueryCondition;

/**
* ClassName:PositionQuery <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2017年1月10日 下午6:58:07 <br/>
* @author 李逢杰
* @version
* @see
*/
public class PositionQuery extends QueryCondition {
	
	private String idname;
	
	private String createTimeBegin;
	private String createTimeEnd;

	public String getIdname() {
		
			return idname;
	}

	public void setIdname(String idname) {
		
			this.idname = idname;
	}

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

