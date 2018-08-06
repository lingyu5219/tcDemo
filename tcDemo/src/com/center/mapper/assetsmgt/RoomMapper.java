package com.center.mapper.assetsmgt;

import java.util.List;
import com.center.po.assetsmgt.Room;
import com.center.po.assetsmgt.RoomQuery;


/**
 * 
* ClassName: RoomMapper <br/>
* Function: TODO ADD FUNCTION. <br/>
* Reason: TODO ADD REASON(可选). <br/>
* date: 2016年12月30日 下午2:41:02 <br/>
*
* @author SunChaoLun
* @version
 */

public interface RoomMapper {
	    
	    public void addRoom(Room room) throws Exception;
		public Room queryRoomById(int roomId) throws Exception;
		public List<RoomQuery> queryRoomList(RoomQuery roomQuery) throws Exception;
		public Long queryRoomCount(RoomQuery roomQuery) throws Exception;
		public int deleteRoomById(int roomId) throws Exception;
		public int updateRoomById(Room room) throws Exception;
	}

