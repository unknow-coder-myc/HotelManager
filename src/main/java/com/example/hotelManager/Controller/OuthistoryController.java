package com.example.hotelManager.Controller;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.InhistoryService;
import com.example.hotelManager.Service.OuthistoryService;
import com.example.hotelManager.Service.RoomService;
import com.example.hotelManager.dao.InhistoryDao;
import com.example.hotelManager.pojo.Inhistory;
import com.example.hotelManager.pojo.Outhistory;
import com.example.hotelManager.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
public class OuthistoryController {
    @Autowired
    OuthistoryService outhistoryService;
    @Autowired
    InhistoryService inhistoryService;
    @Autowired
    RoomService roomService;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/getAllOuthistory")
    public Result<List<Outhistory>> getAllOuthistory()
    {
        return new Result<>(outhistoryService.getAllOuthistory());
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/UpdateOrSaveOuthistory")
    public void  UpdateOrSaveOuthistory(Outhistory outhistory)
    {
      outhistoryService.UpdateOrSaveOuthistory(outhistory);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/handleOuthistory")
    public Result handleOutHistory(@RequestBody Inhistory inhistory)
    {//接收inhistoryID;
        String inID = inhistory.getInID();
        System.out.println("InID:"+inID);
        //查找对应订单
        Inhistory select_Inhistory = inhistoryService.findByInID(inID);

        //删除后更新退订表单
        String OuthistoryID = "O" + inhistory.getInID().substring(inhistory.getInID().indexOf("I"));
        Outhistory Current_outhistory = new Outhistory();
        System.out.println("CustomerID:"+select_Inhistory.getCustomerID());
        Current_outhistory.setOutID(OuthistoryID);
        Current_outhistory.setCustomerID(select_Inhistory.getCustomerID());
        Current_outhistory.setCustomerType(select_Inhistory.getCustomerType());
        Current_outhistory.setCustomerInDate("error");
        Date Now_date = new Date();
        Current_outhistory.setCustomerOutDate("error");
        Current_outhistory.setRoomID(select_Inhistory.getRoomID());
        Current_outhistory.setWorker("worker1");
        outhistoryService.UpdateOrSaveOuthistory(Current_outhistory);

        // 更改房间状态
        Room select_room = roomService.findByRoomID(select_Inhistory.getRoomID());
//        System.out.println("当前Room"+select_room);
//        System.out.println("当前RoomID:"+select_room.getRoomID());
        select_room.setRoomState("未入住");
        roomService.SaveOrUpdateRoom(select_room);
        //删除订单
        inhistoryService.DeleteInhistory(inhistory);

        return new Result(1000);


    }
}
