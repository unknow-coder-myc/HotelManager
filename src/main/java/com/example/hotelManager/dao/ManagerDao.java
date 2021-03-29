package com.example.hotelManager.dao;

import com.example.hotelManager.pojo.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManagerDao extends JpaRepository<Manager,String> {
    Manager findByManagerID(String ManagerID);
    Manager findByManagerIDAndManagerPassword(String ManagerID,String ManagerPassword);
    List<Manager> findAll();
    List<Manager> findByManagerName(String ManagerName);




}
