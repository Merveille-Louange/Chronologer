package com.udacity.chronologer.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String address;
    private String skills;

    @ManyToMany(mappedBy = "employee", cascade=CascadeType.REMOVE)
    List<Scheduler> schedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<Scheduler> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Scheduler> schedule) {
        this.schedule = schedule;
    }
}
