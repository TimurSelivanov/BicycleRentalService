package com.bicyclerentalservice.controller;

import com.bicyclerentalservice.repository.BicycleRepository;
import com.bicyclerentalservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bicycles")
public class BicyclesController {

    private final BicycleRepository bicycleRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public BicyclesController(BicycleRepository bicycleRepository, CustomerRepository customerRepository) {
        this.bicycleRepository = bicycleRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("bicycles", bicycleRepository.getAll());
        return "bicycles/bicycles";
    }
}
