package com.unitproject.Unit.Project.Spring.Base.services;

import com.unitproject.Unit.Project.Spring.Base.entities.VehicleType;
import com.unitproject.Unit.Project.Spring.Base.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeServices {

    private final TypeRepository tRepo;
    @Autowired
    public TypeServices(TypeRepository tRepo) {
        this.tRepo = tRepo;
    }

    public List<VehicleType> getAllTypes() {
        return tRepo.findAll();
    }

    public VehicleType getType(Long typeId) {
        return tRepo.findById(typeId).get();
    }
}
