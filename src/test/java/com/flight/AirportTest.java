package com.flight;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import com.flight.dao.AirportDao;
import com.flight.entity.Airport;
import com.flight.service.AirportServiceImpl;

	@ExtendWith(MockitoExtension.class)
	class AirportTest {
	@Mock
		private AirportDao dao;
	@InjectMocks
		private AirportServiceImpl AirportService;

		@Test
		void viewAllAirportTest() {

		List<Airport> list = new ArrayList<Airport>();
		Airport airport = new Airport("Indigo","chennai","10");
		list.add(airport);
		
		when(dao.findAll()).thenReturn(list);
		List<Airport> airportList = (List<Airport>) AirportService.viewAllAirport();
		assertEquals(1,airportList.size());
		}
		
		@Test
		void saveAirportTest() {
			Airport airport = new Airport("Indigo","chennai","10");
			when(dao.save(airport)).thenReturn(airport);
			ResponseEntity<?> savedAirport = AirportService.addAirport(airport);
			assertThat(savedAirport).isNotNull();
		
		}
		
	}


