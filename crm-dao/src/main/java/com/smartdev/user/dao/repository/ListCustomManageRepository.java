package com.smartdev.user.dao.repository;


import com.smartdev.user.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//@Repository
public interface ListCustomManageRepository extends JpaRepository<Customer, Integer> {

    @Modifying
    @Transactional
    @Query("select c from Customer  c where c.isDelete = 0")
    List<Customer> listAllCustomer();
}
