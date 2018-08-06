package com.center.service.impl.edumgt;

/**
* Project Name:trainingCenter
* File Name:MajorService.java
* Package Name:com.center.service.impl.edumgt
* Date:2016年12月26日下午2:35:19
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.edumgt.MajorMapper;
import com.center.po.edumgt.Major;
import com.center.po.edumgt.MajorQuery;
import com.center.po.query.DatatablesView;
import com.center.po.system.User;
import com.center.service.edumgt.MajorService;

/**
 * ClassName:MajorService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午2:35:19 <br/>
 * 
 * @author ChenZhenQiu
 * @version
 * @see
 */
@Service
public class MajorServiceImpl implements MajorService {
	@Autowired
	private MajorMapper majorMapper;

	@Override
	public List<Major> queryMajor(MajorQuery majorQuery) throws Exception {
		
		List<Major> majorList = majorMapper.queryMajor(majorQuery);
		return majorList;
	}
	
	@Override
	public DatatablesView<Major> queryMajorList(MajorQuery majorQuery) throws Exception {
		DatatablesView<Major> dataView = new DatatablesView<Major>();
		
		List<Major> majorList = majorMapper.queryMajorList(majorQuery);
		Long count = majorMapper.queryMajorCount(majorQuery);
		dataView.setData(majorList);
		dataView.setRecordsTotal(count);

		return dataView;
	}

	@Override
	public void addMajor(Major major, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User)	session.getAttribute("user");
		major.setCreateBy(loginUser.getUserId());
		majorMapper.addMajor(major);
	}

	@Override
	public boolean deleteMajorByID(int majorId) throws Exception {
		int affectedRecords = majorMapper.deleteMajorByID(majorId);
		if (affectedRecords > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateMajor(Major major) throws Exception {

		int affectedRecords = majorMapper.updateMajor(major);

		if (affectedRecords > 0) {
			return true;
		} else {
			return false;
		}

	}

}
