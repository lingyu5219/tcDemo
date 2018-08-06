package com.center.po.edumgt;

import java.util.Date;
import java.util.List;

public class Syllabus {
	private int id;
	private int year;
	private Year yearObj;
	private String sylQuarter;
	private Semester semester;
	private Batch batch;
	//private int classId;//TODO 合适的时候换成class类 代码中有用到classId也要记得换
	private Date beginTime;
	private Date endTime;
	private int isDel;
	List<Sybitem> sybitems;
	public Year getYearObj() {
		return yearObj;
	}
	public void setYearObj(Year yearObj) {
		this.yearObj = yearObj;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public List<Sybitem> getSybitems() {
		return sybitems;
	}
	public void setSybitems(List<Sybitem> sybitems) {
		this.sybitems = sybitems;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSylQuarter() {
		return sylQuarter;
	}
	public void setSylQuarter(String sylQuarter) {
		this.sylQuarter = sylQuarter;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	@Override
	public String toString() {
		return "Syllabus [id=" + id + ", year=" + year + ", sylQuarter=" + sylQuarter + ", batch=" + batch
				+ ", beginTime=" + beginTime + ", endTime=" + endTime + ", isDel=" + isDel + ", sybitems=" + sybitems
				+ "]";
	}
}
