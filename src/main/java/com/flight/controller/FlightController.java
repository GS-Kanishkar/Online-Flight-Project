package com.flight.controller;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.exception.RecordAlreadyPresentException;
import com.flight.exception.RecordNotFoundException;
import com.flight.entity.Flight;
import com.flight.service.FlightService;


@RestController
@RequestMapping("/flight")
public class FlightController {
	@Autowired(required = true)
	FlightService flightService;

	@PostMapping("/airline/stock/addFlight")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	@GetMapping("/airline/allFlight")
	public Iterable<Flight> viewAllFlight() {
		return flightService.viewAllFlight();
	}

	@GetMapping("/airline/info/{flightcode}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Flight viewFlight(@PathVariable("flightcode") BigInteger flightNo) {
		return flightService.viewFlight(flightNo);
	}

	@PutMapping("/flight/updateFlight")
	@ExceptionHandler(RecordNotFoundException.class)
	public void modifyFlight(@RequestBody Flight flight) {
		flightService.modifyFlight(flight);
	}

	@DeleteMapping("/airline/deleteFlight/{flightcode}")
	@ExceptionHandler(RecordNotFoundException.class)
	public void removeFlight(@PathVariable("flightcode") BigInteger flightNo) {
		flightService.removeFlight(flightNo);
	}
}
