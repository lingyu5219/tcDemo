package com.center.service.studymgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.center.po.query.DatatablesView;
import com.center.po.studymgt.Project;
import com.center.po.studymgt.ProjectQuery;

public interface ProjectService {
	
	public List<Project> queryProject(ProjectQuery projectQuery) throws Exception;

	public DatatablesView<Project> queryProjectList(ProjectQuery projectQuery) throws Exception;

	public boolean addProject(Project project,HttpServletRequest request) throws Exception;
	
	public boolean delProject(int projectId) throws Exception;
	
	public boolean updateProject(Project project,HttpServletRequest request) throws Exception;
}
