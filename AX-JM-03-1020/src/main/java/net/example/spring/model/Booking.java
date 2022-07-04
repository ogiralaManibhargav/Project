
package net.example.spring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Booking")
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long bookingId;
private String bookingDate;
private Long passengerno;

@ManyToOne(fetch = FetchType.LAZY,optional = false,cascade = CascadeType.ALL)
@JoinColumn(name="flightNo",nullable=false)
@JsonIgnoreProperties("bookings")
private Flight flight;
/**
 * @param bookingId
 * @param bookingDate
 * @param noOfPassengers
 */

/**
 * @param bookingId
 * @param bookingDate
 * @param passengerno
 * @param flight
 */
private String bookingStatus;
/**
 * @param bookingId
 * @param bookingDate
 * @param passengerno
 * @param flight
 * @param bookingStatus
 */
public Booking(Long bookingId, String bookingDate, Long passengerno, Flight flight, String bookingStatus) {
	super();
	this.bookingId = bookingId;
	this.bookingDate = bookingDate;
	this.passengerno = passengerno;
	this.flight = flight;
	this.bookingStatus = bookingStatus;
}
/**
 * 
 */
public Booking() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", passengerno=" + passengerno
			+ ", flight=" + flight + ", bookingStatus=" + bookingStatus + "]";
}
/**
 * @return the bookingId
 */
public Long getBookingId() {
	return bookingId;
}
/**
 * @param bookingId the bookingId to set
 */
public void setBookingId(Long bookingId) {
	this.bookingId = bookingId;
}
/**
 * @return the bookingDate
 */
public String getBookingDate() {
	return bookingDate;
}
/**
 * @param bookingDate the bookingDate to set
 */
public void setBookingDate(String bookingDate) {
	this.bookingDate = bookingDate;
}
/**
 * @return the passengerno
 */
public Long getPassengerno() {
	return passengerno;
}
/**
 * @param passengerno the passengerno to set
 */
public void setPassengerno(Long passengerno) {
	this.passengerno = passengerno;
}
/**
 * @return the flight
 */
public Flight getFlight() {
	return flight;
}
/**
 * @param flight the flight to set
 */
public void setFlight(Flight flight) {
	this.flight = flight;
}
/**
 * @return the bookingStatus
 */
public String getBookingStatus() {
	return bookingStatus;
}
/**
 * @param bookingStatus the bookingStatus to set
 */
public void setBookingStatus(String bookingStatus) {
	this.bookingStatus = bookingStatus;
}


}