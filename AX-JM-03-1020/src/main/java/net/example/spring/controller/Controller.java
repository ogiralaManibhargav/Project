package net.example.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.example.spring.model.Booking;
import net.example.spring.model.Flight;
import net.example.spring.repo.Bookingrepo;
import net.example.spring.repo.Flightrepo;

@RestController
public class Controller {
	@Autowired Flightrepo flightService;
	
	@Autowired Bookingrepo bookingService;
	
	
	
	@PostMapping("/addFlight")
	public ResponseEntity<Flight> addFlight(@RequestBody Flight f)
	{
		for(Booking b:f.getBookings())
		{
			b.setFlight(f);
		//	bookingService.save(b);
		}
		
		f.setStatus("Active");
		flightService.save(f);
		return null;
	}
	
	@PostMapping("/addBooking")
	public ResponseEntity<Flight> addBooking(@RequestBody Booking b)
	{
	  //b.setFlight(null)
		b.setBookingStatus("Active");
		bookingService.save(b);
		return null;
	}
	
	@GetMapping("/viewFlights")
	public ResponseEntity<List> view()
	{
		
		
		return new ResponseEntity<>(flightService.findAll(),HttpStatus.OK);
		
	}
	@GetMapping("/viewBooking")
	public ResponseEntity<List> viewBooking()
	{
		
		
		return new ResponseEntity<>(bookingService.findAll(),HttpStatus.OK);
		
	}
	
	
	
	
	@GetMapping("/viewFlights/{id}")
	public ResponseEntity<List> viewbyId(@PathVariable String id)
	{
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+id);
		Optional<Flight> f=flightService.findById(Long.parseLong(id));
		
		return new ResponseEntity(f,HttpStatus.OK);
		
	}
	@GetMapping("/deleteFlights/{id}")
	public ResponseEntity deletebyId(@PathVariable String id)
	{
	//	Optional<Flight> f=flightService.deletebyId(Long.parseLong(id));
		flightService.deletebyId(Long.parseLong(id));
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/deleteBooking/{id}")
	public ResponseEntity deletebookingbyId(@PathVariable String id)
	{
		bookingService.deletebyId(Long.parseLong(id));
		return new ResponseEntity(HttpStatus.OK);
	}

}
