

package com.center.po.atndmgt;

import java.util.Date;

/**
 * 
 * @author niit
 *
 */

public class Leave{
	
	private int leaveId;
	private int userId;
	private Date createTime;
	private String remark;
	private Date startTime;
	private Date endTime;
	private String leaveType;
	private String leaveDetl;
	private String leaveAccy;
	public int getLeaveId() {
		return leaveId;
	}
	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public String getLeaveDetl() {
		return leaveDetl;
	}
	public void setLeaveDetl(String leaveDetl) {
		this.leaveDetl = leaveDetl;
	}
	public String getLeaveAccy() {
		return leaveAccy;
	}
	public void setLeaveAccy(String leaveAccy) {
		this.leaveAccy = leaveAccy;
	}
	
	
}
