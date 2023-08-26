package com.myfarm.myfarmv1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Equipment")
public class Equipment {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private String utility;

    public int getQuantity() {
        return quantity;
    }

    public Equipment() {
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    public Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", utility='" + utility + '\'' +
                '}';
    }
}
