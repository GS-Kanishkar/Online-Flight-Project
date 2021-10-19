package com.flight.service;

import java.math.BigInteger;
import org.springframework.http.ResponseEntity;
import com.flight.entity.Flight;

public interface FlightService {
	public ResponseEntity<Flight> addFlight(Flight flight);
	public Iterable<Flight> viewAllFlight();
	public Flight viewFlight(BigInteger flightNumber);
	public Flight modifyFlight(Flight flight);
	public String removeFlight(BigInteger flightNumber);

}