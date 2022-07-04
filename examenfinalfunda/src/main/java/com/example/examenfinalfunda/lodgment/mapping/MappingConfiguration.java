package com.example.examenfinalfunda.lodgment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("lodgmentMappingConfiguration")
public class MappingConfiguration {

        @Bean
        public LodgmentMapper lodgmentMapper() {
            return new LodgmentMapper();
        }
}
