
/**
* Project Name:trainingCenter
* File Name:ScoreService.java
* Package Name:com.center.service.perfmgt
* Date:2017年1月11日下午8:27:38
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.service.perfmgt;

import com.center.po.perfmgt.Score;
import com.center.po.perfmgt.ScoreQuery;
import com.center.po.query.DatatablesView;

/**
* ClassName:ScoreService <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2017年1月11日 下午8:27:38 <br/>
* @author qian
* @version
* @see
*/
public interface ScoreService {
//	查询考勤
	DatatablesView<ScoreQuery> queryScore(ScoreQuery scoreQuery) throws Exception;
//	查询成绩级联数据
	String queryScoreJsonData() throws Exception;
	
	public boolean deleteScore(int scoreId) throws Exception;
	
	public boolean updateScore(Score score) throws Exception;
}

