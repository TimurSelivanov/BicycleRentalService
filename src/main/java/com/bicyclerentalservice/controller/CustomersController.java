package com.bicyclerentalservice.controller;

import com.bicyclerentalservice.repository.BicyclesRepository;
import com.bicyclerentalservice.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    private final BicyclesRepository bicycleRepository;
    private final CustomersRepository customerRepository;

    @Autowired
    public CustomersController(BicyclesRepository bicycleRepository, CustomersRepository customerRepository) {
        this.bicycleRepository = bicycleRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("customers", customerRepository.getAll());
        return "customers/customers";
    }
}
