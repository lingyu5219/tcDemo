
/**
* Project Name:eduSystem
* File Name:ProjectServiceImpl.java
* Package Name:com.center.service.impl.studymgt
* Date:2017年5月9日下午2:26:20
* Copyright (c) 2017, Tony All Rights Reserved.
*
*/

package com.center.service.impl.studymgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.studymgt.ProjectMapper;
import com.center.po.query.DatatablesView;
import com.center.po.studymgt.Project;
import com.center.po.studymgt.ProjectQuery;
import com.center.po.system.User;
import com.center.service.studymgt.ProjectService;

/**
* ClassName:ProjectServiceImpl <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON. <br/>
* Date: 2017年5月9日 下午2:26:20 <br/>
* @author Tony
* @version
* @see
*/
@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectMapper projectMapper;
	
	@Override
	public List<Project> queryProject(ProjectQuery projectQuery) throws Exception {

		return projectMapper.queryProject(projectQuery);

	}

	@Override
	public DatatablesView<Project> queryProjectList(ProjectQuery projectQuery) throws Exception {

		DatatablesView<Project> dataView = new DatatablesView<Project>();
		
		Long count = projectMapper.queryProjectCount(projectQuery);
		List<Project> projectList = projectMapper.queryProjectList(projectQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(projectList);
		return dataView ;

	}

	@Override
	public boolean addProject(Project project, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User)	session.getAttribute("user");
		project.setCreateBy(loginUser.getUserId());
		
		int affectedRecords = projectMapper.addProject(project);
		
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delProject(int projectId) throws Exception {

		int affectedRecords = projectMapper.delProject(projectId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean updateProject(Project project, HttpServletRequest request) throws Exception {

		int affectedRecords = projectMapper.updateProject(project);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}

	}

}

