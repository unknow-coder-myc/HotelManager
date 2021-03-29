package com.example.hotelManager.Service;

import com.example.hotelManager.dao.ManagerDao;
import com.example.hotelManager.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    ManagerDao managerDao;
    public List<Manager> getAllManagers()
    {return managerDao.findAll();}
    public Manager login(String ManagerID,String ManagerPassword)
    {
        return managerDao.findByManagerIDAndManagerPassword(ManagerID,ManagerPassword);
    }
    public Manager getManagerByManagerID(String ManagerID)
    { return managerDao.findByManagerID(ManagerID);
    }

    public List<Manager> getManagerByManagerName(String ManagerName)
    {
        return managerDao.findByManagerName(ManagerName);
    }
    public void SaveOrUpdateManager(Manager manager)
    {
        managerDao.save(manager);
    }
    public void DeleteManagerByManagerID(Manager manager)
    {
        managerDao.delete(manager);
    }
    public long getMaxNum()
    {
        return managerDao.count();
    }
}
