package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "inhistory")
@Getter
@Setter
public class Inhistory {
    @Id
    @Column(name = "InID")
    String inID;
    @Column(name = "CustomerID")
    String customerID;
    @Column(name = "CustomerType")
    String customerType;
    @Column(name = "CustomerInDate")
    Date customerInDate;
    @Column(name = "CustomerOutDate")
    Date customerOutDate;
    @Column(name = "RoomID")
    String roomID;
    @Column(name = "Worker")
    String worker;



}
