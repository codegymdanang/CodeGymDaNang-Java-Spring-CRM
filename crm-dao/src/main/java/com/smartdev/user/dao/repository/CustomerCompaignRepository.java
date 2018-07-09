package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.CustomerCampaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerCompaignRepository extends JpaRepository<CustomerCampaign, Integer> {
}
