package com.flight.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flight.entity.Flight;
@Repository
public interface FlightDao extends CrudRepository<Flight,BigInteger>{

}
