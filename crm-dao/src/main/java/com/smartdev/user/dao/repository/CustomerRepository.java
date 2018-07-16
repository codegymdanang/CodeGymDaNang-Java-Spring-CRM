package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.Status;
import com.smartdev.user.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByUserBySeller(User user);


    Page<Customer> findByStatusByStatusIdAndIsDelete(Status status, Integer isDelete, Pageable
            pageable);

    Page<Customer> findAllByProductTypeAndIsDelete(Integer productType, Integer isDelete,
                                                   Pageable pageable);

    Page<Customer> findByProductTypeAndStatusByStatusId(Integer productType, Status statusId,
                                                        Pageable pageable);

    Page<Customer> findByIsDelete(Integer isDelete, Pageable pageable);

//    @Query("select c from  Customer  c where  c.id =0")

    //List<Customer> findByUserBySellerAndIsDelete(User user, Integer isDelete);
    List<Customer> findByNameContainingAndIsDelete(String name, Integer isDelete);

    List<Customer> findByCompanyContainingAndIsDelete(String company, Integer isDelete);

    List<Customer> findByMailContainingAndIsDelete(String mail, Integer isDelete);

    List<Customer> findByUserBySellerAndIsDelete(User user, Integer isDelete);
    Page<Customer> findByUserBySellerAndIsDelete(User user, Integer isDelete,Pageable pageable);

    //---------------------------------------
    List<Customer> findByMailContainingAndIsDeleteAndStatusByStatusId(String mail, Integer isDelete, Status id_block);
    List<Customer> findByNameContainingAndIsDeleteAndStatusByStatusId(String name, Integer isDelete, Status id_block);
    List<Customer> findByCompanyContainingAndIsDeleteAndStatusByStatusId(String company, Integer isDelete, Status id_block);
    List<Customer> findByUserBySellerAndIsDeleteAndStatusByStatusId(User user, Integer isDelete, Status status);
}
