package com.example.examenfinalfunda.passenger.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("passengerMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PassengerMapper passengerMapper() {
        return new PassengerMapper();
    }

}
