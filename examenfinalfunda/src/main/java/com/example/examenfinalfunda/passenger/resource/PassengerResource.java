package com.example.examenfinalfunda.passenger.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PassengerResource {
    private Long id;
    private String name;
    private String dni;
    private String phone;
    private String address;
}
