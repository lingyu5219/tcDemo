package com.center.mapper.studymgt;

import java.util.List;

import com.center.po.studymgt.Project;
import com.center.po.studymgt.ProjectQuery;

public interface ProjectMapper {
	
	public List<Project> queryProject(ProjectQuery projectQuery) throws Exception;

	public List<Project> queryProjectList(ProjectQuery projectQuery) throws Exception;
	
	public Long queryProjectCount(ProjectQuery projectQuery) throws Exception;

	public int addProject(Project project) throws Exception;
	
	public int delProject(int projectId) throws Exception;
	
	public int updateProject(Project project) throws Exception;
}
