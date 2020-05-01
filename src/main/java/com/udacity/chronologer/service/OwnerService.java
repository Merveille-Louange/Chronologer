package com.udacity.chronologer.service;

import com.udacity.chronologer.entity.Owner;
import com.udacity.chronologer.entity.Scheduler;
import com.udacity.chronologer.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    public void save(Owner owner) {
        ownerRepository.save(owner);
    }

    public Owner getOwner(Long id) {
        return ownerRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        if (owner.isPresent()) {

            ownerRepository.deleteById(id);

        }

    }

    public Owner getUpdate(Owner entity) {
        Optional<Owner> owner = ownerRepository.findById(entity.getId());
        if (owner.isPresent()) {
            Owner newEntity = owner.get();
            newEntity.setName(entity.getName());
            newEntity.setPets(entity.getPets());
            newEntity.setAddress(entity.getAddress());
            newEntity = ownerRepository.save(newEntity);
            return newEntity;
        } else {
            entity = ownerRepository.save(entity);
            return entity;
        }

    }

    public Owner findByName (String name){
        Owner owner= ownerRepository.findByName(name).orElse(null);
        return owner;
    }}