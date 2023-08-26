package com.myfarm.myfarmv1.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Table(name = "Activity")
public class Activity {

    public Activity() {
    }

    @Id
    @GeneratedValue
    private long id;
    @Column
    private String location;
    @Column
    private String description;
    @Column
    private String dateCreated;
    @Column
    private String dateUpdated;

    public Activity(String location, String description, String dateCreated) {
        this.location = location;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateUpdated = LocalDate.now().toString();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", dateUpdated=" + dateUpdated +
                '}';
    }
}
