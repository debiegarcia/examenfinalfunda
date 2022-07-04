package com.example.examenfinalfunda.passenger.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreatePassengerResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String dni;

    @NotNull
    @NotBlank
    private String phone;

    @NotNull
    @NotBlank
    private String address;
}
