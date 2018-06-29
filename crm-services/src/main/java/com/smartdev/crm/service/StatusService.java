package com.smartdev.crm.service;

import com.smartdev.user.entity.Status;

import java.util.List;

public interface StatusService {
    List<Status> findAll();
    Status findByName(String name);
    Status findById(Integer id);

}
