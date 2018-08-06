package com.center.mapper.perfmgt;

import java.util.List;

import com.center.po.perfmgt.Attend;
import com.center.po.perfmgt.AttendJsonData;
public interface AttendMapper {

//	查询考勤
	List<Attend> queryAttend(Attend attend) throws Exception;
//	查询考勤count
	Long queryAttendCount(Attend attend) throws Exception;
//	查询考勤级联数据
	List<AttendJsonData> queryAttendJsonData() throws Exception;

}