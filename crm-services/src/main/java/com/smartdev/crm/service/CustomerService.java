package com.smartdev.crm.service;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.Status;
import com.smartdev.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
  
    void addCustomer(Customer customer);
  
    Customer findOneid(Integer id);

    Page<Customer> findCustomersByStatusId(Status status, Pageable pageable);

    Page<Customer> findCustomersByProductType(Integer productType, Pageable pageable);

    Page<Customer> findByProductTypeAndStatusByStatusId(Integer productType, Status statusId, Pageable pageable);

    List<Customer> findByUserBySellerAndIsDelete(User user,Integer isDelete);
  
    List<Customer> findByNameContaining(String name,Integer isDelete);
  
    List<Customer> findByCompanyContaining (String company,Integer isDelete);
  
    List<Customer>  findByMailContaining(String mail,Integer isDelete);
  
    List<Customer> findByUserBySeller( User user,Integer isDelete);

    List<Customer> checkOption(String option , String search);

    Page<Customer> listAllCustomer(Pageable pageable);

    Page<Customer> listCustomerWithFilter(Integer statusId, Integer productType, Integer pageNum);

}
