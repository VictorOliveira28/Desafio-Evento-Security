package com.devsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
