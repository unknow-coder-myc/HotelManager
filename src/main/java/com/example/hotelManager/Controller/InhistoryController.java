package com.example.hotelManager.Controller;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.CustomerService;
import com.example.hotelManager.Service.FinancialService;
import com.example.hotelManager.Service.InhistoryService;
import com.example.hotelManager.Service.RoomService;
import com.example.hotelManager.dao.InhistoryDao;
import com.example.hotelManager.pojo.Customer;
import com.example.hotelManager.pojo.Financial;
import com.example.hotelManager.pojo.Inhistory;
import com.example.hotelManager.pojo.Room;
import com.example.hotelManager.util.IdProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class InhistoryController {
    @Autowired
    CustomerService customerService;
    @Autowired
    InhistoryService inhistoryService;
    @Autowired
    RoomService roomService;
    @Autowired
    FinancialService financialService;





    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/AddInhistory")
    public Result AddInhistory(@RequestBody Map<String,Object> requestParam)
    {  System.out.println(requestParam.get("customerIDNumber"));
       System.out.println(requestParam.get("customerName"));
       System.out.println(requestParam.get("roomID"));
       System.out.println(requestParam.get("roomPrice"));
        String CustomerIDNumber = (String) requestParam.get("customerIDNumber");
        String CustomerName = (String) requestParam.get("customerName");
        Customer  target= customerService.findByCustomerIDNumber(CustomerIDNumber);
        System.out.println("该对象是否为空:"+target);
               if(target==null)
       {   Date date= new Date();
           target = new Customer();
           target.setCustomerCreateDate(date);
           target.setCustomerID(IdProduce.CustomerIDProduce(CustomerIDNumber));
           target.setCustomerName(CustomerName);
           target.setCustomerIDNumber(CustomerIDNumber);
           target.setCustomerType("会员");
           target.setCustomerPhone("未填写");
           System.out.println(target.getCustomerID());
           customerService.UpdateOrSaveCustomer(target);
       }


               String RoomID =(String) requestParam.get("roomID");
//               String RoomPrice= (String) requestParam.get("roomPrice");
               Inhistory inhistory = new Inhistory();
               inhistory.setCustomerID(target.getCustomerID());
               inhistory.setCustomerType(target.getCustomerType());
               inhistory.setInID(IdProduce.InIDProduce());
               inhistory.setRoomID(RoomID);
               inhistory.setWorker("worker1");
               Date date = new Date();
               String date1 = new SimpleDateFormat("yyyy-MM-dd").format(date);
               inhistory.setCustomerInDate(date);
               inhistory.setCustomerOutDate(date);
        System.out.println(inhistory.getCustomerID());
        System.out.println(inhistory.getRoomID());
        System.out.println("状态:"+inhistory);
        inhistoryService.SaveOrUpdateInhistory(inhistory);
        //修改房间状态
        Room Update_room = roomService.findByRoomID(inhistory.getRoomID());
        Update_room.setRoomState("已入住");
        roomService.SaveOrUpdateRoom(Update_room);
        //账单表
        Financial financial = new Financial();
        financial.setFinancialID(IdProduce.RandomIDProduce("F"));
        financial.setCreateTime(date1);
        System.out.println(date1);
        financial.setCustomerID(target.getCustomerID());
        financial.setWorker("worker1");
        financial.setFinancialState("收入");
        financial.setPrice(String.valueOf(Update_room.getRoomPrice()));
        financialService.SaveFinancial(financial);
        return new Result(200);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/getAllInhistory")
    public Result<List<Inhistory>> getAllInhistory()
    {
        return new Result<>(inhistoryService.getAllInhistory());
    }
    public void DeleteInhistory(Inhistory inhistory)
    {inhistoryService.DeleteInhistory(inhistory);}
    public Inhistory findByInID(String InID)
    {
        return inhistoryService.findByInID(InID);
    }

//        room.getRoomID();
//    }
}
