package com.example.hotelManager.dao;

import com.example.hotelManager.pojo.Outhistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OuthistoryDao extends JpaRepository<Outhistory,String> {
    List<Outhistory> findAll();

}
