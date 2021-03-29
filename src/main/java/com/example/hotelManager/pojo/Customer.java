package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
//顾客实体类
@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    @Id
    @Column(name ="CustomerID")
    String customerID;
    @Column(name = "CustomerName")
    String customerName;
    @Column(name = "CustomerSex")
    String customerSex;
    @Column(name="CustomerIDNumber")
    String customerIDNumber;
    @Column(name = "CustomerType")
    String customerType;
    @Column(name = "CustomerPhone")
    String customerPhone;
    @Column(name = "CustomerCreateDate")
    Date customerCreateDate;


}
