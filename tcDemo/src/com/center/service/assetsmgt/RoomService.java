package com.center.service.assetsmgt;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.center.po.assetsmgt.Room;
import com.center.po.assetsmgt.RoomQuery;
import com.center.po.query.DatatablesView;


public interface RoomService {
		public Room queryRoomById(int roomId) throws Exception;
		public List<RoomQuery> queryUser(RoomQuery roomQuery) throws Exception;
		public void addRoom(Room room,HttpServletRequest request) throws Exception;
		public DatatablesView<RoomQuery> queryRoomList(RoomQuery roomQuery) throws Exception;
		//public void addRoom(Room room) throws Exception;
		public boolean deleteRoomById(int roomId) throws Exception;
		public boolean updateRoomById(Room room,HttpServletRequest request) throws Exception;
	
	}


