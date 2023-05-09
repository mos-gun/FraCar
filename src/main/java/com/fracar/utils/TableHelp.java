package com.fracar.utils;

public class TableHelp {

    private String brand, model, year, ps, currentMilage, category;
    private boolean availability;

    public TableHelp(String brand, String model, String year, String ps, String currentMilage, String category, boolean availability) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.ps = ps;
        this.currentMilage = currentMilage;
        this.category = category;
        this.availability = availability;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getCurrentMilage() {
        return currentMilage;
    }

    public void setCurrentMilage(String currentMilage) {
        this.currentMilage = currentMilage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
