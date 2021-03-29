package com.example.hotelManager.dao;

import com.example.hotelManager.pojo.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerDao extends JpaRepository<Worker,String> {
    List<Worker> findAll();
    Worker findByWorkerID(String WorkerID);
    Worker findByWorkerName(String WorkerName);
    Worker findByWorkerIDAndWorkerPassword(String WorkerName,String WorkerPassword);

}
