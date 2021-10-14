package com.example.BookingSystem.repositories;

import com.example.BookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByBookingsCourseName(String course);
    List<Customer> findByTownAndBookingsCourseName(String town, String course);
    List<Customer> findByAgeGreaterThanAndTownAndBookingsCourseName(Integer age, String town, String course);
}
