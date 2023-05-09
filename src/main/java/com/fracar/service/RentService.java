package com.fracar.service;


import com.fracar.entity.Rent;
import com.fracar.generic.GenericService;
import com.fracar.repository.RentRepository;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentService implements GenericService<Rent> {


    final
    RentRepository rentRepository;

    @Autowired
    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    @Override
    public Rent saveEntity(Rent entity) {
        return rentRepository.save(entity);
    }

    @Override
    public Rent updateEntity(Rent entity) {
        return rentRepository.saveAndFlush(entity);
    }

    @Override
    public void deleteEntity(Rent entity) {
        rentRepository.delete(entity);
    }



    @Override
    public void deleteEntityById(Long id) {
        rentRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(List<Rent> entities) {

        rentRepository.deleteInBatch(entities);
    }

    @Override
    public Rent findEntityById(Long id) {
        return rentRepository.findById(id).get();
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return rentRepository.existsById(id);
    }

    @Override
    public Rent getOneReferenceById(Long id) {
        return rentRepository.getOne(id);
    }

    @Override
    public ObservableList<Rent> observableListView() {
        return null;
    }
}
