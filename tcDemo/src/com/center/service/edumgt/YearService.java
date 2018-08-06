package com.center.service.edumgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.center.po.edumgt.Year;
import com.center.po.edumgt.YearQuery;
import com.center.po.query.DatatablesView;

public interface YearService {

	public void addYear(Year year,HttpServletRequest request) throws Exception;

	public List<Year> queryYear(YearQuery yearQuery) throws Exception;
	
	public DatatablesView<Year> queryYearList(YearQuery yearQuery) throws Exception;
	
	public boolean deleteYearById(int yearId) throws Exception;
	
	public boolean modifyYearById(Year year) throws Exception;
}
