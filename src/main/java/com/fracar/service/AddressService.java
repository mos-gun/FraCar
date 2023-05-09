package com.fracar.service;

import com.fracar.entity.Address;
import com.fracar.generic.GenericService;
import com.fracar.repository.AddressRepository;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements GenericService<Address> {



    final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address saveEntity(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address updateEntity(Address entity) {
        return addressRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteEntity(Address entity) {
        addressRepository.delete(entity);

    }

    @Override
    public void deleteEntityById(Long id) {
        addressRepository.deleteById(id);

    }

    @Override
    public void deleteInBatch(List<Address> entities) {

        addressRepository.deleteInBatch(entities);

    }

    @Override
    public Address findEntityById(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return addressRepository.existsById(id);
    }

    @Override
    public Address getOneReferenceById(Long id) {
        return addressRepository.getOne(id);

    }

    @Override
    public ObservableList<Address> observableListView() {
        return null;
    }

}
