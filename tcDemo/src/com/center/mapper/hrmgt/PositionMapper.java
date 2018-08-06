
/**
* Project Name:trainingCenter
* File Name:PositionMapper.java
* Package Name:com.center.mapper.hrmgt
* Date:2016年12月26日下午3:08:26
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.mapper.hrmgt;

import java.util.List;

import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.PositionQuery;

/**
 * ClassName:PositionMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午3:08:26 <br/>
 * 
 * @author 李逢杰
 * @version
 * @see
 */
public interface PositionMapper {

	// 查询全部或个人
	public List<Position> queryPosition(PositionQuery positionQuery) throws Exception;
	// 存储职位更新信息
	public void updatePosition(Position position) throws Exception;
		
	// 添加职位信息
	public void addPosition(Position position) throws Exception;

	// 删除教职工信息
	public void deletePosition(int positionId) throws Exception;
	
	public Long queryPositionCount(PositionQuery positionQuery)throws Exception;

}
