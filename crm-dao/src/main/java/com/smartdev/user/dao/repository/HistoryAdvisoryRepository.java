package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Customer;
import com.smartdev.user.entity.HistoryAdvisory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HistoryAdvisoryRepository extends JpaRepository<HistoryAdvisory, Integer> {
    List<HistoryAdvisory> findAll();
    public List<HistoryAdvisory> findByCustomerByCustomerId(Customer customer);
}
