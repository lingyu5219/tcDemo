package com.center.controller.assetsmgt;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.center.po.assetsmgt.Equipment;
import com.center.po.assetsmgt.EquipmentQuery;
import com.center.po.query.DatatablesView;
import com.center.service.assetsmgt.EquipmentService;
import net.sf.json.JSONObject;

/**
 * 
* ClassName: EquipmentController <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2016年12月30日 下午2:40:22 <br/>
*
* @author SunChaoLun
* @version
 */

@Controller
@RequestMapping("/equipment")
public class EquipmentController {

	@Autowired
	private EquipmentService equipmentService;

	@ResponseBody
	@RequestMapping(value="/queryEquipmentList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String queryEquipmentList(@ModelAttribute("EquipmentQuery") EquipmentQuery equipmentQuery,HttpServletRequest request) throws Exception {

		// 调用service查找 数据库，查询用户
		DatatablesView<EquipmentQuery> dataTable = equipmentService.queryEquipmentList(equipmentQuery);
		dataTable.setDraw(equipmentQuery.getDraw());
		String data = JSONObject.fromObject(dataTable).toString();
		return data;
	}
	
	
	
	
	//根据ID删除用户
	@ResponseBody
	@RequestMapping(value="/delEquipment",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
	public String deleteEquipment(@ModelAttribute("equipmentId") int equipmentId,HttpServletRequest request) throws Exception {
		HashMap<String,String> rsMap = new HashMap<String,String>();
		boolean result = equipmentService.deleteEquipmentById(equipmentId);
		if (result) {
			rsMap.put("status", "1");
			rsMap.put("info", "删除成功");
		} else {
			rsMap.put("status", "0");
			rsMap.put("info", "删除失败");
		}
		String data = JSONObject.fromObject(rsMap).toString();
		return data;
	}
	
	
	//根据ID增加用户
			@ResponseBody
			@RequestMapping(value="/addEquipment",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
			public String addEquipment(@ModelAttribute("equipment") Equipment equipment,HttpServletRequest request) throws Exception {
				
				equipmentService.addEquipment(equipment,request);
				
				HashMap<String,String> rsMap = new HashMap<String,String>();
				if (equipment.getEquipmentId() > 0) {
					rsMap.put("status", "1");
					rsMap.put("info", "增加成功");
				} else {
					rsMap.put("status", "0");
					rsMap.put("info", "增加失败");
				}
				String data = JSONObject.fromObject(rsMap).toString();
				return data;
			}
	
	//根据ID修改用户
			@ResponseBody
			@RequestMapping(value="/updateEquipment",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
			public String updateEquipment(@ModelAttribute("equipment") Equipment equipment,HttpServletRequest request) throws Exception {
				HashMap<String,String> rsMap = new HashMap<String,String>();
				boolean result = equipmentService.updateEquipmentById(equipment,request);
				if (result) {
					rsMap.put("status", "1");
					rsMap.put("info", "更新成功");
				} else {
					rsMap.put("status", "0");
					rsMap.put("info", "更新失败");
				}
				String data = JSONObject.fromObject(rsMap).toString();
				return data;
			}
}