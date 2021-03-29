package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
@Getter
@Setter
public class Worker {
    @Id
    @Column(name = "WorkerID")
    String workerID;
    @Column(name = "WorkerName")
    String workerName;
    @Column(name = "WorkerSex")
    String workerSex;
    @Column(name = "WorkerIDNumber")
    String workerIDNumber;
    @Column(name = "WorkerPosition")
    String workerPosition;
    @Column(name = "WorkerPassword")
    String workerPassword;


}
