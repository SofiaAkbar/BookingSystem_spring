package com.example.BookingSystem.controllers;


import com.example.BookingSystem.models.Customer;
import com.example.BookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomersByFilter(
            @RequestParam(value = "course", required = false) String course,
            @RequestParam(value = "town", required = false) String town,
            @RequestParam(value = "age", required = false) Integer age){
        if (age != null & town != null & course != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(age, town, course), HttpStatus.OK);
        } else if (town != null & course != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseName(town, course), HttpStatus.OK);
        } else if (course != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(course), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id){
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
