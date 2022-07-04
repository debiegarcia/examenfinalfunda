package com.example.examenfinalfunda.lodgment.api;

import com.example.examenfinalfunda.lodgment.domain.service.LodgmentService;
import com.example.examenfinalfunda.lodgment.mapping.LodgmentMapper;
import com.example.examenfinalfunda.lodgment.resource.CreateLodgmentResource;
import com.example.examenfinalfunda.lodgment.resource.LodgmentResource;
import com.example.examenfinalfunda.lodgment.resource.UpdateLodgmentResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Lodgment")
@RestController
@RequestMapping("api/v1/lodgments")
@CrossOrigin
public class LodgmentController {
    @Autowired
    private LodgmentService lodgmentService;

    @Autowired
    private LodgmentMapper lodgmentMapper;

    @Operation(summary = "Get All Lodgments", description = "Get All Lodgments")
    @GetMapping()
    public List<LodgmentResource> getAll(){
        return lodgmentMapper.toResource(lodgmentService.getAll());
    }

    @Operation(summary = "Get Lodgment by Id", description = "Get Lodgment by Id")
    @GetMapping("{lodgmentId}")
    public LodgmentResource getLodgmentById(@PathVariable Long lodgmentId){
        return lodgmentMapper.toResource(lodgmentService.getById(lodgmentId));
    }

    @Operation(summary = "Get Lodgment by PassengerId", description = "Get Lodgment by PassengerId")
    @GetMapping("passenger/{passengerId}")
    public List<LodgmentResource> getLodgmentByPassengerId(@PathVariable Long passengerId){
        return lodgmentMapper.toResource(lodgmentService.getByPassengerId(passengerId));
    }

    @Operation(summary = "Create New Lodgment", description = "Create New Lodgment")
    @PostMapping("passenger/{passengerId}")
    public LodgmentResource createLodgment(@PathVariable Long passengerId, @RequestBody CreateLodgmentResource model){
        return lodgmentMapper.toResource(lodgmentService.create(lodgmentMapper.toModel(model), passengerId));
    }

    @Operation(summary = "Update Lodgment", description = "Update Lodgment")
    @PutMapping("{lodgmentId}")
    public LodgmentResource updateLodgment(@PathVariable Long lodgmentId, @RequestBody UpdateLodgmentResource model){
        return lodgmentMapper.toResource(lodgmentService.update(lodgmentId, lodgmentMapper.toModel(model)));
    }

    @Operation(summary = "Delete Lodgment", description = "Delete Lodgment")
    @DeleteMapping("{lodgmentId}")
    public void deleteLodgment(@PathVariable Long lodgmentId){
        lodgmentService.delete(lodgmentId);
    }
}
