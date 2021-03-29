package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manager")
@Getter
@Setter
public class Manager {
    @Id
    /*
    GeneratedValue GenerationType.IDENTITY 表示主键自动生成，且自增
     */
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManagerID")
    String managerID;
    @Column(name = "ManagerName")
    String managerName;
    @Column(name = "ManagerPassword")
    String managerPassword;


}
