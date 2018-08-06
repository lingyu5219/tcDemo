
/**
* Project Name:trainingCenter
* File Name:ScoreServiceImpl.java
* Package Name:com.center.service.impl.perfmgt
* Date:2017年1月11日下午8:29:18
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.service.impl.perfmgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.perfmgt.ScoreMapper;
import com.center.po.perfmgt.Score;
import com.center.po.perfmgt.ScoreJsonData;
import com.center.po.perfmgt.ScoreQuery;
import com.center.po.query.DatatablesView;
import com.center.service.perfmgt.ScoreService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:ScoreServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2017年1月11日 下午8:29:18 <br/>
 * 
 * @author qian
 * @version
 * @see
 */
@Service
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreMapper scoreMapper;

	@Override
	public DatatablesView<ScoreQuery> queryScore(ScoreQuery scoreQuery) throws Exception {
		scoreQuery.setFlag(0);
		if ((scoreQuery.getStuName() == null || scoreQuery.getStuName().equals(""))
				&& (scoreQuery.getYearName() == null || scoreQuery.getYearName().equals(""))) {
			scoreQuery.setFlag(1);
		}

		if (scoreQuery.getUserId() != 0) {
			scoreQuery.setFlag(0);
			scoreQuery.setStuName(null);
			scoreQuery.setMajorName(null);
			scoreQuery.setBatchName(null);
			scoreQuery.setYearName(null);
			if (scoreQuery.getTermName() == null || scoreQuery.getTermName().equals("")) {
				scoreQuery.setTermName("0");
			}
		} else if (scoreQuery.getStuName() != null && !scoreQuery.getStuName().equals("")) {
			scoreQuery.setCourseName(null);
			scoreQuery.setTermName(null);
			scoreQuery.setMajorName(null);
			scoreQuery.setBatchName(null);
			scoreQuery.setYearName(null);
		} else if (scoreQuery.getCourseName() != null && !scoreQuery.getCourseName().equals("")) {
			if (scoreQuery.getBatchName() != null && !scoreQuery.getBatchName().equals("")) {
				scoreQuery.setYearName(null);
				scoreQuery.setMajorName(null);
			} else if (scoreQuery.getMajorName() != null && !scoreQuery.getMajorName().equals("")) {
				scoreQuery.setYearName(null);
			}
		} else if (scoreQuery.getTermName() != null && !scoreQuery.getTermName().equals("")) {
			if (scoreQuery.getBatchName() != null && !scoreQuery.getBatchName().equals("")) {
				scoreQuery.setYearName(null);
				scoreQuery.setMajorName(null);
			} else if (scoreQuery.getMajorName() != null && !scoreQuery.getMajorName().equals("")) {
				scoreQuery.setYearName(null);
			}
		}

		scoreQuery.setStuId(scoreQuery.getStuName());

		List<ScoreQuery> ScoreQueryList = scoreMapper.queryScore(scoreQuery);
		DatatablesView<ScoreQuery> dataView = new DatatablesView<ScoreQuery>();

		Long count = scoreMapper.queryScoreCount(scoreQuery);
		dataView.setRecordsTotal(count);

		dataView.setData(ScoreQueryList);
		return dataView;
	}

	@Override
	public String queryScoreJsonData() throws Exception {

		List<ScoreJsonData> scoreJsonDataList = scoreMapper.queryScoreJsonData();

		JSONObject jsonData = new JSONObject();

		JSONArray yearJson = new JSONArray();
		JSONArray termJson = new JSONArray();
		String yearName = null;
		String yearName2 = null;
		String majorName = null;
		String termName = null;
		for (ScoreJsonData scoreJsonData : scoreJsonDataList) {
			if (!scoreJsonData.getYearName().equals(yearName)) {
				yearName = scoreJsonData.getYearName();
				yearJson.add(yearName);
			}

			if (!scoreJsonData.getYearName().equals(yearName2)) {
				yearName2 = scoreJsonData.getYearName();
				String majorName2 = null;
				JSONArray majorJson = new JSONArray();
				for (ScoreJsonData scoreJsonData2 : scoreJsonDataList) {
					if (!scoreJsonData2.getMajorName().equals(majorName2)) {
						majorName2 = scoreJsonData2.getMajorName();
						majorJson.add(majorName2);
					}
				}
				jsonData.put(yearName2, majorJson);
			}

			if (!scoreJsonData.getMajorName().equals(majorName)) {
				majorName = scoreJsonData.getMajorName();
				JSONArray batchJson = new JSONArray();
				String batchName2 = null;

				for (ScoreJsonData scoreJsonData2 : scoreJsonDataList) {
					if (!scoreJsonData2.getBatchName().equals(batchName2)) {
						batchName2 = scoreJsonData2.getBatchName();
						batchJson.add(batchName2);
					}
				}

				jsonData.put(majorName, batchJson);
			}

		}
		
		
		String termName2 = null;

		for (ScoreJsonData scoreJsonData : scoreJsonDataList) {
			if (!scoreJsonData.getTermName().equals(termName2)) {
				termName2 = scoreJsonData.getTermName();
				termJson.add(termName2);
			}
			
			if (!scoreJsonData.getTermName().equals(termName)) {
				termName = scoreJsonData.getTermName();
				JSONArray couresJson = new JSONArray();
				String couresName2 = null;

				for (ScoreJsonData scoreJsonData2 : scoreJsonDataList) {
					if (!scoreJsonData2.getCourseName().equals(couresName2)) {
						couresName2 = scoreJsonData2.getCourseName();
						couresJson.add(couresName2);
					}
				}

				jsonData.put(termName, couresJson);
			}
		}

		
		

		jsonData.put("yearName", yearJson);
		jsonData.put("termName", termJson);

		return jsonData.toString();

	}

	@Override
	public boolean deleteScore(int scoreId) throws Exception {
		
		int affectedRecords = scoreMapper.deleteScore(scoreId);
		if (affectedRecords > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public boolean updateScore(Score score) throws Exception {
		
		int affectedRecords=0;
		System.out.println(score.getScoreId());
		if(score.getScoreId()==0){
			affectedRecords=scoreMapper.insertScore(score);
		}else{
			affectedRecords=scoreMapper.updateScore(score);
		}
		
		
		if (affectedRecords > 0) {
			return true;
		} else {
			return false;
		}
	}

}
