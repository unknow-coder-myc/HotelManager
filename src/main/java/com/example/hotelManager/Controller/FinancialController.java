package com.example.hotelManager.Controller;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.FinancialService;
import com.example.hotelManager.pojo.Financial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class FinancialController {
    @Autowired
    FinancialService financialService;

    @RequestMapping("api/getAllFinancial")
    @CrossOrigin
    @ResponseBody
    public Result<List<Financial>> getAllFinancial()
    {
        return new Result<>(financialService.getAllFinancial());
    }

    public void SaveFinancial(Financial financial)
    {
       financialService.SaveFinancial(financial);
    }
    @RequestMapping("api/getFinancialSum")
    @CrossOrigin
    @ResponseBody
    public Result<Float> getSum(){
        float result = 0;
   List<Financial> list = financialService.findAll();
   for(int i =0;i<list.size();i++)
   {
       result += Float.parseFloat(list.get(i).getPrice()) ;
   }
   return new Result<>(result);
    }
}
