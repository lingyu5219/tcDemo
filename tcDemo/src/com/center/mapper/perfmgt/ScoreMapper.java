package com.center.mapper.perfmgt;

import java.util.List;

import com.center.po.perfmgt.Score;
import com.center.po.perfmgt.ScoreJsonData;
import com.center.po.perfmgt.ScoreQuery;

public interface ScoreMapper {
	// 查询成绩级联数据
	List<ScoreJsonData> queryScoreJsonData() throws Exception;

	// 查询考勤
	List<ScoreQuery> queryScore(ScoreQuery scoreQuery) throws Exception;

	// 查询考勤count
	Long queryScoreCount(ScoreQuery scoreQuery) throws Exception;

	// 删除需要签到时间
	public int deleteScore(int scoreId) throws Exception;

	public int updateScore(Score score) throws Exception;
	
	public int insertScore(Score score) throws Exception;
}