package com.center.po.jobmgt;

import java.util.Date;

public class Company {
	  private int coId,coTreament,stuId;
	  private String coName,coPosn,coDescribe,remark,coLoc,createBy;
	  private Date createTime;
	public int getCoId() {
		return coId;
	}
	public void setCoId(int coId) {
		this.coId = coId;
	}
	public int getCoTreament() {
		return coTreament;
	}
	public void setCoTreament(int coTreament) {
		this.coTreament = coTreament;
	}
	public String getCoLoc() {
		return coLoc;
	}
	public void setCoLoc(String coLoc) {
		this.coLoc = coLoc;
	}
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getCoName() {
		return coName;
	}
	public void setCoName(String coName) {
		this.coName = coName;
	}
	public String getCoPosn() {
		return coPosn;
	}
	public void setCoPosn(String coPosn) {
		this.coPosn = coPosn;
	}
	public String getCoDescribe() {
		return coDescribe;
	}
	public void setCoDescribe(String coDescribe) {
		this.coDescribe = coDescribe;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setCreateBy(int i) {
		// TODO Auto-generated method stub
		
	}
	  
}
