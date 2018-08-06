package com.center.service.impl.edumgt;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.center.mapper.edumgt.SyllabusMapper;
import com.center.po.edumgt.Sybitem;
import com.center.po.edumgt.Syllabus;
import com.center.po.edumgt.SyllabusQuery;
import com.center.po.query.DatatablesView;
import com.center.service.edumgt.SyllabusService;
import com.center.vo.common.JsonVo;
import com.center.vo.edumgt.Section;

@Service
public class SyllabusServiceImpl implements SyllabusService {

	@Autowired
	private SyllabusMapper syllabusMapper;
	private Logger log = Logger.getLogger(SyllabusServiceImpl.class);
	
	@Override
	public JsonVo addSyllabus(Syllabus syllabus){
		if(StringUtils.isEmpty(syllabus.getSemester())){
			return new JsonVo("error", "请检查表单是否填写完整!");
		}
		Syllabus check = syllabusMapper.checkSyllabus(syllabus);
		if(check!=null){
			return new JsonVo("error", "已有该学年课程表，请勿重复添加!");
		}
		syllabusMapper.addSyllabus(syllabus);
		log.info(syllabus.toString());
		return new JsonVo("success","成功");
	}

	@Override
	public DatatablesView<Syllabus> loadSyllabus(SyllabusQuery syllabusQuery) {
		DatatablesView<Syllabus> datatablesView = new DatatablesView<Syllabus>();
		Map<String,String> params = new HashMap<String,String>();
		params.put("start", String.valueOf(syllabusQuery.getStart()));
		params.put("length", String.valueOf(syllabusQuery.getLength()));
		if(!StringUtils.isEmpty(syllabusQuery.getQuery())){
			if(!StringUtils.isEmpty(syllabusQuery.getTempYear())){
				params.put("year", String.valueOf(syllabusQuery.getTempYear()));
			}
			if(!StringUtils.isEmpty(syllabusQuery.getTempSylQuarter())){
				params.put("sylQuarter", syllabusQuery.getTempSylQuarter());
			}
			if(!StringUtils.isEmpty(syllabusQuery.getTempBatch())){
				params.put("batchId", String.valueOf(syllabusQuery.getTempBatch()));
			}			
		}

		int count = syllabusMapper.countSyllabus(params);
		if(count==0){
			return new DatatablesView<Syllabus>();
		}
		List<Syllabus> sylabus = syllabusMapper.loadSyllabus(params);
		datatablesView.setRecordsTotal(Long.valueOf(String.valueOf(count)));
		datatablesView.setData(sylabus);
		return datatablesView;
	}

