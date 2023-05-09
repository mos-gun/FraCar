package com.fracar.repository;


import com.fracar.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Transactional
    Employee findByUsername(String username);


}