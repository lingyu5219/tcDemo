
/**
* Project Name:trainingCenter
* File Name:PositionServiceImpl.java
* Package Name:com.center.service.impl.hrmgt
* Date:2016年12月26日下午3:15:31
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.hrmgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.hrmgt.PositionMapper;
import com.center.po.hrmgt.Position;
import com.center.po.hrmgt.PositionQuery;
import com.center.po.query.DatatablesView;
import com.center.service.hrmgt.PositionService;

/**
 * ClassName:PositionServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午3:15:31 <br/>
 * 
 * @author 李逢杰
 * @version
 * @see
 */
@Service
public class PositionServiceImpl implements PositionService{
	@Autowired
	private PositionMapper positionMapper;

	// 查看全部或某个
	public DatatablesView<Position> queryPosition(PositionQuery positionQuery) throws Exception {
		Long count = positionMapper.queryPositionCount(positionQuery);
		List<Position> positionlist = positionMapper.queryPosition(positionQuery);

        DatatablesView<Position> dataView =new DatatablesView<Position>();
		dataView.setData(positionlist);
		dataView.setRecordsTotal(count);
		return dataView;

	}
	// 职位信息更新
		@Override
		public Boolean updatePosition(Position position, HttpServletRequest request) throws Exception {
			boolean b = false;
			try {
				positionMapper.updatePosition(position);
				b = true;
			} catch (Exception e) {
				b = false;
			}

			return b;
			
		}
	
	// 添加职位信息
	@Override
	public boolean addPosition(Position position, HttpServletRequest request) throws Exception {
		boolean b = false;
		try {
			positionMapper.addPosition(position);
			b = true;
		} catch (Exception e) {
			b = false;
		}

		return b;		
	}
	// 删除教职工信息
		@Override
		public Boolean deletePosition(int positionId) throws Exception {
			boolean b = false;
			try {
				positionMapper.deletePosition(positionId);
				b = true;
			} catch (Exception e) {
				b = false;
			}

			return b;
			
		}	

}
