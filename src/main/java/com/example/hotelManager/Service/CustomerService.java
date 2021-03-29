package com.example.hotelManager.Service;

import com.example.hotelManager.Result.Result;
import com.example.hotelManager.dao.CustomerDao;
import com.example.hotelManager.pojo.Customer;
import com.example.hotelManager.util.PageUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerDao customerDao;
    public Customer findByCustomerIDNumber(String CustomerIDNumber)
    {
        return customerDao.findByCustomerIDNumber(CustomerIDNumber);
    }
    public List<Customer> findAllCustomer(int PageNum,int PageSize)
    {

        Sort sort = Sort.by(Sort.Direction.DESC,"customerID");
        PageRequest pageRequest = PageRequest.of(PageNum,PageSize,sort);
        Page<Customer> page = customerDao.findAll(pageRequest);
        return page.getContent();




        }
    public void UpdateOrSaveCustomer(Customer customer)
    {
        customerDao.save(customer);
    }
    public void DeleteCustomer(Customer customer)
    {
        customerDao.delete(customer);
    }
    public long getMaxNum()
    {
        return customerDao.count();
    }
    public Customer findByCustomerID(String CustomerID){return customerDao.findByCustomerID(CustomerID);}
}
