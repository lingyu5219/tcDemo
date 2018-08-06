package com.center.mapper.edumgt;

import java.util.List;

import com.center.po.edumgt.Semester;
import com.center.po.edumgt.SemesterQuery;

public interface SemesterMapper {
	
	public void addSemester(Semester semester) throws Exception;
	
	public Semester semesterList(int semesterId) throws Exception;
	
	public List<Semester> querySemesterList(SemesterQuery semesterQuery) throws Exception;
	
	public Long querySemesterCount(SemesterQuery semesterQuery) throws Exception;
	
	public int deleteSemesterById(int semesterId) throws Exception;
	
	public int modifySemesterById(Semester semester) throws Exception;
}
