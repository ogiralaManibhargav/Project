package net.example.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.example.spring.model.Booking;


@Repository
public interface Bookingrepo extends JpaRepository<Booking, Long>{
	// save(Booking f);
	
	@Transactional 
	@Modifying
	@Query("UPDATE Booking f set f.bookingStatus='INACTIVE' where f.bookingId = ?1 ")
	
	void deletebyId(Long parseLong);
}
