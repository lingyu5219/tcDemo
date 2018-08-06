package com.center.service.edumgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.center.po.edumgt.Batch;
import com.center.po.edumgt.BatchQuery;
import com.center.po.query.DatatablesView;

public interface BatchService {

	public List<Batch> queryBatch(BatchQuery batchQuery) throws Exception;
	
	public DatatablesView<Batch> queryBatchList(BatchQuery batchQuery) throws Exception;

	public void addBatch(Batch batch,HttpServletRequest request) throws Exception;
	
	public boolean delBatch(int batchId) throws Exception;
	
	public boolean updateBatch(Batch batch) throws Exception;
}
