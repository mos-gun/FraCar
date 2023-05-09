//
//package com.fracar.mocks;
//
//import com.fracar.entity.Customer;
//import com.fracar.repository.CustomerRepository;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
///**
// * A factory class to create a collection of {@link Customer} instances.
// */
//@Component
//public class CustomerMockGenerator {
//
//    private CustomerRepository customerService;
//
//    public CustomerMockGenerator(CustomerRepository customerService) {
//        this.customerService = customerService;
//
//    }
//
//    @PostConstruct
//    private void init() {
//        Customer customer1 = new Customer("Male", "lastname1", "firstname1", "09.05.1945");
//        Customer customer2 = new Customer("Male", "lastname2", "firstname2", "01.01.1952");
//        Customer customer3 = new Customer("Female", "lastname3", "firstname3", "28.05.1995");
//        Customer customer4 = new Customer("Male", "lastname4", "firstname4", "23.04.1992");
//        Customer customer5 = new Customer("Female", "lastname5", "firstname5", "14.12.1987");
//
//        customerService.saveEntity(customer1);
//        customerService.saveEntity(customer2);
//        customerService.saveEntity(customer3);
//        customerService.saveEntity(customer4);
//        customerService.saveEntity(customer5);
//    }
//}