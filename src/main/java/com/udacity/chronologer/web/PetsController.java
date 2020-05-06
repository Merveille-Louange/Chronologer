package com.udacity.chronologer.web;

import com.udacity.chronologer.DTO.PetsDTO;
import com.udacity.chronologer.entity.Pets;
import com.udacity.chronologer.service.PetsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetsController {

    @Autowired
    private PetsService petsService;

    @GetMapping("/pets/{id}")
    public PetsDTO getPetsDTO(@PathVariable("id")Long id){
        Pets pets = petsService.getPets(id).get();
        return convertEntityToPetsDTO(pets);
    }
    @PostMapping("/pets")
    public void newPet(@RequestBody PetsDTO pets){
       Pets newPets = convertPetsDTOToEntity(pets);
       petsService.save(newPets);
    }
    @DeleteMapping("/pets/{id}")
    public void deletePet(@PathVariable("id") Long id){
        petsService.delete(id);
    }

    @PutMapping("/pets/{id}")
    public PetsDTO update(@RequestBody PetsDTO petsDTO){
        Pets pets=convertPetsDTOToEntity(petsDTO);
        Pets  newPet=petsService.getUpdate(pets);

        return convertEntityToPetsDTO(newPet);
    }

    @GetMapping("/pets/{name}")
    public PetsDTO getEmployeeByName(@PathVariable("name") String name){
        Pets pets=petsService.findByName(name);
        return convertEntityToPetsDTO(pets);
    }

    private static PetsDTO convertEntityToPetsDTO(Pets pets){
        PetsDTO petsDTO= new PetsDTO();
        BeanUtils.copyProperties(pets, petsDTO);
        return petsDTO;
    }

    private static Pets convertPetsDTOToEntity(PetsDTO petsDTO){
        Pets pets= new Pets();
        BeanUtils.copyProperties(petsDTO, pets);
        return pets;
    }
}
