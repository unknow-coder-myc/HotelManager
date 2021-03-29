package com.example.hotelManager.Service;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.dao.WorkerDao;
import com.example.hotelManager.pojo.Manager;
import com.example.hotelManager.pojo.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {
    @Autowired
    WorkerDao workerDao;

    public List<Worker> getAllWorkers()
    {
        return workerDao.findAll();
    }

    public Worker findByWorkerID(String WorkerID)
    {
        return workerDao.findByWorkerID(WorkerID);
    }

    public Worker findByWorkerName(String WorkerName)
    {
        return workerDao.findByWorkerName(WorkerName);
    }

    public Worker findByWorkerIDAndWorkerPassword(String WorkerID,String WorkerPassword)
    {
        return workerDao.findByWorkerIDAndWorkerPassword(WorkerID,WorkerPassword);
    }

    public void UpdateOrAddWorker(Worker worker)
    {
        workerDao.save(worker);
    }
    public void DeleteWorkerByWorkerID(Worker worker)
    {
        workerDao.delete(worker);
    }
    public long getMaxNum()
    {
        return workerDao.count();
    }


}
