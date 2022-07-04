package com.example.examenfinalfunda.lodgment.domain.persistence;

import com.example.examenfinalfunda.lodgment.domain.model.entity.Lodgment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LodgmentRepository extends JpaRepository<Lodgment, Long> {
    List<Lodgment> findByPassengerId(Long passengerId);
}


