package com.example.examenfinalfunda.passenger.mapping;

import com.example.examenfinalfunda.passenger.domain.model.entity.Passenger;
import com.example.examenfinalfunda.passenger.resource.CreatePassengerResource;
import com.example.examenfinalfunda.passenger.resource.PassengerResource;
import com.example.examenfinalfunda.passenger.resource.UpdatePassengerResource;
import com.example.examenfinalfunda.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class PassengerMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public PassengerResource toResource(Passenger model){
        return mapper.map(model, PassengerResource.class);
    }

    public List<PassengerResource> toResource(List<Passenger> model){
        return mapper.mapList(model, PassengerResource.class);
    }

    public Passenger toModel(CreatePassengerResource resource){
        return mapper.map(resource, Passenger.class);
    }

    public Passenger toModel(UpdatePassengerResource resource){
        return mapper.map(resource, Passenger.class);
    }



}
