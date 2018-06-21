package com.smartdev.user.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryAdvisoryRepository extends JpaRepository<HistoryAdvisory, Integer> {
    List<HistoryAdvisory> findAll();
}
