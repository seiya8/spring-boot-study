package com.example.addressapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;

import com.example.addressapp.model.Customer;
import com.example.addressapp.service.CustomerService;
import com.example.addressapp.form.CustomerForm;


@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    String list(Model model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/add")
    String registerForm(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "register";
    }

    @PostMapping("/add")
    String insertCustomer(@ModelAttribute @Validated CustomerForm customerForm, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        customerService.insert(customerForm);
        return "redirect:/";
    }

    @GetMapping("/edit")
    String editForm(@RequestParam("id") Integer id, Model model) {
        Customer updateCustomer = customerService.findById(id);
        model.addAttribute("customerForm", new CustomerForm());
        model.addAttribute("updateCustomer", updateCustomer);
        return "update";
    }

    @PostMapping("/update")
    String updateCustomer(@ModelAttribute @Validated CustomerForm customerForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            Customer updateCustomer = customerService.findById(customerForm.getId());
            model.addAttribute("customerForm", customerForm);
            model.addAttribute("updateCustomer", updateCustomer);
            return "update";
        }

        customerService.update(customerForm);
        return "redirect:/";
    }

    @PostMapping("/delete")
    String delete(@RequestParam("id") Integer id) {
        customerService.delete(id);
        return "redirect:/";
    }
}