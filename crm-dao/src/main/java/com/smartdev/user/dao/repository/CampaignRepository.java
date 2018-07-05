package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampaignRepository extends JpaRepository<Campaign, Integer> {
    List<Campaign> findByNameContaining(String name);
}
