package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.CustomerCampaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerCampaignRepository extends JpaRepository<CustomerCampaign,Integer> {
    List<CustomerCampaign> findByCampaignByCampaignId_Id(Integer campaignId);
}
