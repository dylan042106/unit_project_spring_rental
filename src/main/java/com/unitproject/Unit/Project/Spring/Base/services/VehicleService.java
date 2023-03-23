package com.unitproject.Unit.Project.Spring.Base.services;

import com.unitproject.Unit.Project.Spring.Base.entities.VehicleType;
import com.unitproject.Unit.Project.Spring.Base.entities.Vehicles;
import com.unitproject.Unit.Project.Spring.Base.repositories.TypeRepository;
import com.unitproject.Unit.Project.Spring.Base.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    @Autowired
    private final VehicleRepository vRepo;
    private final TypeRepository tRepo;

    public VehicleService(VehicleRepository vRepo, TypeRepository tRepo) {
        this.vRepo = vRepo;
        this.tRepo = tRepo;
    }

    public List<Vehicles> getAllVehicles(){
        return vRepo.findAll();
    }

    public Vehicles assignToType(Long vehicleId, Long typeId) {
        Vehicles vehicles = vRepo.findById(vehicleId).get();
        VehicleType vehicleType = tRepo.findById(typeId).get();
        vehicles.assignToType(vehicleType);
        return vRepo.save(vehicles);
    }
}
