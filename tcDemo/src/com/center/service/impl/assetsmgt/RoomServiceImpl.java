package com.center.service.impl.assetsmgt;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.center.mapper.assetsmgt.RoomMapper;
import com.center.po.assetsmgt.Room;
import com.center.po.assetsmgt.RoomQuery;
import com.center.po.query.DatatablesView;
import com.center.service.assetsmgt.RoomService;

/**
 * 
* ClassName: RoomServiceImpl <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2016年12月30日 下午1:36:22 <br/>
*
* @author SunChaoLun
* @version
 */

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomMapper roomMapper;
	
	@Override
	public Room queryRoomById(int roomId) throws Exception {
		Room room = roomMapper.queryRoomById(roomId);		
		return room;
	}
	
	@Override
	public List<RoomQuery> queryUser(RoomQuery roomQuery) throws Exception {
		List<RoomQuery> roomList = roomMapper.queryRoomList(roomQuery);
		return roomList;
	}


	
	public DatatablesView<RoomQuery> queryRoomList(RoomQuery roomQuery) throws Exception {
		DatatablesView<RoomQuery> dataView = new DatatablesView<RoomQuery>();
		
		Long count = roomMapper.queryRoomCount(roomQuery);
		List<RoomQuery> roomList = roomMapper.queryRoomList(roomQuery);
		
		dataView.setRecordsTotal(count);
	    dataView.setData(roomList);
		return dataView ;
	}
	
	
	
	//public void addRoom(Room room) throws Exception{
		
		//roomMapper.addRoom(room);
		
	//}
	
	public boolean deleteRoomById(int roomId) throws Exception {
		
		int affectedRecords = roomMapper.deleteRoomById(roomId);
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}


	}
	
	public void addRoom(Room room,HttpServletRequest request) throws Exception {
		//HttpSession session = request.getSession();
		//Room loginRoom = (Room)	session.getAttribute("room");
		//room.setCreateBy("1");
		
		roomMapper.addRoom(room);
		
	}
	
	
	public boolean updateRoomById(Room room, HttpServletRequest request) throws Exception {
		//HttpSession session = request.getSession();
		//UserTest loginUser = (UserTest)	session.getAttribute("user");
		//user.setCreateBy(1);
		
		int affectedRecords = roomMapper.updateRoomById(room);
		
		if(affectedRecords > 0){
			return true;
		} else {
			return false;
		}
	}
}


