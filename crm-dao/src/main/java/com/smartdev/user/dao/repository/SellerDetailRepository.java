package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.SellerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface SellerDetailRepository extends JpaRepository<SellerDetail,String> {

}
