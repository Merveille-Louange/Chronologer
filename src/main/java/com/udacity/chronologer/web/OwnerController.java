package com.udacity.chronologer.web;

import com.udacity.chronologer.DTO.OwnerDTO;
import com.udacity.chronologer.entity.Owner;
import com.udacity.chronologer.service.OwnerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/owner/{id}")
    public OwnerDTO getOwnerDTO(@PathVariable("id") Long id){
        Owner owner = ownerService.getOwner(id).get();
        return convertEntityToOwnerDTO(owner);
    }
    @PostMapping("/Owner")
    public void newOwner(@RequestBody OwnerDTO owner){
        Owner newOwner = convertOwnerDTOToEntity(owner);
        ownerService.save(newOwner);
    }

    @DeleteMapping("/owner/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        ownerService.delete(id);
    }

    private static OwnerDTO convertEntityToOwnerDTO(Owner owner){
        OwnerDTO ownerDTO= new OwnerDTO();
        BeanUtils.copyProperties(owner, ownerDTO);
        return ownerDTO;
    }

    @PutMapping("/owner/{id}")
    public OwnerDTO update(@RequestBody OwnerDTO ownerDTO){
        Owner owner=convertOwnerDTOToEntity(ownerDTO);
        Owner  newOwner=ownerService.getUpdate(owner);

        return convertEntityToOwnerDTO(newOwner);
    }
    @GetMapping("/owner/{name}")
    public OwnerDTO getOwnerByName( @PathVariable("name") String name){
        Owner owner=ownerService.findByName(name);
        return convertEntityToOwnerDTO(owner);
    }

    private static Owner convertOwnerDTOToEntity(OwnerDTO ownerDTO){
        Owner owner= new Owner();
        BeanUtils.copyProperties(ownerDTO, owner);
        return owner;
    }
}
