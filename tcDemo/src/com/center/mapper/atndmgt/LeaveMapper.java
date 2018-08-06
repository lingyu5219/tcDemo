
/**
* Project Name:trainingCenter
* File Name:LeaveMapper.java
* Package Name:com.center.mapper.org
* Date:2016年12月22日下午1:54:04
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.mapper.atndmgt;

import com.center.po.atndmgt.Leave;;

/**
* ClassName:LeaveMapper <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月22日 下午1:54:04 <br/>
* @author lidi
* @version
* @see
*/
public interface LeaveMapper {
	public Leave queryLeaveById(int leaveId) throws Exception;
}

