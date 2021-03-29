package com.example.hotelManager.Controller;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.*;
import com.example.hotelManager.pojo.Financial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HomeController {
    @Autowired
    ManagerService managerService;
    @Autowired
    InhistoryService inhistoryService;
    @Autowired
    WorkerService workerService;
    @Autowired
    RoomService roomService;
    @Autowired
    CustomerService customerService;
    @Autowired
    FinancialService financialService;
    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/getSecondDiv")
    public Result<HashMap<String,Long>> getSecondDiv()
    {
        long OrderNum = inhistoryService.getMaxNum();
       long WorkerNum = workerService.getMaxNum();
       long RoomNum = roomService.getMaxNum();
       long CustomerNum =customerService.getMaxNum();
       System.out.println(OrderNum);
        System.out.println(WorkerNum);
        System.out.println(CustomerNum);
        System.out.println(RoomNum);
        HashMap<String, Long> map = new HashMap<String, Long>();
      map.put("OrderNum",OrderNum);
      map.put("WorkerNum",WorkerNum);
      map.put("CustomerNum",CustomerNum);
      map.put("RoomNum",RoomNum);

        return new Result<>(map);
    }
    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/getFirstDiv")
    public Result<List<Long>> getFirstDiv()
    {
        long WorkerNum = workerService.getMaxNum();
        long CustomerNum = customerService.getMaxNum();
        long ManagerNum = managerService.getMaxNum();
        ArrayList<Long> list = new ArrayList<>();
        list.add(WorkerNum);
        list.add(ManagerNum);
        list.add(CustomerNum);
        return new Result<>(list);
    }
    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/getThirdDiv")
    public Result<List<Map<String,Object>>> getThirdDiv()
    {
        int OneFloor = roomService.getRoomNum("%10%","已入住");
        int TwoFloor = roomService.getRoomNum("%20%","已入住");
        int ThirdFloor = roomService.getRoomNum("%30%","已入住");
        int FourthFloor = roomService.getRoomNum("%40%","已入住");
        int NotInNum = roomService.getNotInNum("未入住");
        ArrayList<Map<String,Object>> list = new ArrayList<>();
       HashMap<String,Object> map = new HashMap<>();
       map.put("value",OneFloor);
       map.put("name","1楼入住数");
        HashMap<String,Object> map1 = new HashMap<>();
        map1.put("value",TwoFloor);
        map1.put("name","2楼入住数");
        HashMap<String,Object> map2 = new HashMap<>();
        map2.put("value",ThirdFloor);
        map2.put("name","3楼入住数");
        HashMap<String,Object> map3 = new HashMap<>();
        map3.put("value",FourthFloor);
        map3.put("name","4楼入住数");
        HashMap<String,Object> map4 = new HashMap<>();
        map4.put("value",NotInNum);
        map4.put("name","未入住数");
        list.add(map);
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);


 return  new Result<>(list);

    }
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @ResponseBody
    @CrossOrigin
    @RequestMapping("api/getFourthDiv")

    public Result<ArrayList<ArrayList<Object>>> getFourthDiv() throws ParseException {
        ArrayList<String> Datelist =new ArrayList<>();
        ArrayList<Float> ValueList = new ArrayList<>();
        ArrayList DataList = new ArrayList<>();
        for(int i=0;i<7;i++)
        {Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-i);
        Date time = cal.getTime();

          String str =   new SimpleDateFormat("yyyy-MM-dd").format(time);
          Datelist.add(str);
        System.out.println(str);

        List<Financial> list = financialService.findByCreateTime(str);
        float Result =0;
        for(int j = 0;j<list.size();j++)
        {
            System.out.println(list.get(j).getPrice());

             Result += Float.parseFloat (list.get(j).getPrice());

        }
        System.out.println("当天总值是:"+Result);
        ValueList.add(Result);
        System.out.println(list);

    }
        Collections.reverse(Datelist);
        Collections.reverse(ValueList);
        DataList.add(Datelist);
        DataList.add(ValueList);

        return new Result<>(DataList);
    }
}
