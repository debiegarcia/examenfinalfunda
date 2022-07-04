package com.example.examenfinalfunda.lodgment.mapping;

import com.example.examenfinalfunda.lodgment.domain.model.entity.Lodgment;
import com.example.examenfinalfunda.lodgment.resource.CreateLodgmentResource;
import com.example.examenfinalfunda.lodgment.resource.LodgmentResource;
import com.example.examenfinalfunda.lodgment.resource.UpdateLodgmentResource;
import com.example.examenfinalfunda.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class LodgmentMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public LodgmentResource toResource(Lodgment model) {
        return mapper.map(model, LodgmentResource.class);
    }

    public List<LodgmentResource> toResource(List<Lodgment> model) {
        return mapper.mapList(model, LodgmentResource.class);
    }

    public Lodgment toModel(CreateLodgmentResource resource) {
        return mapper.map(resource, Lodgment.class);
    }

    public Lodgment toModel(UpdateLodgmentResource resource) {
        return mapper.map(resource, Lodgment.class);
    }
}
