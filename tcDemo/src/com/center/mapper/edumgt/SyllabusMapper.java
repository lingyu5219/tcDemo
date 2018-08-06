package com.center.mapper.edumgt;

import java.util.List;
import java.util.Map;

import com.center.po.edumgt.Sybitem;
import com.center.po.edumgt.Syllabus;

public interface SyllabusMapper {
	public int addSyllabus(Syllabus syllabus);
	public Syllabus checkSyllabus(Syllabus syllabus);
	public List<Syllabus> loadSyllabus(Map<String,String> params);
	public int countSyllabus(Map<String,String> params);
	public int deleteSyllabus(int id);
	public int countSybItem(Map<String,String> params);
	public List<Sybitem> loadSybitem(Map<String,String> condition);
	public int addSybitem(Sybitem sybitem);
	public Sybitem checkSybitem(Sybitem sybitem);
	public int deleteSybitem(int id);
	public Syllabus getThisWeekSyllabus(Map<String,String> syllabusParams);
	public int updateSyllabus(Syllabus syllabus);
	public int updateSybitem(Sybitem sybitem);
}
