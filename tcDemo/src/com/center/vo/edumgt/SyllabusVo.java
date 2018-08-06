package com.center.vo.edumgt;

import java.util.Date;
import java.util.List;

import com.center.po.edumgt.Batch;

/**
 * 课程表实体
 * @author 奡
 *
 */
public class SyllabusVo {
	private int id;
	private int year;
	private String sylQuarter;
	private Date beginTime;
	private Date endTime;
	private int isDel;
	private String section;
	private Batch batch;
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
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
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	@Override
	public String toString() {
		return "SyllabusVo [id=" + id + ", year=" + year + ", sylQuarter=" + sylQuarter + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + ", isDel=" + isDel + ", section=" + section 
				+ ", batch=" + batch + "]";
	}
}
