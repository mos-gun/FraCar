package com.fracar.service;

import com.fracar.entity.Vehicle;
import com.fracar.generic.GenericService;
import com.fracar.repository.VehicleRepository;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VehicleService implements GenericService<Vehicle> {


    public final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    @Override
    public Vehicle saveEntity(Vehicle entity) {
        return vehicleRepository.save(entity);
    }

    @Override
    public Vehicle updateEntity(Vehicle entity) {
        return vehicleRepository.saveAndFlush(entity);
    }


    @Override
    public void deleteEntity(Vehicle entity) {
        vehicleRepository.delete(entity);
    }

    @Override
    public void deleteEntityById(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public void deleteInBatch(List<Vehicle> entities) {
        vehicleRepository.deleteInBatch(entities);
    }

    @Override
    public Vehicle findEntityById(Long id) {
        return vehicleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public boolean existsById(Long id) {
        return vehicleRepository.existsById(id);
    }

    @Override
    public Vehicle getOneReferenceById(Long id) {
        return vehicleRepository.getOne(id);

    }

    @Override
    public ObservableList<Vehicle> observableListView() {
        return null;
    }
}
