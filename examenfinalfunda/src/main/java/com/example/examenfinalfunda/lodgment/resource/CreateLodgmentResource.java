package com.example.examenfinalfunda.lodgment.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateLodgmentResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String reservationDate;

    @NotNull
    private Integer pricePerNight;
}
