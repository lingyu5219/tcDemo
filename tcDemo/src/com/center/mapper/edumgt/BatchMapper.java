package com.center.mapper.edumgt;

import java.util.List;

import com.center.po.edumgt.Batch;
import com.center.po.edumgt.BatchQuery;

public interface BatchMapper {
	
	public List<Batch> queryBatch(BatchQuery batchQuery) throws Exception;
	
	public List<Batch> queryBatchList(BatchQuery batchQuery) throws Exception;

	public void addBatch(Batch batch) throws Exception;
	
	public Long queryBatchCount(BatchQuery batchQuery) throws Exception;
	
	public int delBatch(int batchId) throws Exception;
	
	public int updateBatch(Batch batch) throws Exception;
}
