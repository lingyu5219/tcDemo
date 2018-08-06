package com.center.controller.assetsmgt;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.center.po.assetsmgt.Room;
import com.center.po.assetsmgt.RoomQuery;
import com.center.po.query.DatatablesView;
import com.center.service.assetsmgt.RoomService;
import net.sf.json.JSONObject;

/**
 * 
* ClassName: ClassroomController <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2016年12月30日 下午2:39:46 <br/>
*
* @author SunChaoLun
* @version
 */

	@Controller
	@RequestMapping("/room")
	public class RoomController {

		@Autowired
		private RoomService roomService;
		
		
		@RequestMapping("/queryRoom")
		public ModelAndView queryRoomById(HttpServletRequest request) throws Exception {
			// 调用service查找 数据库，查询用户
			Room room = roomService.queryRoomById(1);
			
			// 返回ModelAndView
			ModelAndView modelAndView = new ModelAndView();
			// 相当 于request的setAttribute
			modelAndView.addObject("room", room);

			
			// 指定视图
			// 下边的路径，如果在视图解析器中配置jsp路径的前缀和jsp路径的后缀，
			// 路径配置可以不在程序中指定jsp路径的前缀和jsp路径的后缀
			modelAndView.setViewName("assetsmgt/room");

			return modelAndView;

		}
		
		
		@ResponseBody
		@RequestMapping(value="/queryRoomList",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
		public String queryRoomList(@ModelAttribute("RoomQuery") RoomQuery roomQuery,HttpServletRequest request) throws Exception {

			// 调用service查找 数据库，查询用户
			DatatablesView<RoomQuery> dataTable = roomService.queryRoomList(roomQuery);
			dataTable.setDraw(roomQuery.getDraw());
			String data = JSONObject.fromObject(dataTable).toString();
			return data;
		}
		
		
		//根据ID删除用户
		@ResponseBody
		@RequestMapping(value="/delRoom",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
		public String deleteRoom(@ModelAttribute("roomId") int roomId,HttpServletRequest request) throws Exception {
			HashMap<String,String> rsMap = new HashMap<String,String>();
			boolean result = roomService.deleteRoomById(roomId);
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
		@RequestMapping(value="/addRoom",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
		public String addRoom(@ModelAttribute("room") Room room,HttpServletRequest request) throws Exception {
			
			roomService.addRoom(room,request);
			
			HashMap<String,String> rsMap = new HashMap<String,String>();
			if (room.getRoomId() > 0) {
				rsMap.put("status", "1");
				rsMap.put("info", "增加成功");
			} else {
				rsMap.put("status", "0");
				rsMap.put("info", "增加失败");
			}
			String data = JSONObject.fromObject(rsMap).toString();
			return data;
		
		}
		
		@ResponseBody
		@RequestMapping(value="/updateRoom",method=RequestMethod.POST,produces = "text/json;charset=UTF-8")
		public String updateRoom(@ModelAttribute("room") Room room,HttpServletRequest request) throws Exception {
			HashMap<String,String> rsMap = new HashMap<String,String>();
			boolean result = roomService.updateRoomById(room,request);
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



