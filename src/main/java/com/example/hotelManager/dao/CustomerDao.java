package com.example.hotelManager.dao;

import com.example.hotelManager.pojo.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,String> {
    List<Customer> findAll();
    Customer findByCustomerIDNumber(String CustomerIDNumber);
    Customer findByCustomerID(String CustomerID);

}
