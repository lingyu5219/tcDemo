/**
* Project Name:trainingCenter
* File Name:SignIn.java
* Package Name:com.center.po.atndmgt
* Date:2016年12月23日下午1:22:36
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.po.atndmgt;

import java.util.Date;

/**
* ClassName:SignIn <br/>
* Function: TODO ADD 签到记录 <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午1:22:36 <br/>
* @author donghao
* @version
* @see
*/
public class SignIn {
	private int signInId;
	private int userId;
	private String signInIp;
	private String signInHostName;
	private String createTime;
	private String remark;
	public int getSignInId() {
	
		return signInId;
	}
	public void setSignInId(int signInId) {
	
		this.signInId = signInId;
	}
	public int getUserId() {
	
		return userId;
	}
	public void setUserId(int userId) {
	
		this.userId = userId;
	}
	public String getSignInIp() {
	
		return signInIp;
	}
	public void setSignInIp(String signInIp) {
	
		this.signInIp = signInIp;
	}
	public String getSignInHostName() {
	
		return signInHostName;
	}
	public void setSignInHostName(String signInHostName) {
	
		this.signInHostName = signInHostName;
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

