package com.example.hotelManager.Service;

import com.example.hotelManager.dao.FinancialDao;
import com.example.hotelManager.pojo.Financial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class FinancialService {
    @Autowired
    FinancialDao financialDao;
    public List<Financial> getAllFinancial()
    {
        return financialDao.findAll();
    }
    public void SaveFinancial(Financial financial)
    {
        financialDao.save(financial);
    }
    public List<Financial> findByCreateTime(String CreateTime){
        return financialDao.findByCreateTime(CreateTime);
    };
    public List<Financial> findAll()
    {
        return financialDao.findAll();
    }
}
