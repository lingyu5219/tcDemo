package com.center.mapper.edumgt;

import java.util.List;

import com.center.po.edumgt.Year;
import com.center.po.edumgt.YearQuery;

public interface YearMapper {
	
	public void addYear(Year year) throws Exception;
	
	public List<Year> queryYear(YearQuery yearQuery) throws Exception;
	
	public List<Year> queryYearList(YearQuery yearQuery) throws Exception;
	
	public Long queryYearCount(YearQuery yearQuery) throws Exception;
	
	public int deleteYearById(int yearId) throws Exception;
	
	public int modifyYearById(Year year) throws Exception;
}
