package com.example.examenfinalfunda.passenger.domain.model.entity;

import com.example.examenfinalfunda.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "passengers")
public class Passenger extends AuditModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

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
