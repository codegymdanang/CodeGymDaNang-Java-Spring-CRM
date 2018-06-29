package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
