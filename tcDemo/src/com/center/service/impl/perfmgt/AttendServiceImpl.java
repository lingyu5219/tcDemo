
/**
* Project Name:trainingCenter
* File Name:AttendServiceImpl.java
* Package Name:com.center.service.impl.perfmgt
* Date:2016年12月23日下午8:41:58
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.impl.perfmgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.perfmgt.AttendMapper;
import com.center.po.perfmgt.Attend;
import com.center.po.perfmgt.AttendJsonData;
import com.center.po.query.DatatablesView;
import com.center.service.perfmgt.AttendService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:AttendServiceImpl <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月23日 下午8:41:58 <br/>
 * 
 * @author 钱兆瑞
 * @version
 * @see
 */
@Service
public class AttendServiceImpl implements AttendService {

	@Autowired
	private AttendMapper attendMapper;

	// 查询考勤
	@Override
	public DatatablesView<Attend> queryAttend(Attend attend) throws Exception {

		attend.setFlag(0);
		if ((attend.getStuName() == null || attend.getYearName().equals(""))
				&& (attend.getYearName() == null || attend.getYearName().equals(""))) {
			attend.setFlag(1);

		}

		if (attend.getUserId() != 0) {
			attend.setFlag(0);
			attend.setStuName(null);
			attend.setYearName(null);
			attend.setBatchName(null);
			attend.setMajorName(null);
		} else if (attend.getStuName() != null && !attend.getStuName().equals("")) {
			attend.setYearName(null);
			attend.setBatchName(null);
			attend.setMajorName(null);
		} else if (attend.getBatchName() != null && !attend.getBatchName().equals("")) {
			attend.setYearName(null);
			attend.setMajorName(null);
		} else if (attend.getMajorName() != null && !attend.getMajorName().equals("")) {
			attend.setYearName(null);
		}

		attend.setStuNo(attend.getStuName());

		List<Attend> attends = attendMapper.queryAttend(attend);

		for (Attend attend2 : attends) {
			int lateDays = attend2.getTotalDays() - attend2.getLeaveDays() - attend2.getSigninDays();
			if (lateDays < 0) {
				lateDays = 0;
			}
			attend2.setLateDays(lateDays);
		}

		DatatablesView<Attend> dataView = new DatatablesView<Attend>();

		Long count = attendMapper.queryAttendCount(attend);
		dataView.setRecordsTotal(count);

		dataView.setData(attends);
		return dataView;
	}

	// 查询考勤级联数据
	@Override
	public String queryAttendJsonData() throws Exception {
		List<AttendJsonData> attendJsonDataList = attendMapper.queryAttendJsonData();

		JSONObject jsonData = new JSONObject();

		JSONArray yearJson = new JSONArray();
		String yearName = null;
		String yearName2 = null;
		String majorName = null;
		for (AttendJsonData attendJsonData : attendJsonDataList) {
			if (!attendJsonData.getYearName().equals(yearName)) {
				yearName = attendJsonData.getYearName();
				yearJson.add(yearName);
			}

			if (!attendJsonData.getYearName().equals(yearName2)) {
				yearName2 = attendJsonData.getYearName();
				String majorName2 = null;
				JSONArray majorJson = new JSONArray();
				for (AttendJsonData attendJsonData2 : attendJsonDataList) {
					if (!attendJsonData2.getMajorName().equals(majorName2)) {
						majorName2 = attendJsonData2.getMajorName();
						majorJson.add(majorName2);
					}
				}
				jsonData.put(yearName2, majorJson);
			}

			if (!attendJsonData.getMajorName().equals(majorName)) {
				majorName = attendJsonData.getMajorName();
				JSONArray batchJson = new JSONArray();
				String batchName2 = null;

				for (AttendJsonData attendJsonData2 : attendJsonDataList) {
					if (!attendJsonData2.getBatchName().equals(batchName2)) {
						batchName2 = attendJsonData2.getBatchName();
						batchJson.add(batchName2);
					}
				}

				jsonData.put(majorName, batchJson);
			}

		}
		jsonData.put("yearName", yearJson);

		return jsonData.toString();
	}
}
