
/**
* Project Name:trainingCenter
* File Name:ResumeMapper.java
* Package Name:com.center.mapper.jobmgt
* Date:2016年12月23日下午3:13:47
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.mapper.jobmgt;

import java.util.List;

import com.center.po.jobmgt.Resume;
import com.center.po.jobmgt.ResumeQuery;
import com.center.po.user.UserQueryTest;


/**
* ClassName:ResumeMapper <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午3:13:47 <br/>
* @author niit
* @version
* @see
*/
public interface ResumeMapper {
	public Resume queryResumeById(int resumeId) throws Exception;
	
	public List<Resume> queryResumeList(ResumeQuery resumeQuery) throws Exception;
	
	public Long queryResumeCount(ResumeQuery resumeQuery) throws Exception;
}

