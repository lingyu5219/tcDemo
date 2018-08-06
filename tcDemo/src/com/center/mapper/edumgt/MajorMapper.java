
/**
* Project Name:trainingCenter
* File Name:MajorMapper.java
* Package Name:com.center.mapper.edumgt
* Date:2016年12月26日下午2:22:35
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.mapper.edumgt;

import java.util.List;

import com.center.po.edumgt.Major;
import com.center.po.edumgt.MajorQuery;

/**
 * ClassName:MajorMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午2:22:35 <br/>
 * 
 * @author ChenZhenQiu
 * @version
 * @see
 */
// 对专业的增删改查
public interface MajorMapper {
	public void addMajor(Major major) throws Exception;

	public int deleteMajorByID(int majorId) throws Exception;

	public int updateMajor(Major major) throws Exception;

	public List<Major> queryMajor(MajorQuery majorQuery) throws Exception;

	public List<Major> queryMajorList(MajorQuery majorQuery) throws Exception;

	public long queryMajorCount(MajorQuery majorQuery) throws Exception;

}
