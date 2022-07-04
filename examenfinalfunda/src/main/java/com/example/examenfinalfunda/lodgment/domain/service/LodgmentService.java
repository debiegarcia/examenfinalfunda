package com.example.examenfinalfunda.lodgment.domain.service;

import com.example.examenfinalfunda.lodgment.domain.model.entity.Lodgment;

import java.util.List;

public interface LodgmentService {
    List<Lodgment> getAll();
    Lodgment getById(Long lodgmentId);
    List<Lodgment> getByPassengerId(Long passengerId);
    Lodgment create(Lodgment lodgment, Long passengerId);
    Lodgment update(Long lodgmentId, Lodgment lodgment);
    Lodgment delete(Long lodgmentId);
}
