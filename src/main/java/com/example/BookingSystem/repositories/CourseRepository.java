package com.example.BookingSystem.repositories;

import com.example.BookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStarRating(Integer starRating);
    List<Course> findByBookingsCustomerName(String name);
}
