/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.fracar.entity;

import javax.persistence.*;

/**
 * A Vehicle class that has the properties of brand, model, year and category.
 */
@Entity
@Table(name = "Vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicleId", nullable = false, updatable = false)
    private long vehicleID;
    private String brand;
    private String model;
    private int year;
    private boolean availability;

    @Enumerated(EnumType.STRING)
    private Category category;
    private int ps;
    private int currentMiles;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rentId")
    private Rent rent;

    public void setVehicleID(long vehicleID) {
        this.vehicleID = vehicleID;
    }

    public Rent getRent() {
        return rent;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    public Vehicle(long vehicleID, String brand, String model, int year, int ps, int currentMiles, Category category, boolean availability) {
        this.vehicleID = vehicleID;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.ps = ps;
        this.currentMiles = currentMiles;
        this.category = category;
        this.availability = availability;
    }

    public Vehicle(String brand, String model, int year, int ps, int currentMiles, Category category, boolean availability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.ps = ps;
        this.currentMiles = currentMiles;
        this.category = category;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", availability=" + availability +
                ", category=" + category +
                ", ps=" + ps +
                ", currentMiles=" + currentMiles +
                '}';
    }

    public Vehicle() {
    }

    public long getVehicleID() {
        return vehicleID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Category getCategory() {
        return category;
    }

    public String getCategoryAsString() {
        String categoryAsString = category.getString();
        return categoryAsString;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getCurrentMiles() {
        return currentMiles;
    }

    public void setCurrentMiles(int currentMiles) {
        this.currentMiles = currentMiles;
    }
}