package com.example.examenfinalfunda.passenger.domain.service;

import com.example.examenfinalfunda.passenger.domain.model.entity.Passenger;

import java.util.List;

public interface PassengerService {
    List<Passenger> getAll();
    Passenger getById(Long passengerId);
    Passenger create(Passenger passenger);
    Passenger update(Long passengerId, Passenger passenger);
    Passenger delete(Long passengerId);
}
