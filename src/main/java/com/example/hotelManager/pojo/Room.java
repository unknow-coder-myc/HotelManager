package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "room")
@Getter
@Setter
public class Room {
    @Id
    @Column(name = "RoomID")
    String roomID;
    @Column(name = "RoomType")
    String roomType;
    @Column(name = "RoomPrice")
    Float roomPrice;
    @Column(name = "RoomState")
    String roomState;
    @Column(name = "RoomPicture")
    String roomPicture;
    @Column(name = "RoomDescribe")
    String roomDescribe;


}
