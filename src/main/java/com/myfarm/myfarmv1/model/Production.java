package com.myfarm.myfarmv1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Production {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String crop;
    @Column
    private String measurementUnit;
    @Column
    private double quantity;
    @Column
    private String dateCollected;

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", crop='" + crop + '\'' +
                ", measurementUnit='" + measurementUnit + '\'' +
                ", quantity=" + quantity +
                ", dateCollected='" + dateCollected + '\'' +
                '}';
    }

    public Production() {
    }

    public Production(Long id, String crop, String measurementUnit, double quantity, String dateCollected) {
        this.id = id;
        this.crop = crop;
        this.measurementUnit = measurementUnit;
        this.quantity = quantity;
        this.dateCollected = dateCollected;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getDateCollected() {
        return dateCollected;
    }

    public void setDateCollected(String dateCollected) {
        this.dateCollected = dateCollected;
    }

}
