
/**
* Project Name:trainingCenter
* File Name:ResumeService.java
* Package Name:com.center.service.jobmgt
* Date:2016年12月23日下午3:19:22
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.jobmgt;


import com.center.po.jobmgt.Resume;
import com.center.po.jobmgt.ResumeQuery;
import com.center.po.query.DatatablesView;




/**
* ClassName:ResumeService <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午3:19:22 <br/>
* @author niit
* @version
* @see
*/
public interface ResumeService {
	public Resume queryResumeById(int resumeId) throws Exception;
	
	public DatatablesView<Resume> queryResumeList(ResumeQuery resumeQuery) throws Exception;
}

