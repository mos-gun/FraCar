package com.fracar.service;

import com.fracar.entity.Customer;
import com.fracar.generic.GenericService;
import com.fracar.repository.AddressRepository;
import com.fracar.repository.CustomerRepository;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CustomerService implements GenericService<Customer> {

    final
    AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public String toString() {
        return "CustomerService{" +
                "addressRepository=" + addressRepository +
                ", customerService=" + customerRepository +
                '}';
    }

    public List<Customer> findBySearchTerm(String searchTerm) {
        List<Customer> byLastName = customerRepository.findByLastNameContainingIgnoreCase(searchTerm);
        List<Customer> byFirstName = customerRepository.findByFirstNameContainingIgnoreCase(searchTerm);
        Map<Long, Customer> match = Stream.concat(byFirstName.stream(), byLastName.stream())
                .collect(Collectors.toMap(Customer::getCustomerId, entry -> entry, (first, second) -> second));
        return new ArrayList<>(match.values());
    }




    @Override
    public Customer saveEntity(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Customer updateEntity(Customer entity) {
        return customerRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteEntity(Customer entity) {
        customerRepository.delete(entity);

    }

    @Override
    public void deleteEntityById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(List<Customer> entities) {
        customerRepository.deleteInBatch(entities);
    }

    @Override
    public Customer findEntityById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {

        return customerRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return customerRepository.existsById(id);
    }

    @Override
    public Customer getOneReferenceById(Long id) {
        return customerRepository.getOne(id);
    }

    @Override
    public ObservableList<Customer> observableListView() {
        return null;
    }
}
