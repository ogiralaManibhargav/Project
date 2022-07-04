package net.example.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.example.spring.model.Booking;
import net.example.spring.model.Flight;
import net.example.spring.repo.Bookingrepo;

@Service
public class Bookingservice {
	@Autowired Bookingrepo repo;
	
	
	public void saveBooking(Booking b)
	{
	//	repo.save(b);
	}
	
	public List<Booking> findAll()
	{
		return new ArrayList(repo.findAll());
	}

	void deletebyId(Long parseLong)
	{
		repo.deletebyId(parseLong);
	}
}
