package com.example.examenfinalfunda.lodgment.resource;

import com.example.examenfinalfunda.passenger.resource.PassengerResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LodgmentResource {
    private Long id;
    private String name;
    private String reservationDate;
    private Integer pricePerNight;
    private PassengerResource passenger;
}
