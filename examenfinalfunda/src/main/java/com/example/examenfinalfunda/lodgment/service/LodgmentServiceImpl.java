package com.example.examenfinalfunda.lodgment.service;

import com.example.examenfinalfunda.lodgment.domain.model.entity.Lodgment;
import com.example.examenfinalfunda.lodgment.domain.persistence.LodgmentRepository;
import com.example.examenfinalfunda.lodgment.domain.service.LodgmentService;
import com.example.examenfinalfunda.passenger.domain.model.entity.Passenger;
import com.example.examenfinalfunda.passenger.domain.persistence.PassengerRepository;
import com.example.examenfinalfunda.shared.exception.ResourceNotFoundException;
import com.example.examenfinalfunda.shared.exception.ResourceValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LodgmentServiceImpl implements LodgmentService {

    private final static String ENTITY = "Lodgment";
    private final static String ENTITY2 = "Passenger";

    @Autowired
    private LodgmentRepository lodgmentRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Override
    public List<Lodgment> getAll() {
        return lodgmentRepository.findAll();
    }

    @Override
    public Lodgment getById(Long lodgmentId) {
        return lodgmentRepository.findById(lodgmentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, lodgmentId));
    }

    @Override
    public List<Lodgment> getByPassengerId(Long passengerId) {
        Optional<Passenger> passenger = passengerRepository.findById(passengerId);
        if(!passenger.isPresent()){
            throw new ResourceNotFoundException(ENTITY2, passengerId);
        }
        return lodgmentRepository.findByPassengerId(passengerId);
    }

    @Override
    public Lodgment create(Lodgment request, Long passengerId) {
        Optional<Passenger> passenger = passengerRepository.findById(passengerId);
        if(!passenger.isPresent()){
            throw new ResourceNotFoundException(ENTITY2, passengerId);
        }
        try {
            request.setPassenger(passenger.get());
            return lodgmentRepository.save(request);
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error has occurred while creating the Lodgment");
        }
    }

    @Override
    public Lodgment update(Long lodgmentId, Lodgment request) {
        try {
            return lodgmentRepository.findById(lodgmentId)
                    .map(lodgment ->
                            lodgmentRepository.save(
                                    lodgment.withName(request.getName())
                                            .withReservationDate(request.getReservationDate())
                                            .withPricePerNight(request.getPricePerNight())
                            )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, lodgmentId));
        } catch (Exception e) {
            throw new ResourceValidationException(ENTITY, "An error has occurred while updating the Lodgment");
        }
    }

    @Override
    public Lodgment delete(Long lodgmentId) {
        return lodgmentRepository.findById(lodgmentId)
                .map(lodgment -> {
                    lodgmentRepository.delete(lodgment);
                    return lodgment;
                }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, lodgmentId));
    }
}
