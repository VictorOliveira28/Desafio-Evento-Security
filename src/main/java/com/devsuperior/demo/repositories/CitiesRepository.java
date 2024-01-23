package com.devsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.City;

public interface CitiesRepository extends JpaRepository<City, Long>{

}
