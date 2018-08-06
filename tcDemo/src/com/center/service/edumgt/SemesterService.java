package com.center.service.edumgt;

import javax.servlet.http.HttpServletRequest;

import com.center.po.edumgt.Semester;
import com.center.po.edumgt.SemesterQuery;
import com.center.po.query.DatatablesView;

public interface SemesterService {

	public void addSemester(Semester semester, HttpServletRequest request) throws Exception;
	
	public DatatablesView<Semester> querySemesterList(SemesterQuery semesterQuery) throws Exception;
	
	public boolean deleteSemesterById(int semesterId) throws Exception;
	
	public void modifySemesterById(Semester semester) throws Exception;
}
