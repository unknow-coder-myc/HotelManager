package com.example.hotelManager.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="customertype")
@Getter
@Setter
public class CustomerType {
    @Id
    @Column(name = "Typename")
    String typename;
    @Column(name = "Discount")
    float discount;
    @Column(name = "Fine")
    Float fine;


}
