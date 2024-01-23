package com.devsuperior.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.demo.entities.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
