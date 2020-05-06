package com.udacity.chronologer.service;

import com.udacity.chronologer.entity.Pets;
import com.udacity.chronologer.exceptions.RecordNotFoundException;
import com.udacity.chronologer.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PetsService {
    @Autowired
    PetRepository petRepository;

    public Optional<Pets> getPets(Long id) {
        Optional<Pets> pet = petRepository.findById(id);
        if (pet.isPresent()) {

        return pet;
        }
        else {
            throw   new RecordNotFoundException("Sorry, this pet does not exist");
        }

    }

    public void save(Pets pets) {
        petRepository.save(pets);

    }

    public void delete(Long id) {
        Optional<Pets> pets = petRepository.findById(id);
        if (pets.isPresent()) {

            petRepository.deleteById(id);

        }
        else {
            throw   new RecordNotFoundException("Ooops this pet does not exist");
        }

    }

    public Pets getUpdate(Pets entity) {
        Optional<Pets> pets = petRepository.findById(entity.getId());
        if (pets.isPresent()) {
            Pets newEntity = pets.get();
            newEntity.setName(entity.getName());
            newEntity.setType(entity.getType());
            newEntity.setBirthDate(entity.getBirthDate());
            newEntity.setNotes(entity.getNotes());
            newEntity.setOwner(entity.getOwner());
            newEntity.setSchedule(entity.getSchedule());


            newEntity = petRepository.save(newEntity);
            return newEntity;
        } else {
            entity = petRepository.save(entity);
            return entity;
        }


    }

    public Pets findByName (String name){
        Pets pets= petRepository.findByName(name).orElse(null);
        return pets;
    }

}
