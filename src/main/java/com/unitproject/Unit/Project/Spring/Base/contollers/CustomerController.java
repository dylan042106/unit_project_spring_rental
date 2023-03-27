package com.unitproject.Unit.Project.Spring.Base.contollers;

import com.unitproject.Unit.Project.Spring.Base.entities.Customer;
import com.unitproject.Unit.Project.Spring.Base.services.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private final CustomerService customerService;
    @Autowired
    private final VehicleController vehicleController;
    @Autowired
    private final TypeController typeController;
    public CustomerController(CustomerService customerService, VehicleController vehicleController, TypeController typeController) {
        this.customerService = customerService;
        this.vehicleController = vehicleController;
        this.typeController = typeController;
    }

    @RequestMapping(path = "/logging_in/wishlist", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Optional<Customer> cust = customerService.getByEmail(email);
        if (cust.isPresent()){
            Customer c = customerService.getByEmail(email).get();
            if (Objects.equals(c.getCust_password(), password)) {
                return typeController.wishlist(c);
            }
        }
        return vehicleController.login();
    }
}
