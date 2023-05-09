package com.fracar.mocks;

import com.fracar.entity.Employee;
import com.fracar.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EmployeeMockGenerator {

    @Autowired
    private EmployeeService employeeService;


    @PostConstruct
    private void init() {
        //Employee: admin
        Employee admin = new Employee();
        admin.setFirstName("Admin");
        admin.setLastName("Istrator");
        admin.setUsername("admin");
        admin.setPassword("admin");
        employeeService.saveEntity(admin);

        //Employee: max
        Employee max = new Employee();
        max.setFirstName("Max");
        max.setLastName("Mustermann");
        max.setUsername("max");
        max.setPassword("max");
        employeeService.saveEntity(max);
    }




}
