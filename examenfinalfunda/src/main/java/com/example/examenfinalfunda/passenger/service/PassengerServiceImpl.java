package com.example.examenfinalfunda.passenger.service;

import com.example.examenfinalfunda.passenger.domain.model.entity.Passenger;
import com.example.examenfinalfunda.passenger.domain.persistence.PassengerRepository;
import com.example.examenfinalfunda.passenger.domain.service.PassengerService;
import com.example.examenfinalfunda.shared.exception.ResourceNotFoundException;
import com.example.examenfinalfunda.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final static String ENTITY = "Passenger";

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Passenger> getAll() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger getById(Long passengerId) {
        return passengerRepository.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, passengerId));
    }

    @Override
    public Passenger create(Passenger passenger) {
        try {
            return passengerRepository.save(passenger);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while creating the passenger");
        }
    }

    @Override
    public Passenger update(Long passengerId, Passenger request) {
        try {
            return passengerRepository.findById(passengerId)
                    .map(passenger ->
                            passengerRepository.save(
                                    passenger.withName(request.getName())
                                            .withDni(request.getDni())
                                            .withPhone(request.getPhone())
                                            .withAddress(request.getAddress())
                            )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, passengerId));
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error occurred while updating the passenger");
        }
    }

    @Override
    public Passenger delete(Long passengerId) {
        return passengerRepository.findById(passengerId)
                .map(passenger -> {
                    passengerRepository.delete(passenger);
                    return passenger;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, passengerId));
    }
}

