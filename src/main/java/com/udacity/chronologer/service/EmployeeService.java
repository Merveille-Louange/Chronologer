package com.udacity.chronologer.service;


import com.udacity.chronologer.entity.Employee;
import com.udacity.chronologer.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.udacity.chronologer.exceptions.RecordNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(Long id) {
       Optional<Employee>employee=employeeRepository.findById(id);
       if(employee.isPresent()){

       return employee;
        }
    else {
               throw   new RecordNotFoundException("Ooops employee does not exist");
       }
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public void delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {

            employeeRepository.deleteById(id);

        }
        else {
            throw   new RecordNotFoundException("Ooops employee does not exist");
        }

    }

    public Employee getUpdate(Employee entity) {
        Optional<Employee> employee = employeeRepository.findById(entity.getId());
        if (employee.isPresent()) {
            Employee newEntity = employee.get();
            newEntity.setName(entity.getName());
            newEntity.setAddress(entity.getAddress());
            newEntity.setSkills(entity.getSkills());
            newEntity = employeeRepository.save(newEntity);
            return newEntity;
        } else {
            entity = employeeRepository.save(entity);
            return entity;
        }

    }

    public Employee findByName (String name){
        Employee employee= employeeRepository.findByName(name).orElse(null);
        return employee;
    }
    public List<Employee> findBySkills(String name){
       List <Employee> employee= employeeRepository.findBySkills(name);
        return employee;
    }
}