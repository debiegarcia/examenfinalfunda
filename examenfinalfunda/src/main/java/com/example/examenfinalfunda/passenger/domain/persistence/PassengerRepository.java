package com.example.examenfinalfunda.passenger.domain.persistence;

import com.example.examenfinalfunda.passenger.domain.model.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    List<Passenger> findByNameContaining(String name);
}
