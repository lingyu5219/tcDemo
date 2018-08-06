package com.center.mapper.stumgt;

import java.util.List;

import com.center.po.stumgt.Student;
import com.center.po.stumgt.StudentQuery;

/**
 * 
 * ClassName: StudentMapper <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON(可选). <br/>
 * date: 2016年12月26日 下午1:37:43 <br/>
 * 
 * @author ChenZhenqiu
 * @version
 */
public interface StudentMapper {
	public void addStu(Student student) throws Exception;

	public int deleteStu(int stuId) throws Exception;

	public int updateStu(Student student) throws Exception;

	public long queryStuCount(StudentQuery studentQuery) throws Exception;

	public List<Student> queryStuList(StudentQuery studentQuery) throws Exception;

	public Student queryStu(int userId) throws Exception;
	
}
