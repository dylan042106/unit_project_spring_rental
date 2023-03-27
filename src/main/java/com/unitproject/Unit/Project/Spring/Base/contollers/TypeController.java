package com.unitproject.Unit.Project.Spring.Base.contollers;

import com.unitproject.Unit.Project.Spring.Base.entities.Customer;
import com.unitproject.Unit.Project.Spring.Base.entities.VehicleType;
import com.unitproject.Unit.Project.Spring.Base.services.TypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TypeController {
    @Autowired
    private final TypeServices typeServices;
    @Autowired
    public TypeController(TypeServices typeServices) {
        this.typeServices = typeServices;
    }

    @GetMapping("/home")
    public ModelAndView homePage(){
        Map<String, Object> model = new HashMap<>();
        List<VehicleType> list = typeServices.getAllTypes();
        model.put("types", list);
        return new ModelAndView("home", "model", model);
    }
    @GetMapping("/wishlist")
    public ModelAndView wishlist(Customer c) {
        return new ModelAndView("wishlist", "customer", c);
    }
}
