
/**
* Project Name:trainingCenter
* File Name:AttendService.java
* Package Name:com.center.service.perfmgt
* Date:2016年12月23日下午8:40:09
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.perfmgt;

import com.center.po.perfmgt.Attend;
import com.center.po.query.DatatablesView;

/**
* ClassName:AttendService <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2016年12月23日 下午8:40:09 <br/>
* @author 钱兆瑞
* @version
* @see
*/
public interface AttendService {
//	查询考勤
	DatatablesView<Attend> queryAttend(Attend attend) throws Exception;
//	查询考勤级联数据
	String queryAttendJsonData() throws Exception;
}

