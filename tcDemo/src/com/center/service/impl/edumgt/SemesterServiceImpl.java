package com.center.service.impl.edumgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.center.mapper.edumgt.*;
import com.center.po.edumgt.Semester;
import com.center.po.edumgt.SemesterQuery;
import com.center.po.query.DatatablesView;
import com.center.po.system.User;
import com.center.service.edumgt.SemesterService;

@Service
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterMapper semesterMapper;

	@Override
	public void addSemester(Semester semester, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		User loginUser = (User)	session.getAttribute("user");
		//动态获取创建人名字 
//		semester.setCreateBy(loginUser.getUserId());
		semester.setCreateBy(1);
		
		semesterMapper.addSemester(semester);
		
	}


	@Override
	public DatatablesView<Semester> querySemesterList(SemesterQuery semesterQuery) throws Exception {
		DatatablesView<Semester> dataView = new DatatablesView<Semester>();
		
		Long count = semesterMapper.querySemesterCount(semesterQuery);
		List<Semester> semesterList = semesterMapper.querySemesterList(semesterQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(semesterList);
		return dataView ;
	}

	@Override
	public boolean deleteSemesterById(int semesterId) throws Exception {
		int affectedRecords = semesterMapper.deleteSemesterById(semesterId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void modifySemesterById(Semester semester) throws Exception {
		semesterMapper.modifySemesterById(semester);
		
	}

}

