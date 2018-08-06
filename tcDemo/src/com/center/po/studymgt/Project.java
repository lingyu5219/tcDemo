package com.center.po.studymgt;

import com.center.po.query.QueryCondition;

public class Project extends QueryCondition {
	
	private int projectId;
	
	private String projectName;
	
	private String projectUrl;
	
	private String projectFile;
	
	private String projectFileName;
	
	private int projectFileSize;
	
	private String createTime;
	
	private int createBy;
	
	private String remark;
	
	
	public int getProjectId() {
	
		return projectId;
	}
	public void setProjectId(int projectId) {
	
		this.projectId = projectId;
	}
	public String getProjectName() {
	
		return projectName;
	}
	public void setProjectName(String projectName) {
	
		this.projectName = projectName;
	}
	public String getProjectUrl() {
	
		return projectUrl;
	}
	public void setProjectUrl(String projectUrl) {
	
		this.projectUrl = projectUrl;
	}
	public String getProjectFile() {
	
		return projectFile;
	}
	public void setProjectFile(String projectFile) {
	
		this.projectFile = projectFile;
	}
	public String getProjectFileName() {
	
		return projectFileName;
	}
	public void setProjectFileName(String projectFileName) {
	
		this.projectFileName = projectFileName;
	}
	public int getProjectFileSize() {
	
		return projectFileSize;
	}
	public void setProjectFileSize(int projectFileSize) {
	
		this.projectFileSize = projectFileSize;
	}
	public String getCreateTime() {
	
		return createTime;
	}
	public void setCreateTime(String createTime) {
	
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
