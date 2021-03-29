package com.example.hotelManager.Controller;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.Service.CustomerService;
import com.example.hotelManager.pojo.Customer;
import com.example.hotelManager.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/findByCustomerIDNumber")
    public Customer findByCustomerIDNumber(@RequestBody Customer customer)
    {
        return customerService.findByCustomerIDNumber(customer.getCustomerIDNumber());
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/findAllCustomer")
    public Result<Object> findAllCustomer(int PageNum,int PageSize)
    {  System.out.println("running");
       System.out.println("数据条数:"+customerService.getMaxNum());
        System.out.println("最大页数为:"+PageUtil.getMaxPageNum(customerService.getMaxNum(),PageSize));
        Long MaxPageNum = customerService.getMaxNum();
        return new Result<>(true,1000,"操作成功",customerService.findAllCustomer(PageNum, PageSize),MaxPageNum);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/deleteCustomer")
    public Result DeleteCustomer(@RequestBody Customer customer)
    {
        customerService.DeleteCustomer(customer);
        return new Result(200);
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/UpdateOrAddCustomer")
    public Result UpdateOrAddCustomer(@RequestBody Map<String,Object> RequestMapping)
    {   //表单传进来时需要往表单中添加status字段，判断当前操作是新加还是更新
        String status = (String) RequestMapping.get("status");
        String customerID = (String) RequestMapping.get("customerID");
        String customerName = (String) RequestMapping.get("customerName");
        String customerSex = (String) RequestMapping.get("customerSex");
        String customerPhone = (String) RequestMapping.get("customerPhone");
        String customerIDNumber = (String) RequestMapping.get("customerIDNumber");
        String customerType = (String) RequestMapping.get("customerType");
        Customer customer = new Customer();
        customer.setCustomerID(customerID);
        customer.setCustomerPhone(customerPhone);
        customer.setCustomerIDNumber(customerIDNumber);
        customer.setCustomerSex(customerSex);
        customer.setCustomerType(customerType);
        customer.setCustomerName(customerName);
        System.out.println(customerName);

        System.out.println(customer.getCustomerPhone());
        System.out.println(customer.getCustomerCreateDate());


        //开始判断表单中的status变量，如果status为add，则为新建，若为update则为更新
        if(status.equals("update"))
        {   Date CustomerCreateDate = customerService.findByCustomerID(customerID).getCustomerCreateDate();
            customer.setCustomerCreateDate(CustomerCreateDate);
            customerService.UpdateOrSaveCustomer(customer);
            return new Result(200);
        }
        else
        {
            if(customerService.findByCustomerIDNumber(customerIDNumber)==null)
            {
                customer.setCustomerCreateDate(new Date());
                System.out.println(customer.getCustomerName());
                System.out.println(customer.getCustomerID());
                System.out.println(customer.getCustomerSex());
                System.out.println(customer.getCustomerName());
                System.out.println(customer.getCustomerType());
                System.out.println(customer.getCustomerIDNumber());
                System.out.println(customer.getCustomerPhone());
                System.out.println(customer.getCustomerCreateDate());
//                customerService.UpdateOrSaveCustomer(customer);

                return new Result(200);
            }
            else{return  new Result(400);
            }
        }
    }

}
