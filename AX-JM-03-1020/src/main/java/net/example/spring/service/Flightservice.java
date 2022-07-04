package net.example.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.example.spring.model.Flight;
import net.example.spring.repo.Flightrepo;

@Service
public class Flightservice {
	
	@Autowired Flightrepo repo;
	
	
	public void saveFlight(Flight f)
	{
		repo.save(f);
	}
	
	public List<Flight> findAll()
	{
		return new ArrayList(repo.findAll());
	}
	
	public Optional<Flight> findbyId(String id )
	{
		return repo.findById(Long.parseLong(id));
	}
	
	void deletebyId(Long parseLong)
	{
		 repo.deletebyId(parseLong);
		
	//	return f;
		
	}

}
