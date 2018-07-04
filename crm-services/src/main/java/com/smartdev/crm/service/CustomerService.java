package com.smartdev.crm.service;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.Status;
import com.smartdev.user.entity.User;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    void addCustomer(Customer customer);
    Customer afindOneid(Integer id);
  
    List<Customer> findByUserBySeller(User user);

    List<Customer> findCustomersByStatusId(Status status);

    List<Customer> findCustomersByProductType(Integer productType);

    List<Customer> findByProductTypeAndStatusByStatusId(Integer productType, Status statusId);

    List<Customer> findByUserBySellerAndIsDelete(User user,Integer isDelete);
}
