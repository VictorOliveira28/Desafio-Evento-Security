package com.devsuperior.demo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CitiesRepository;

@Service
public class CityService {
	
	@Autowired
	CitiesRepository repository;
	
	@Transactional
	public CityDTO insert(CityDTO dto) {

		City entity = new City();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new CityDTO(entity);

	}

	void copyDtoToEntity(CityDTO dto, City entity) {
		entity.setName(dto.getName());
		entity.setId(dto.getId());		
	}
	
	@Transactional(readOnly = true)
	public List<CityDTO> FindAll(String name){
		List<City> list = repository.searchByName(name);
		
		return list.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
	}

}
