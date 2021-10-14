package com.example.BookingSystem.components;

import com.example.BookingSystem.models.Booking;
import com.example.BookingSystem.models.Course;
import com.example.BookingSystem.models.Customer;
import com.example.BookingSystem.repositories.BookingRepository;
import com.example.BookingSystem.repositories.CourseRepository;
import com.example.BookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){

        Customer jack = new Customer("Jack", "Dublin", 1);
        customerRepository.save(jack);

        Customer jill = new Customer("Jill Hibs", "Edinburgh", 30);
        customerRepository.save(jill);

        Customer lilly = new Customer("Lilly Filly", "Edinburgh", 34);
        customerRepository.save(lilly);

        Customer ben = new Customer("Ben Hem", "Dublin", 3);
        customerRepository.save(ben);

        Customer nick = new Customer("Nick Slick", "Cork", 3);
        customerRepository.save(nick);


        Course python = new Course("Intro to Python", "Dublin", 4);
        courseRepository.save(python);

        Course java = new Course("Intro to java", "Dublin", 5);
        courseRepository.save(java);

        Course photoShop = new Course("Intro to PhotoShop", "Edinburgh", 3);
        courseRepository.save(photoShop);

        Course animation = new Course("Intro to Animation", "Edinburgh", 2);
        courseRepository.save(animation);

        Course webDev = new Course("Intro to Web Dev", "Edinburgh", 1);
        courseRepository.save(webDev);



        Booking booking1 = new Booking("20-10-21", python, jack);
        bookingRepository.save(booking1);
        jack.addBooking(booking1);
        python.addBooking(booking1);


        Booking booking2 = new Booking("21-10-21", java, jill);
        bookingRepository.save(booking2);
        jill.addBooking(booking2);
        java.addBooking(booking2);

        Booking booking3 = new Booking("22-11-21", photoShop, ben);
        bookingRepository.save(booking3);
        ben.addBooking(booking3);
        photoShop.addBooking(booking3);

        Booking booking4 = new Booking("23-10-21", animation, lilly);
        bookingRepository.save(booking4);
        lilly.addBooking(booking4);
        animation.addBooking(booking4);

        Booking booking5 = new Booking("24-11-21", webDev, nick);
        bookingRepository.save(booking5);
        nick.addBooking(booking5);
        webDev.addBooking(booking5);

        Booking booking6 = new Booking("20-10-21", java, jack);
        bookingRepository.save(booking6);
        jack.addBooking(booking6);
        java.addBooking(booking6);

        Booking booking7 = new Booking("20-10-21", java, ben);
        bookingRepository.save(booking7);
        ben.addBooking(booking7);
        java.addBooking(booking7);




    }


}
