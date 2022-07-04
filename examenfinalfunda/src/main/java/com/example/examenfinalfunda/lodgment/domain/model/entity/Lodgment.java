package com.example.examenfinalfunda.lodgment.domain.model.entity;

import com.example.examenfinalfunda.passenger.domain.model.entity.Passenger;
import com.example.examenfinalfunda.shared.domain.model.AuditModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name = "logdgment")
public class Lodgment extends AuditModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @NotBlank
        private String name;

        @NotNull
        @NotBlank
        private String reservationDate;

        @NotNull
        private Integer pricePerNight;

        @ManyToOne(fetch = FetchType.LAZY)
        @OnDelete(action = OnDeleteAction.CASCADE)
        @JoinColumn(name = "lodgment_passenger_id", nullable = false)
        @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
        private Passenger passenger;



}
