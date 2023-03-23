package com.unitproject.Unit.Project.Spring.Base.services;

import com.unitproject.Unit.Project.Spring.Base.entities.Vehicles;
import com.unitproject.Unit.Project.Spring.Base.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private final VehicleRepository vRepo;

    public VehicleService(VehicleRepository vRepo) {
        this.vRepo = vRepo;
    }

    public List<Vehicles> getAllVehicles(){
        return vRepo.findAll();
    }
}
