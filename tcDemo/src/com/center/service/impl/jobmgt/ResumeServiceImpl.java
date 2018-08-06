
/**
* Project Name:trainingCenter
* File Name:ResumeServiceImpl.java
* Package Name:com.center.service.impl.jobmgt
* Date:2016年12月23日下午3:23:07
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.jobmgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.jobmgt.ResumeMapper;
import com.center.po.jobmgt.Resume;
import com.center.po.jobmgt.ResumeQuery;
import com.center.po.query.DatatablesView;
import com.center.po.user.UserQueryTest;
import com.center.po.user.UserTest;
import com.center.service.jobmgt.ResumeService;

/**
* ClassName:ResumeServiceImpl <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午3:23:07 <br/>
* @author niit
* @version
* @see
*/

@Service
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeMapper resumeMapper;
	
	public Resume queryResumeById(int resumeId) throws Exception {
		Resume resume = resumeMapper.queryResumeById(resumeId);
		return resume;
	}
	
	@Override
	public DatatablesView<Resume> queryResumeList(ResumeQuery resumeQuery) throws Exception {
		DatatablesView<Resume> dataView = new DatatablesView<Resume>();
		
		Long count = resumeMapper.queryResumeCount(resumeQuery);
		List<Resume> resumeList = resumeMapper.queryResumeList(resumeQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(resumeList);
		return dataView ;
	}
}

