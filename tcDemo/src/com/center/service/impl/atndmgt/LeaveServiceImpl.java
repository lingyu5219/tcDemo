
/**
* Project Name:trainingCenter
* File Name:CenterServiceImpl.java
* Package Name:com.center.service.impl.org
* Date:2016年12月22日下午2:17:19
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.atndmgt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.atndmgt.LeaveMapper;
import com.center.po.atndmgt.Leave;
import com.center.service.atndmgt.LeaveService;


/**
* ClassName:CenterServiceImpl <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月22日 下午2:17:19 <br/>
* @author lidi
* @version
* @see
*/
@Service
public class LeaveServiceImpl implements LeaveService {

	@Autowired
	private LeaveMapper LeaveMapper;
	
	@Override
	public Leave queryLeaveById(int leaveId) throws Exception {
		
		
		
		Leave leave = LeaveMapper.queryLeaveById(leaveId);
		
				
				
		return leave;
	}

}


