
/**
* Project Name:trainingCenter
* File Name:MajorService.java
* Package Name:com.center.service.edumgt
* Date:2016年12月26日下午2:33:20
* Copyright (c) 2016, Tony All Rights Reserved.
*
*/

package com.center.service.edumgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.center.po.edumgt.Major;
import com.center.po.edumgt.MajorQuery;
import com.center.po.query.DatatablesView;

/**
 * ClassName:MajorService <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2016年12月26日 下午2:33:20 <br/>
 * 
 * @author ChenZhenQiu
 * @version
 * @see
 */
public interface MajorService {
	public List<Major> queryMajor(MajorQuery majorQuery) throws Exception;
	
	public DatatablesView<Major> queryMajorList(MajorQuery majorQuery) throws Exception;

	public void addMajor(Major major, HttpServletRequest request) throws Exception;

	public boolean deleteMajorByID(int majorId) throws Exception;

	public boolean updateMajor(Major major) throws Exception;

}
