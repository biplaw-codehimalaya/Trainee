package com.securitypractice.practice11.repo;

import com.securitypractice.practice11.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;
import java.util.UUID;

public interface RoleRepo extends JpaRepository<Roles, UUID> {
}
