package com.example.hotelManager.Service;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.dao.RoomDao;
import com.example.hotelManager.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    RoomDao roomDao;
     public List<Room> findAllRoom()
     {
        return roomDao.findAll();
     }
     public Room findByRoomID(String RoomID)
     {
         return roomDao.findByRoomID(RoomID);
     }
     public void SaveOrUpdateRoom(Room room)
     {
         roomDao.save(room);
     }
     public void DeleteRoom(Room room){roomDao.delete(room);}
    public long getMaxNum()
    {
        return roomDao.count();
    }
    public int getRoomNum(String RoomID,String RoomState)
    {    System.out.println(roomDao.findByRoomIDLikeAndRoomState(RoomID,RoomState));

         return roomDao.findByRoomIDLikeAndRoomState(RoomID,RoomState).toArray().length;
    }
    public int getNotInNum(String RoomState)
    {
        return roomDao.findByRoomState(RoomState).toArray().length;
    }
}
