package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "financial")
@Getter
@Setter
public class Financial {
    @Id
    @Column(name = "FinancialID")
    String financialID;
    @Column(name = "CreateTime")
    String createTime;
    @Column(name = "Worker")
    String worker;
    @Column(name = "CustomerID")
    String customerID;
    @Column(name = "Price")
    String price;
    @Column(name = "FinancialState")
    String financialState;


}
