package com.center.vo.edumgt;

import com.center.po.edumgt.Sybitem;

/**
 * 课程表每一行
 * @author 奡
 *
 */
public class Section {
	private int id;
	private String section;
	private Sybitem monday = new Sybitem();
	private Sybitem tuesday = new Sybitem();
	private Sybitem wednesday = new Sybitem();
	private Sybitem thursday = new Sybitem();
	private Sybitem friday = new Sybitem();
	private Sybitem saturday = new Sybitem();
	private Sybitem sunday = new Sybitem();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public Sybitem getMonday() {
		return monday;
	}
	public void setMonday(Sybitem monday) {
		if(this.monday.getDisplay()!=""){
			this.monday.setDisplay(this.monday.getDisplay()+"<br/><br/>"+monday.getDisplay());
		}else{
			this.monday = monday;
		}
	}
	public Sybitem getTuesday() {
		return tuesday;
	}
	public void setTuesday(Sybitem tuesday) {
		if(this.tuesday.getDisplay()!=""){
			this.tuesday.setDisplay(this.tuesday.getDisplay()+"<br/><br/>"+tuesday.getDisplay());
		}else{
			this.tuesday = tuesday;
		}
	}
	public Sybitem getWednesday() {
		return wednesday;
	}
	public void setWednesday(Sybitem wednesday) {
		if(this.wednesday.getDisplay()!=""){
			this.wednesday.setDisplay(this.wednesday.getDisplay()+"<br/><br/>"+wednesday.getDisplay());
		}else{
			this.wednesday = wednesday;
		}
	}
	public Sybitem getThursday() {
		return thursday;
	}
	public void setThursday(Sybitem thursday) {
		if(this.thursday.getDisplay()!=""){
			this.thursday.setDisplay(this.thursday.getDisplay()+"<br/><br/>"+thursday.getDisplay());
		}else{
			this.thursday = thursday;
		}
	}
	public Sybitem getFriday() {
		return friday;
	}
	public void setFriday(Sybitem friday) {
		if(this.friday.getDisplay()!=""){
			this.friday.setDisplay(this.friday.getDisplay()+"<br/><br/>"+friday.getDisplay());
		}else{
			this.friday = friday;
		}
	}
	public Sybitem getSaturday() {
		return saturday;
	}
	public void setSaturday(Sybitem saturday) {
		if(this.saturday.getDisplay()!=""){
			this.saturday.setDisplay(this.saturday.getDisplay()+"<br/><br/>"+friday.getDisplay());
		}else{
			this.saturday = saturday;
		}
	}
	public Sybitem getSunday() {
		return sunday;
	}
	public void setSunday(Sybitem sunday) {
		if(this.sunday.getDisplay()!=""){
			this.sunday.setDisplay(this.sunday.getDisplay()+"<br/><br/>"+sunday.getDisplay());
		}else{
			this.sunday = sunday;
		}
	}
	@Override
	public String toString() {
		return "Section [section=" + section + ", monday=" + monday + ", tuesday=" + tuesday + ", wednesday="
				+ wednesday + ", thursday=" + thursday + ", friday=" + friday + ", saturday=" + saturday + ", sunday="
				+ sunday + "]";
	}
}
