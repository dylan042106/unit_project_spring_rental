package com.unitproject.Unit.Project.Spring.Base.contollers;


import com.unitproject.Unit.Project.Spring.Base.entities.VehicleType;
import com.unitproject.Unit.Project.Spring.Base.services.TypeServices;
import com.unitproject.Unit.Project.Spring.Base.services.VehicleService;
import com.unitproject.Unit.Project.Spring.Base.entities.Vehicles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

// Uncomment Annotation for HTTP REQUESTS
//@RestController
@Controller
public class VehicleController {
    @Autowired
    private final VehicleService vehicleService;
    @Autowired
    private final TypeServices typeService;

    public VehicleController(VehicleService vehicleService, TypeServices typeService) {
        this.vehicleService = vehicleService;
        this.typeService = typeService;
    }
    @GetMapping("/")
    public String preHomePage(){
        return "index";
    }

    @GetMapping("/vehicles/all")
    public ModelAndView allVehicles(){
        List<Vehicles> list = vehicleService.getAllVehicles();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isIs_rented()){
                list.remove(i);
            }
        }
        return new ModelAndView("allVehicles", "vehicles", list);
    }

    @GetMapping("postman/vehicles/all")
    public List<Vehicles> httpRequestGetAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @PutMapping("vehicles/{vehicleId}/assign/{type_id}")
    public Vehicles assignToType(@PathVariable("vehicleId") Long vehicle_id, @PathVariable("type_id") Long type_id){
        return vehicleService.assignToType(vehicle_id, type_id);
    }

    @GetMapping("/vehicles/type/{type_id}")
    public ModelAndView getCertainVehicleTypes(@PathVariable("type_id") Long type_id){
        Map<String, Object> model = new HashMap<String, Object>();
        List<Vehicles> list = vehicleService.getCertainType(type_id);
        VehicleType vehType = typeService.getType(type_id);
        String type = vehType.getType_name();
        model.put("vehicles", list);
        model.put("type", type);
        return new ModelAndView("TypePage", "model", model);
    }

    @GetMapping("vehicles/Model/{vehicle_id}")
    public ModelAndView getOneVehicle(@PathVariable("vehicle_id") Long vehicle_id){
        Vehicles veh = vehicleService.getOneVehicle(vehicle_id).get();
        return new ModelAndView("OneVehiclePage", "vehicle", veh);
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/login");
        return mav;
    }
}
