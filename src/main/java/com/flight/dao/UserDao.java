package com.flight.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import com.flight.entity.Users;

public interface UserDao extends CrudRepository<Users, BigInteger>{

}