package com.example.hotelManager.dao;

import com.example.hotelManager.pojo.Financial;
import com.example.hotelManager.pojo.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FinancialDao extends JpaRepository<Financial,String> {
    List<Financial> findAll();
    List<Financial> findByCreateTime(String CreateTime);
}
