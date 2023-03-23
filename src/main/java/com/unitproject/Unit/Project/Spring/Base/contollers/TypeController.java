package com.unitproject.Unit.Project.Spring.Base.contollers;

import com.unitproject.Unit.Project.Spring.Base.entities.VehicleType;
import com.unitproject.Unit.Project.Spring.Base.services.TypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TypeController {

    private final TypeServices typeServices;
    @Autowired
    public TypeController(TypeServices typeServices) {
        this.typeServices = typeServices;
    }

    @GetMapping("/home")
    public ModelAndView homePage(){
        List<VehicleType> list = typeServices.getAllTypes();
        return new ModelAndView("home", "types", list);
    }
}
