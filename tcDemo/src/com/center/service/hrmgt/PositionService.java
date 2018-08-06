
/**
* Project Name:trainingCenter
* File Name:PositionService.java
* Package Name:com.center.service.hrmgt
* Date:2016年12月26日下午3:14:06
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.hrmgt;

import javax.servlet.http.HttpServletRequest;

import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.PositionQuery;
import com.center.po.query.DatatablesView;

/**
 * ClassName:PositionService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午3:14:06 <br/>
 * 
 * @author 李逢杰
 * @version
 * @see
 */
public interface PositionService {

	// 查看全部或个人
	public DatatablesView<Position> queryPosition(PositionQuery positionQuery) throws Exception;
	// 存储职位更新信息
	public Boolean updatePosition(Position position,HttpServletRequest request)throws Exception;
	// 添加职位信息
	public boolean addPosition(Position position,HttpServletRequest request) throws Exception;
	// 删除教职工信息
	public Boolean deletePosition(int positionId) throws Exception;
	
}
