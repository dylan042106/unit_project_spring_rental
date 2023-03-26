package com.unitproject.Unit.Project.Spring.Base.contollers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unitproject.Unit.Project.Spring.Base.services.VehicleService;
import com.unitproject.Unit.Project.Spring.Base.entities.Vehicles;
import jakarta.persistence.OneToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Uncomment Annotation for HTTP REQUESTS
//@RestController
@Controller
public class VehicleController {
    @Autowired
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }
    @GetMapping("/")
    public String preHomePage(){
        return "index";
    }

    @GetMapping("/vehicles/all")
    public ModelAndView allVehicles(){
        List<Vehicles> list = vehicleService.getAllVehicles();
        return new ModelAndView("allVehicles", "vehicles", list);
    }

    @PutMapping("vehicles/{vehicleId}/assign/{type_id}")
    public Vehicles assignToType(@PathVariable("vehicleId") Long vehicle_id, @PathVariable("type_id") Long type_id){
        return vehicleService.assignToType(vehicle_id, type_id);
    }

    @GetMapping("/vehicles/type/{type_id}")
    public ModelAndView getCertainVehicleTypes(@PathVariable("type_id") Long type_id){
        List<Vehicles> list = vehicleService.getCertainType(type_id);
        return new ModelAndView("TypePage", "vehicles", list);
    }
}