	@Override
	public boolean deleteSyllabus(int id) {
		int result = syllabusMapper.deleteSyllabus(id);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public DatatablesView<Sybitem> loadSybitem(String syllabusId,String sybitemCondition,String start,String length) {
		DatatablesView<Sybitem> datatablesView = new DatatablesView<>();
		Map<String,String> params = new HashMap<String,String>();
		if(!StringUtils.isEmpty(syllabusId)){
			params.put("syllabusId", syllabusId);
		}
		if(!StringUtils.isEmpty(sybitemCondition)){
			params.put("sybitemCondition", "%"+sybitemCondition+"%");
		}
		if(!StringUtils.isEmpty(start)){
			params.put("start", start);
		}
		if(!StringUtils.isEmpty(length)){
			params.put("length", length);
		}
		int count = syllabusMapper.countSybItem(params);
		if(count==0){
			return datatablesView;
		}
		List<Sybitem> sybitems = syllabusMapper.loadSybitem(params);
		datatablesView.setRecordsTotal(Long.valueOf(String.valueOf(count)));
		datatablesView.setData(sybitems);
		return datatablesView;
	}

	@Override
	public JsonVo addSybitem(Sybitem sybitem,String begin,String end) {
		try {
			boolean checkEmpty = checkFileEmpty(sybitem);
			if(checkEmpty==false){
				return new JsonVo("error", "请检查表单是否填写完整!");
			}
		} catch (Exception e) {
			return new JsonVo("error",e.getMessage());
		}
		if(Integer.valueOf(begin)>Integer.valueOf(end)){
			return new JsonVo("error","请检查周次是否填写正确");
		}
		String[] sections = sybitem.getSection().split(",");
		for (String string : sections) {
			sybitem.setSection(string);
			Sybitem checkSybitem = syllabusMapper.checkSybitem(sybitem);
			sybitem.setWeek(begin+"-"+end);
			boolean checkEchoSybitem = checkEchoSybitem(sybitem, checkSybitem,false);
			if(!checkEchoSybitem){
				return new JsonVo("error","第"+string+"节已存在课程!");
			}			
		}
		for (String string : sections) {
			Sybitem temp = new Sybitem();
			BeanUtils.copyProperties(sybitem, temp);
			temp.setSection(string);
			log.info(temp.toString());
			syllabusMapper.addSybitem(temp);
		}
		return new JsonVo("success","成功");
	}

	private boolean checkFileEmpty(Object obj) throws Exception{
		Class clazz = obj.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
			Method getMethod = pd.getReadMethod();
			if(pd!=null){
				Object o = getMethod.invoke(obj);
				if(o==null){
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean checkEchoSybitem(Sybitem form,Sybitem dbCheck,boolean isSybitem){
		if(dbCheck==null){
			return true;
		}
		//check 周次
		String dbweeks = dbCheck.getWeek();
		String[] dbWeek = dbweeks.split("-");
		int dbBegin = Integer.valueOf(dbWeek[0]);
		int dbEnd = Integer.valueOf(dbWeek[1]);
		String formWeeks = form.getWeek();
		String[] formWeek = formWeeks.split("-");
		int formBegin = Integer.valueOf(formWeek[0]);
		int formEnd = Integer.valueOf(formWeek[1]);
		if((dbBegin<=formBegin&&formBegin<=dbEnd)||(dbBegin<=formEnd&&formEnd<=dbEnd)){
			//check 星期
			if(form.getDate()==dbCheck.getDate()){
				//check 节次
				if(form.getSection().equals(dbCheck.getSection())){
					if(isSybitem){
						return true;
					}else{
						return false;						
					}
				}
			}
		}/*else if(((dbBegin<=formBegin)&&(dbBegin<=formEnd&&formEnd<=dbEnd)||((dbEnd<=formEnd)&&(dbBegin<=formBegin&&formBegin<=dbEnd)))){
			if(form.getDate()==dbCheck.getDate()){
				//check 节次
				if(form.getSection().equals(dbCheck.getSection())){
					return false;
				}
			}
		}*/else if(formBegin<=dbBegin&&formEnd>=dbEnd){
			//check 星期
			if(form.getDate()==dbCheck.getDate()){
				//check 节次
				if(form.getSection().equals(dbCheck.getSection())){
					if(isSybitem){
						return true;
					}else{
						return false;						
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean deleteSybitem(int id) {
		int result = syllabusMapper.deleteSybitem(id);
		if(result<0){
			return false;
		}
		return true;
	}

	@Override
	public DatatablesView<Section> getThisWeekSyllabus(SyllabusQuery syllabusQuery) {
		DatatablesView<Section> datatables = new DatatablesView<Section>();
		Map<String,String> syllabusParams = new HashMap<String,String>();
		if(!StringUtils.isEmpty(syllabusQuery.getQuery())){
			if(!StringUtils.isEmpty(syllabusQuery.getTempYear())){
				syllabusParams.put("year", syllabusQuery.getTempYear());
			}
			if(!StringUtils.isEmpty(syllabusQuery.getTempSylQuarter())){
				syllabusParams.put("sylQuarter", syllabusQuery.getTempSylQuarter());				
			}
			if(!StringUtils.isEmpty(syllabusQuery.getTempBatch())){
				syllabusParams.put("batchId", syllabusQuery.getTempBatch());
			}
		}else{
			syllabusParams.put("year", "1");
			syllabusParams.put("sylQuarter", "10");
			syllabusParams.put("batchId", "1");
		}

		Syllabus syllabus = syllabusMapper.getThisWeekSyllabus(syllabusParams);
		if(syllabus==null){
			return datatables;
		}
		Map<String,String> params = new HashMap<String,String>();
		params.put("syllabusId", String.valueOf(syllabus.getId()));
		params.put("sort", "asc");
		List<Sybitem> sybitems = syllabusMapper.loadSybitem(params);
		
		
		List<Section> sections = sybitemToSection(sybitems);
		datatables.setData(sections);		
		return datatables;
	}
	
	private List<Section> sybitemToSection(List<Sybitem> sybitems){
		List<Section> sections = new ArrayList<Section>();
		for (int i = 0; i < 4; i++) {
			Section section = new Section();
			section.setSection(String.valueOf(i+1));
			sections.add(section);
		}
		
		for (Sybitem sybitem : sybitems) {
			String temp = sybitem.getSection();
			switch (temp) {
			case "1":
				dateSort(sections, sybitem, 0);
				break;
			case "2":
				dateSort(sections, sybitem, 1);
				break;
			case "3":
				dateSort(sections, sybitem, 2);
				break;
			case "4":
				dateSort(sections, sybitem, 3);
				break;
			default:
				break;
			}
		}
		return sections;
	}
	private void dateSort(List<Section> sections,Sybitem sybitem,int i){
		Section someDay = sections.get(i);
		if(sybitem.getDate()==1){
			someDay.setMonday(sybitem);
		}else if(sybitem.getDate()==2){
			someDay.setTuesday(sybitem);
		}else if(sybitem.getDate()==3){
			someDay.setWednesday(sybitem);
		}else if(sybitem.getDate()==4){
			someDay.setThursday(sybitem);
		}else if(sybitem.getDate()==5){
			someDay.setFriday(sybitem);
		}else if(sybitem.getDate()==6){
			someDay.setSaturday(sybitem);
		}else if(sybitem.getDate()==7){
			someDay.setSunday(sybitem);
		}
	}

	@Override
	public JsonVo updateSyllabus(Syllabus syllabus) {
		Syllabus check = syllabusMapper.checkSyllabus(syllabus);
		if(check!=null){
			return new JsonVo("error", "已有该学年课程表，请勿重复添加!");
		}
		int result = syllabusMapper.updateSyllabus(syllabus);
		if(result>0){
			return new JsonVo("success", "添加成功");
		}
		return new JsonVo("error", "添加失败");
	}

	@Override
	public JsonVo updateSybitem(Sybitem sybitem,String begin,String end) {
		try {
			boolean checkEmpty = checkFileEmpty(sybitem);
			if(checkEmpty==false){
				return new JsonVo("error", "请检查表单是否填写完整!");
			}
		} catch (Exception e) {
			return new JsonVo("error",e.getMessage());
		}
		if(Integer.valueOf(begin)>Integer.valueOf(end)){
			return new JsonVo("error","请检查周次是否填写正确");
		}
		String[] sections = sybitem.getSection().split(",");
		for (String string : sections) {
			sybitem.setSection(string);
			Sybitem checkSybitem = syllabusMapper.checkSybitem(sybitem);
			sybitem.setWeek(begin+"-"+end);
			boolean checkEchoSybitem = checkEchoSybitem(sybitem, checkSybitem,true);
			if(!checkEchoSybitem){
				return new JsonVo("error","第"+string+"节已存在课程!");
			}			
		}
		for (String string : sections) {
			Sybitem temp = new Sybitem();
			BeanUtils.copyProperties(sybitem, temp);
			temp.setSection(string);
			log.info(temp.toString());
			syllabusMapper.updateSybitem(temp);
		}
		return new JsonVo("success","修改课程成功");
	}
}
