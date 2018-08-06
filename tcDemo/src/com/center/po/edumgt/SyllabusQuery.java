package com.center.po.edumgt;

import com.center.po.query.QueryCondition;

public class SyllabusQuery extends QueryCondition {
	private String tempYear;
	private String tempSylQuarter;
	private String tempBatch;
	private String query;
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public String getTempYear() {
		return tempYear;
	}
	public void setTempYear(String tempYear) {
		this.tempYear = tempYear;
	}
	public String getTempSylQuarter() {
		return tempSylQuarter;
	}
	public void setTempSylQuarter(String tempSylQuarter) {
		this.tempSylQuarter = tempSylQuarter;
	}
	public String getTempBatch() {
		return tempBatch;
	}
	public void setTempBatch(String tempBatch) {
		this.tempBatch = tempBatch;
	}
	@Override
	public String toString() {
		return "SyllabusQuery [tempYear=" + tempYear + ", tempSylQuarter=" + tempSylQuarter + ", tempBatch=" + tempBatch
				+ ", query=" + query + "]";
	}
}
