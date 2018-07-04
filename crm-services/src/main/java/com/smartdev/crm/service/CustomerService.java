package com.smartdev.crm.service;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.User;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void addCustomer(Customer customer);
    Customer findOneid(Integer id);
    List<Customer> findByUserBySeller(User user);

}
