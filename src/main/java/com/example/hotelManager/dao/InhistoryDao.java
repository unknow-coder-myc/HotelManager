package com.example.hotelManager.dao;

import com.example.hotelManager.pojo.Inhistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InhistoryDao extends JpaRepository<Inhistory,String> {
   List<Inhistory>  findAll();
   Inhistory findByInID(String InID);


}
