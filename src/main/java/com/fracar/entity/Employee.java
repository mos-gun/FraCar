package com.fracar.entity;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId", nullable = false)
    private long employeeId;

    private String title;

    private String lastName;

    private String firstName;

    private LocalDate dob;

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Rent getRentId() {
        return rentId;
    }

    public void setRentId(Rent rentId) {
        this.rentId = rentId;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentId")
    private Rent rentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private Address addressId;

    private String username;

    private String password;


    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }


    public Employee() {
    }

    public long getId() {
        return employeeId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", title='" + title + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", dob=" + dob +
                ", addressId=" + addressId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String nameToString() {
        return
                lastName + "  " + firstName;
    }
}