package com.fracar.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@Table(name = "Customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId", nullable = false)
    private long customerId;

    public Customer(String gender, String lastName, String firstName, LocalDate dob, Address address) {
        this.title = gender;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.addressId = address;
    }

    public Customer(String title, String lastName, String firstName, LocalDate dob, Rent rent, Address addressId, long customerNo) {
        this.title = title;
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
        this.rent = rent;
        this.addressId = addressId;
        this.customerNo = customerNo;
    }

    public Customer() {
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public long getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(long customerNo) {
        this.customerNo = customerNo;
    }


    private String title;

    private String lastName;

    private String firstName;

    private LocalDate dob;

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentId")
    private Rent rent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address addressId;

    private long customerNo;

    @Override
    public String toString() {
        return
                "No. " + customerId + ", " + lastName + ", " +
                        firstName + ", " +
                        dob.format(DateTimeFormatter.ofPattern("dd.MM.YYYY"));

    }
}