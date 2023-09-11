package com.example.addressapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;

import com.example.addressapp.model.Customer;
import com.example.addressapp.repository.CustomerRepository;
import com.example.addressapp.service.CustomerService;
import com.example.addressapp.form.CustomerForm;



@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    CustomerRepository customerRepository;

    @GetMapping("/")
    String index() {
        return "index";
    }

    @GetMapping("/list")
    String list(Model model) {
        List<Customer> customers = customerService.getAll();
        model.addAttribute("customers", customers);
        return "list";
    }

    @GetMapping("/add")
    String add(Model model) {
        model.addAttribute("updateCustomer", null);
        model.addAttribute("customerForm", new CustomerForm());
        return "update";
    }

    @GetMapping("/edit")
    String edit(@RequestParam("id") Integer id, Model model) {
        Customer customer = customerService.findById(id);
        CustomerForm customerForm = new CustomerForm();
        if (customer != null) {
            customerForm.setId(customer.getId());
            customerForm.setName(customer.getName());
            customerForm.setAddress(customer.getAddress());
            customerForm.setPhoneNumber(customer.getPhoneNumber());
        }
        model.addAttribute("customerForm", customerForm);
        model.addAttribute("isNew", false);
        return "update";
    }

    @PostMapping("/update")
    String update(@ModelAttribute @Validated CustomerForm customerForm, BindingResult result, Model model) {
        if (result.hasErrors()) {
            var isNew = customerForm.getId() == null ? true : false;
            model.addAttribute("isNew", isNew);
            model.addAttribute("customerForm", customerForm);
            return "update";
        }

        customerService.update(customerForm);
        return "redirect:/list";
    }

    @PostMapping("/delete")
    String delete(@RequestParam("id") Integer id) {
        customerService.delete(id);
        return "redirect:/list";
    }

    @GetMapping("/api/search")
    @ResponseBody
    public List<Customer> all() {
        List<Customer> customers = customerService.getAll();
        return customers;
    }

    @GetMapping("/api/search/{keyword}")
    @ResponseBody
    public List<Customer> searchCustomers(@PathVariable String keyword) {
        List<Customer> customers = customerService.findByName(keyword);
        return customers;
    }
}