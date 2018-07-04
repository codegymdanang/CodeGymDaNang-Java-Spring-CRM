package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.Status;
import com.smartdev.user.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByUserBySeller(User user);

    List<Customer> findByStatusByStatusId(Status status);

    List<Customer> findAllByProductType(Integer productType);

    List<Customer> findByProductTypeAndStatusByStatusId(Integer productType, Status statusId);

//    @Query("select c from  Customer  c where  c.id =0")
    List<Customer> findByUserBySellerAndIsDelete(User user, Integer isDelete);
    List<Customer> findByNameContaining(String name);
    List<Customer> findByCompanyContaining(String company);
    List<Customer> findByMailContaining(String mail);

    List<Customer> findByIsDelete(Integer isDelete);

}
