package com.bicyclerentalservice.controller;

import com.bicyclerentalservice.model.Bicycle;
import com.bicyclerentalservice.model.Customer;
import com.bicyclerentalservice.repository.BicyclesRepository;
import com.bicyclerentalservice.repository.CustomersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model, @ModelAttribute("customer") Customer customer) {
        //add bicycle to model
        model.addAttribute("bicycle", bicycleRepository.getById(id));
        //get lessee
        Optional<Customer> lessee = bicycleRepository.getCustomerByBicycleId(id);

        if (lessee.isPresent()) {
            model.addAttribute("lessee", lessee.get());
        } else {
            model.addAttribute("customers", customerRepository.getAll());
        }
        return "bicycles/details";
    }

    @GetMapping("/new")
    public String newBicycle(@ModelAttribute("bicycle") Bicycle bicycle) {
        return "bicycles/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("bicycle") @Valid Bicycle bicycle, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "bicycles/new";

        bicycleRepository.save(bicycle);
        return "redirect:/bicycles";
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("bicycle", bicycleRepository.getById(id));
        return "bicycles/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("bicycle") @Valid Bicycle bicycle, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors())
            return "bicycles/update";

        bicycleRepository.update(id, bicycle);
        return "redirect:/bicycles";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bicycleRepository.delete(id);
        return "redirect:/bicycles";
    }

    @PatchMapping("/{id}/return")
    public String returnBicycle(@PathVariable("id") int id) {
        bicycleRepository.returnBicycle(id);
        return "redirect:/bicycles/" + id;
    }

    @PatchMapping("/{id}/rent")
    public String rentBicycle(@PathVariable("id") int id, @ModelAttribute("customer") Customer customer) {
        bicycleRepository.rentBicycle(id, customer);
        return "redirect:/bicycles/" + id;
    }

}
