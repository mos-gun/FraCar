package com.fracar.entity;


import javax.persistence.*;

@Entity
@Table(name = "Address")
public class Address {




    public Address(String streetName, String houseNo, String zipCode, String city, String phoneNo, String email) {
        this.streetName = streetName;
        this.houseNo = houseNo;
        this.zipCode = zipCode;
        this.city = city;
        this.phoneNo = phoneNo;
        this.email = email;
    }


    public Address() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "addressId", updatable = false, nullable = false)
    private long addressId;

    private String streetName;

    private String houseNo;

    private String zipCode;

    private String city;

    private String phoneNo;

    private String email;
    @OneToOne(mappedBy = "addressId")
    private Employee employee;

    @OneToOne(mappedBy = "addressId")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentId")
    private Rent rent;

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetName='" + streetName + '\'' +
                ", houseNo='" + houseNo + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
