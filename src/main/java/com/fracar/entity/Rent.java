package com.fracar.entity;

import javax.persistence.*;


@Entity
@Table(name = "Rent")
public class Rent {


    public Rent() {

    }


    public Rent(Customer customerId, Address addressID, Vehicle vehicleId, Employee employeeId) {
        this.customerId = customerId;
        this.addressId = addressID;
        this.vehicleId = vehicleId;
        this.employeeId = employeeId;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rentId", nullable = false)
    private long rentId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerId")
    private Customer customerId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addressId")
    private Address addressId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleId")
    private Vehicle vehicleId;
    @OneToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "employeeId")
    private Employee employeeId;

    public long getRentId() {
        return rentId;
    }

    public void setRentId(long rentId) {
        this.rentId = rentId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }
}