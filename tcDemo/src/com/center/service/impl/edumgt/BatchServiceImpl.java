
/**
* Project Name:trainingCenter
* File Name:BatchServiceImpl.java
* Package Name:com.center.service.impl.edumgt
* Date:2017年3月15日下午12:42:39
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.service.impl.edumgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.edumgt.BatchMapper;
import com.center.po.edumgt.Batch;
import com.center.po.edumgt.BatchQuery;
import com.center.po.query.DatatablesView;
import com.center.po.system.User;
import com.center.service.edumgt.BatchService;

/**
* ClassName:BatchServiceImpl <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2017年3月15日 下午12:42:39 <br/>
* @author Tony
* @version
* @see
*/
@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchMapper batchMapper;
	
	@Override
	public List<Batch> queryBatch(BatchQuery batchQuery) throws Exception {
		List<Batch> batchList = batchMapper.queryBatch(batchQuery);
		return batchList;
	}

	@Override
	public DatatablesView<Batch> queryBatchList(BatchQuery batchQuery) throws Exception {

		DatatablesView<Batch> dataView = new DatatablesView<Batch>();
		
		Long count = batchMapper.queryBatchCount(batchQuery);
		List<Batch> batchList = batchMapper.queryBatchList(batchQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(batchList);
		return dataView ;

	}

	@Override
	public void addBatch(Batch batch, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User)	session.getAttribute("user");
		//动态获取创建人名字 
		batch.setCreateBy(loginUser.getUserId());
		
		batchMapper.addBatch(batch);
	}

	@Override
	public boolean delBatch(int batchId) throws Exception {

		int affectedRecords = batchMapper.delBatch(batchId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateBatch(Batch batch) throws Exception {

		int affectedRecords = batchMapper.updateBatch(batch);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

}

