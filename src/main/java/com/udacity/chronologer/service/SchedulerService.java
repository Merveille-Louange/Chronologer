package com.udacity.chronologer.service;

import com.udacity.chronologer.entity.Scheduler;
import com.udacity.chronologer.exceptions.RecordNotFoundException;
import com.udacity.chronologer.repository.SchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulerService {

    @Autowired
    SchedulerRepository schedulerRepository;

    public void save(Scheduler scheduler){
        schedulerRepository.save(scheduler);
    }

    public Optional<Scheduler> getSchedule(Long id){
        Optional<Scheduler> scheduler = schedulerRepository.findById(id);
        if (scheduler.isPresent()) {

            return scheduler;
        }
        else {
            throw   new RecordNotFoundException("Sorry,no schedule found with this id");
        }

    }
    public List<Scheduler> getAllSchedule(){
        return schedulerRepository.findAll();
    }
    public void delete(Long id) {
        Optional<Scheduler> schedule = schedulerRepository.findById(id);
        if (schedule.isPresent()) {

            schedulerRepository.deleteById(id);

        }
        else {
            throw   new RecordNotFoundException("Ooops Schedule not found");
        }

    }

    public Scheduler getUpdate(Scheduler entity){
        Optional<Scheduler> scheduler=schedulerRepository.findById(entity.getId());
        if(scheduler.isPresent()){
            Scheduler newEntity=scheduler.get();
            newEntity.setTime(entity.getTime());
            newEntity.setPets(entity.getPets());
            newEntity.setEmployee(entity.getEmployee());
            newEntity=schedulerRepository.save(newEntity);
            return newEntity;
        }
        else {
            entity=schedulerRepository.save(entity);
            return entity;
        }

    }
}
