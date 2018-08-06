
/**
* Project Name:trainingCenter
* File Name:CenterServiceImpl.java
* Package Name:com.center.service.impl.org
* Date:2016年12月22日下午2:17:19
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.org;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.org.CenterMapper;
import com.center.po.org.Center;
import com.center.po.org.CenterQuery;
import com.center.po.query.DatatablesView;
import com.center.po.system.User;
import com.center.service.org.CenterService;

@Service
public class CenterServiceImpl implements CenterService {

	@Autowired
	private CenterMapper centerMapper;

	@Override
	public void addCenter(Center center, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User)	session.getAttribute("user");
		//动态获取创建人名字 
//		center.setCreateBy(loginUser.getUserId());
		center.setCreateBy(1);
		
		centerMapper.addCenter(center);
		
	}


	@Override
	public DatatablesView<Center> queryCenterList(CenterQuery centerQuery) throws Exception {
		DatatablesView<Center> dataView = new DatatablesView<Center>();
		
		Long count = centerMapper.queryCenterCount(centerQuery);
		List<Center> centerList = centerMapper.queryCenterList(centerQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(centerList);
		return dataView ;
	}

	@Override
	public boolean deleteCenterById(int centerId) throws Exception {
		int affectedRecords = centerMapper.deleteCenterById(centerId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void modifyCenterById(CenterQuery centerQuery) throws Exception {
		centerMapper.modifyCenterById(centerQuery);
		
	}
	
	
//	@Override
//	public ArrayList<Center> queryAll() throws Exception {
//		ArrayList<Center> center =centerMapper.queryAll();
//		return null;
//	}
//	
//	@Override
//	public List<Center> queryCenterByName(String centerName) throws Exception {
//		
//		List<Center> center = centerMapper.queryCenterByName(centerName);
//			
//		return center;
//	}
//
//	@Override
//	public Center updateCenterById(Center center) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int addCenter(Center center) throws Exception {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Center deleteCenterById(int centerId) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

}

