package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="outhistory")
@Getter
@Setter
public class Outhistory {
    @Id
    @Column(name = "OutID")
    String outID;
    @Column(name = "CustomerID")
    String customerID;
    @Column(name = "CustomerType")
    String customerType;
    @Column(name = "CustomerInDate")
    String customerInDate;
    @Column(name = "CustomerOutDate")
    String customerOutDate;
    @Column(name = "RoomID")
    String roomID;
    @Column(name = "Worker")
    String worker;

}
