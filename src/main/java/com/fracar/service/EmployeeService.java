package com.fracar.service;

import com.fracar.entity.Employee;
import com.fracar.generic.GenericService;
import com.fracar.repository.EmployeeRepository;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements GenericService<Employee> {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEntity(Employee entity) {
        return employeeRepository.save(entity);
    }

    @Override
    public Employee updateEntity(Employee entity) {
        return employeeRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteEntity(Employee entity) {
        employeeRepository.delete(entity);
    }


    @Override
    public void deleteEntityById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findEntityById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return employeeRepository.existsById(id);
    }

    @Override
    public Employee getOneReferenceById(Long id) {
        return employeeRepository.getOne(id);

    }

    @Override
    public ObservableList<Employee> observableListView() {
        return null;
    }


    public boolean authenticate(String username, String password) {
        Employee employee = this.findByUsername(username);
        if (employee == null) {
            return false;
        } else {
            if (password.equals(employee.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void deleteInBatch(List<Employee> employees) {
        employeeRepository.deleteInBatch(employees);
    }

    public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username);
    }

}
