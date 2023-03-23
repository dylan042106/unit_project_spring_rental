package com.unitproject.Unit.Project.Spring.Base.contollers;

import com.unitproject.Unit.Project.Spring.Base.services.VehicleService;
import com.unitproject.Unit.Project.Spring.Base.entities.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
}
