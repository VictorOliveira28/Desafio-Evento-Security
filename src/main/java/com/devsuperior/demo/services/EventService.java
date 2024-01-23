package com.devsuperior.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.CitiesRepository;
import com.devsuperior.demo.repositories.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Autowired
	CitiesRepository cityRepository;

	@Transactional(readOnly = true)
	public Page<EventDTO> findAllPaged(Pageable pageable) {

		Page<Event> list = repository.findAll(pageable);
		return list.map(x -> new EventDTO(x));
	}

	@Transactional
	public EventDTO insert(EventDTO dto) {

		Event entity = new Event();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EventDTO(entity);

	}

	void copyDtoToEntity(EventDTO dto, Event entity) {
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		entity.setDate(dto.getDate());

		Long cityId = dto.getCityId();
		if (cityId != null) {

			City city = new City();
			city.setId(cityId);
			entity.setCity(city);
		}

	}
}
