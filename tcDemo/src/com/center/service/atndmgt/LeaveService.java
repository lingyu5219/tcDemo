
/**
* Project Name:trainingCenter
* File Name:CenterService.java
* Package Name:com.center.service.org
* Date:2016年12月22日下午2:16:07
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.atndmgt;

import org.springframework.stereotype.Service;

import com.center.po.atndmgt.Leave;

/**
* ClassName:CenterService <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月22日 下午2:16:07 <br/>
* @author lidi
* @version
* @see
*/
@Service
public interface LeaveService {
	public Leave queryLeaveById(int leaveId) throws Exception;
}

