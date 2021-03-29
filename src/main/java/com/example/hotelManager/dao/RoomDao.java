package com.example.hotelManager.dao;

import com.example.hotelManager.pojo.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomDao extends JpaRepository<Room, String> {
    List<Room> findAll();
    Room findByRoomID(String RoomID);
    List<Room> findByRoomIDLikeAndRoomState(String RoomID,String RoomState);
    List<Room> findByRoomState(String RoomState);
}
