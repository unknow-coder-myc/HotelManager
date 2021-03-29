package com.example.hotelManager.Service;

import com.example.hotelManager.dao.OuthistoryDao;
import com.example.hotelManager.pojo.Outhistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OuthistoryService {
    @Autowired
    OuthistoryDao outhistoryDao;
    public List<Outhistory> getAllOuthistory()
    { return outhistoryDao.findAll();}
    public void UpdateOrSaveOuthistory(Outhistory outhistory)
    { outhistoryDao.save(outhistory);}
}
