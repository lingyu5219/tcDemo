package com.center.po.edumgt;

import com.center.po.assetsmgt.Room;
import com.center.po.hrmgt.Staff;

public class Sybitem {
	private int id;
	private int syllabusId;
	private Major major;
	//private int coursesId;
	private String week;
	private int date;
	private String section;
	private Staff staff;
	//private int teacherId;
	private Room room;
	//private int classroomId;
	//private String remark;
	private int isDel;
	private String display ="";
	
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSyllabusId() {
		return syllabusId;
	}
	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
		this.display = this.display+" "+week;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
/*	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}*/
	public int getIsDel() {
		return isDel;
	}
	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
		this.display = major.getMajorName()+display +" ";
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
		this.display = display + "<br/>" + staff.getStaffName();
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
		this.display = display + "<br/>" + room.getRoomName();
	}
	@Override
	public String toString() {
		return "Sybitem [id=" + id + ", syllabusId=" + syllabusId + ", major=" + major + ", week=" + week + ", date="
				+ date + ", section=" + section + ", staff=" + staff + ", room=" + room + ", isDel=" + isDel + "]";
	}
}
