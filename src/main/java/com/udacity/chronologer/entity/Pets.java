package com.udacity.chronologer.entity;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import javax.persistence.Id;

import java.util.Date;
import java.util.List;

@Entity

public class Pets {

    @Id
    @GeneratedValue
     Long id;

    private String type;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    Owner owner;

    @ManyToMany(mappedBy = "pets", cascade=CascadeType.REMOVE)
    List<Scheduler> schedule;

    private java.util.Date birthDate;
    @Nationalized
    private String notes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Scheduler> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<Scheduler> schedule) {
        this.schedule = schedule;
    }
}
