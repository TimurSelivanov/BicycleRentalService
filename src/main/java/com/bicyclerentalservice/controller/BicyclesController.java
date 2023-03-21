package com.bicyclerentalservice.controller;

import com.bicyclerentalservice.repository.BicyclesRepository;
import com.bicyclerentalservice.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bicycles")
public class BicyclesController {

    private final BicyclesRepository bicycleRepository;
    private final CustomersRepository customerRepository;

    @Autowired
    public BicyclesController(BicyclesRepository bicycleRepository, CustomersRepository customerRepository) {
        this.bicycleRepository = bicycleRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("bicycles", bicycleRepository.getAll());
        return "bicycles/bicycles";
    }
}
