package com.udacity.chronologer.entity;



import javax.persistence.*;


import java.util.List;


@Entity
public class Owner {

    @Id
    @GeneratedValue
    Long id;

    private String name;
    private String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id", cascade=CascadeType.ALL)
     List<Pets> pets;

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

    public List<Pets> getPets() {
        return pets;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }
}
