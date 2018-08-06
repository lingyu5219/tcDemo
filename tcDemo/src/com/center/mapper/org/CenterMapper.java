package com.center.mapper.org;

import java.util.List;

import com.center.po.org.Center;
import com.center.po.org.CenterQuery;

public interface CenterMapper {

	public void addCenter(Center center) throws Exception;
	
	public Center queryCenterById(int centerId) throws Exception;
	
	public List<Center> queryCenterList(CenterQuery centerQuery) throws Exception;
	
	public Long queryCenterCount(CenterQuery centerQuery) throws Exception;
	
	public int deleteCenterById(int centerId) throws Exception;
	
	public void modifyCenterById(Center center) throws Exception;
}

