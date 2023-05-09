
package com.fracar.mocks;

import com.fracar.entity.Category;
import com.fracar.entity.Vehicle;
import com.fracar.service.VehicleService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * A factory class to create a collection of {@link Vehicle} instances.
 */
@Component
public class VehicleMockGenerator {

    private VehicleService vehicleService;

    public VehicleMockGenerator(VehicleService vehicleService) {
        this.vehicleService = vehicleService;

    }

    @PostConstruct
    private void init() {

        Vehicle vehicle1 = new Vehicle("Audi", "Q3", 2018, 190, 50000, Category.SUV, true);
        Vehicle vehicle2 = new Vehicle("BMW", "X2", 2018, 140, 120000, Category.SUV, true);
        Vehicle vehicle3 = new Vehicle("Mercedes-Benz", "GLC F-Cell", 2018, 211, 70000, Category.SUV, false);
        Vehicle vehicle4 = new Vehicle("Audi", "S5", 2019, 349, 30000, Category.CONVERTIBLE, true);
        Vehicle vehicle5 = new Vehicle("BMW", "M240", 2017, 340, 200000, Category.CONVERTIBLE, false);
        Vehicle vehicle6 = new Vehicle("Porsche", "718 Boxster", 2018, 300, 100000, Category.CONVERTIBLE, true);
        Vehicle vehicle7 = new Vehicle("Ford", "Focus", 2018, 280, 20000, Category.COMPACT, false);
        Vehicle vehicle8 = new Vehicle("VW", "GTI", 2018, 220, 135000, Category.COMPACT, true);
        Vehicle vehicle9 = new Vehicle("Honda", "Civic", 2018, 158, 60000, Category.COMPACT, true);

        vehicleService.saveEntity(vehicle1);
        vehicleService.saveEntity(vehicle2);
        vehicleService.saveEntity(vehicle3);
        vehicleService.saveEntity(vehicle4);
        vehicleService.saveEntity(vehicle5);
        vehicleService.saveEntity(vehicle6);
        vehicleService.saveEntity(vehicle7);
        vehicleService.saveEntity(vehicle8);
        vehicleService.saveEntity(vehicle9);
    }
}