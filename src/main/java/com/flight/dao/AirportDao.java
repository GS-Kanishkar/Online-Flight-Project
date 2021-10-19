package com.flight.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.flight.entity.Airport;

@Repository
public interface AirportDao extends CrudRepository<Airport, String> {

}