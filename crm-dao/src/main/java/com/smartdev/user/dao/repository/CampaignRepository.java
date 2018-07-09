package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    List<Campaign> findByNameContaining(String key);
//    List<Campaign> findByDateStart_Month(int y);
   @Query(value="select * from campaign c where month(c.date_start) = ?1 or month(c.date_end) = ?2  " , nativeQuery = true)
    List<Campaign> findByDateMonth(int month , int month1);
    @Query(value="select * from campaign c where month(c.date_start) = ?1 or month(c.date_end) = ?2 and name LIKE %?3%  " , nativeQuery = true)
    List<Campaign> findByDateMonAndName(int month , int month1 , String key);

}

