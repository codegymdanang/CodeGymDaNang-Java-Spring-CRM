package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Customer;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //show ra thông tin khách hàng
//    @Modifying
//    @Transactional
//    @Query("select one from Customer one where one.id=:id")
////    public Customer findOne();
}
