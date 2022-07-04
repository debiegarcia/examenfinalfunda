package com.example.examenfinalfunda.passenger.api;

import com.example.examenfinalfunda.passenger.domain.service.PassengerService;
import com.example.examenfinalfunda.passenger.mapping.PassengerMapper;
import com.example.examenfinalfunda.passenger.resource.CreatePassengerResource;
import com.example.examenfinalfunda.passenger.resource.PassengerResource;
import com.example.examenfinalfunda.passenger.resource.UpdatePassengerResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Passenger")
@RestController
@RequestMapping("api/v1/passengers")
@CrossOrigin
public class PassengerController {
    @Autowired
    private PassengerService passengerService;

    @Autowired
    private PassengerMapper passengerMapper;

    @Operation(summary = "Get All Passengers", description = "Get All Passengers")
    @GetMapping()
    public List<PassengerResource> getAll(){
        return passengerMapper.toResource(passengerService.getAll());
    }

    @Operation(summary = "Get Passenger by Id", description = "Get Passenger by Id")
    @GetMapping("{passengerId}")
    public PassengerResource getPassengerById(@PathVariable Long passengerId){
        return passengerMapper.toResource(passengerService.getById(passengerId));
    }

    @Operation(summary = "Create New Passenger", description = "Create New Passenger")
    @PostMapping()
     public PassengerResource createPassenger(@RequestBody CreatePassengerResource model){
        return passengerMapper.toResource(passengerService.create(passengerMapper.toModel(model)));
    }

    @Operation(summary = "Update Passenger", description = "Update Passenger")
    @PutMapping("{passengerId}")
    public PassengerResource updatePassenger(@PathVariable Long passengerId, @RequestBody UpdatePassengerResource model){
        return passengerMapper.toResource(passengerService.update(passengerId, passengerMapper.toModel(model)));
    }

    @Operation(summary = "Delete Passenger", description = "Delete Passenger")
    @DeleteMapping("{passengerId}")
    public void deletePassenger(@PathVariable Long passengerId){
        passengerService.delete(passengerId);
    }
}
