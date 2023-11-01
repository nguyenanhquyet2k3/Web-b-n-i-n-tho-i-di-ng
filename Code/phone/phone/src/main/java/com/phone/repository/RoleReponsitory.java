package com.phone.repository;

import com.phone.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleReponsitory extends JpaRepository<Role, Integer> {
}
