package com.unitproject.Unit.Project.Spring.controllers;

import com.unitproject.Unit.Project.Spring.models.Customer;
import com.unitproject.Unit.Project.Spring.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ApplicationController {
    @Autowired
    private CustomerRepository cRepo;
    @GetMapping("/index")
    public ModelAndView showCustomers(){
        ModelAndView mav = new ModelAndView("index");
        List<Customer> list = cRepo.findAll();
        mav.addObject("customers", list);
        return mav;
    }
    @RequestMapping("/next")
    public String next(){
        return "next";
    }
}
