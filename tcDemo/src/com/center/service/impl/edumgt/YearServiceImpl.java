package com.center.service.impl.edumgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.edumgt.*;
import com.center.po.edumgt.Year;
import com.center.po.edumgt.YearQuery;
import com.center.po.query.DatatablesView;
import com.center.po.system.User;
import com.center.service.edumgt.YearService;

@Service
public class YearServiceImpl implements YearService {

	@Autowired
	private YearMapper yearMapper;

	@Override
	public List<Year> queryYear(YearQuery yearQuery) throws Exception {
		List<Year> yearList = yearMapper.queryYear(yearQuery);
		return yearList;
	}
	
	@Override
	public DatatablesView<Year> queryYearList(YearQuery yearQuery) throws Exception {
		DatatablesView<Year> dataView = new DatatablesView<Year>();
		
		Long count = yearMapper.queryYearCount(yearQuery);
		List<Year> yearList = yearMapper.queryYearList(yearQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(yearList);
		return dataView ;
	}

	@Override
	public void addYear(Year year, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User)	session.getAttribute("user");
		//动态获取创建人名字 
		year.setCreateBy(loginUser.getUserId());
		
		yearMapper.addYear(year);
		
	}
	
	@Override
	public boolean deleteYearById(int yearId) throws Exception {
		int affectedRecords = yearMapper.deleteYearById(yearId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean modifyYearById(Year year) throws Exception {
		int affectedRecords = yearMapper.modifyYearById(year);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}
}

