package com.center.service.stumgt;

import javax.servlet.http.HttpServletRequest;

import com.center.po.query.DatatablesView;
import com.center.po.stumgt.Student;
import com.center.po.stumgt.StudentQuery;

import jdk.internal.org.objectweb.asm.util.CheckSignatureAdapter;

public interface StudentService {
	public void addStu(Student student, HttpServletRequest request) throws Exception;

	public boolean deleteStu(int stuId, int userId) throws Exception;

	public boolean updateStu(Student student) throws Exception;

	public DatatablesView<Student> queryStuList(StudentQuery studentQuery) throws Exception;

	public boolean CheckStu(StudentQuery studentQuery) throws Exception;
}
