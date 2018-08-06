package com.center.service.edumgt;

import com.center.po.edumgt.Sybitem;
import com.center.po.edumgt.Syllabus;
import com.center.po.edumgt.SyllabusQuery;
import com.center.po.query.DatatablesView;
import com.center.vo.common.JsonVo;
import com.center.vo.edumgt.Section;

public interface SyllabusService {
	public JsonVo addSyllabus(Syllabus syllabus);
	public DatatablesView<Syllabus> loadSyllabus(SyllabusQuery syllabusQuery);
	boolean deleteSyllabus(int id);
	public DatatablesView<Sybitem> loadSybitem(String id,String sybitemCondition,String start,String length);
	public JsonVo addSybitem(Sybitem sybitem,String begin,String end);
	public boolean deleteSybitem(int id);
	public DatatablesView<Section> getThisWeekSyllabus(SyllabusQuery syllabusQuery);
	public JsonVo updateSyllabus(Syllabus syllabus);
	public JsonVo updateSybitem(Sybitem sybitem,String begin,String end);
}
