package com.devsuperior.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.demo.entities.City;

public interface CitiesRepository extends JpaRepository<City, Long> {

	@Query("SELECT obj FROM City obj "
	        + "WHERE UPPER(obj.name) LIKE UPPER(CONCAT('%', :name, '%')) "
	        + "ORDER BY obj.name")
	List<City> searchByName(String name);
}
