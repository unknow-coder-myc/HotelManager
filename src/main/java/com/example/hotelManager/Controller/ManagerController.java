package com.example.hotelManager.Controller;
import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.ManagerService;
import com.example.hotelManager.pojo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    ManagerService managerService;
    @CrossOrigin
    @ResponseBody
    //查询所有管理员
    //测试链接 http://localhost:8090/api/getAllManager
    @RequestMapping("/api/getAllManager")
    public Result<List<Manager>> getAllManagers()
    {

        return new Result<>(managerService.getAllManagers());
    }
    //根据编号查询管理员
    //测试链接 http://localhost:8090/api/getManagerByManagerID
    //参数部分前端用的是Request Payload，可用postman进行接口的调试，raw中选择JSON
    @CrossOrigin
    @RequestMapping("api/getManagerByManagerID")
    @ResponseBody
    public Result<Manager> getManagerByManagerID(@RequestBody Manager manager)
    {
        String ManagerID = manager.getManagerID();
        return new Result<>(managerService.getManagerByManagerID(ManagerID));
    }

    @CrossOrigin
    @RequestMapping("api/getManagerByManagerName")
    @ResponseBody
    public Result<List<Manager>> getManagerByManagerName(@RequestBody Manager manager)
    {
    String ManagerName = manager.getManagerName();
    System.out.println("getManagerByManagerName post obtain");
    System.out.println(managerService.getManagerByManagerName(ManagerName));
    return new Result<>(managerService.getManagerByManagerName(ManagerName));

//    ResultVO r1 = new ResultVO(1000,"success",managerService.getManagerByManagerName(ManagerName));
//    return r1;
    }

    @CrossOrigin
    @RequestMapping("/api/SaveOrUpdateManager")
    @ResponseBody
    public void SaveOrUpdateManager(@RequestBody Manager manager)
    {
        String managerID = manager.getManagerID();
        String managerName = manager.getManagerName();
        String managerPassword = manager.getManagerPassword();
        System.out.println("managerID:"+managerID+",managerName:"+managerName+"managerPassword"+managerPassword);

        System.out.println("SaveOrUpdateManager post obtain");
     managerService.SaveOrUpdateManager(manager);
    }
    @CrossOrigin
    @RequestMapping("/api/DeleteManagerByManagerID")
    @ResponseBody
    public void DeleteManagerByManagerID(@RequestBody Manager manager)
    {
        System.out.println(manager);
       String managerID = manager.getManagerID();
        System.out.println(managerID);
        System.out.println("DeleteManagerByManagerID Post obtain");
        managerService.DeleteManagerByManagerID(manager);
    }

}
