package com.bicyclerentalservice.controller;

import com.bicyclerentalservice.model.Customer;
import com.bicyclerentalservice.repository.BicyclesRepository;
import com.bicyclerentalservice.repository.CustomersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("customer", customerRepository.getById(id));
        model.addAttribute("bicycles", customerRepository.getBicyclesByCustomerId(id));
        return "customers/details";
    }

    @GetMapping("/new")
    public String newCustomer(@ModelAttribute("customer")Customer customer) {
        return "customers/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
        //TODO customer unique validation
        if(bindingResult.hasErrors())
            return "customers/new";

        customerRepository.save(customer);
        return "redirect:/customers";
    }

    @GetMapping("/{id}/update")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("customer", customerRepository.getById(id));
        return "customers/update";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if(bindingResult.hasErrors())
            return "customers/update";

        customerRepository.update(id, customer);
        return "redirect:/customers";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        customerRepository.delete(id);
        return "redirect:/customers";
    }
}
