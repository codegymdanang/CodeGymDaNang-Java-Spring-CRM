package com.smartdev.user.dao.repository;

import com.smartdev.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Integer> {
    public Role findByName(String name);
}