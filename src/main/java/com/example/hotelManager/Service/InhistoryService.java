package com.example.hotelManager.Service;

import com.example.hotelManager.dao.InhistoryDao;
import com.example.hotelManager.pojo.Customer;
import com.example.hotelManager.pojo.Inhistory;
import com.example.hotelManager.util.IdProduce;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

@Service
public class InhistoryService {
    @Autowired
    InhistoryDao inhistoryDao;
    public void SaveOrUpdateInhistory(Inhistory inhistory)
    {
         inhistoryDao.save(inhistory);
    }
    public List<Inhistory> getAllInhistory()
    {return inhistoryDao.findAll();}
    public void DeleteInhistory(Inhistory inhistory)
    {
        inhistoryDao.delete(inhistory);
    }
    public Inhistory findByInID(String InID)
    {
        return inhistoryDao.findByInID(InID);
    }
    public long getMaxNum()
    {
        return inhistoryDao.count();
    }
}

