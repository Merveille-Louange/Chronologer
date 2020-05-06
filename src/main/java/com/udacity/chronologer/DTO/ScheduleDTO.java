package com.udacity.chronologer.DTO;

import com.udacity.chronologer.entity.Employee;
import com.udacity.chronologer.entity.Pets;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleDTO {
    LocalDateTime time;


    List<Pets> pets;

    List<Employee> employee;

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public List<Pets> getPets() {
        return pets;
    }

    public void setPets(List<Pets> pets) {
        this.pets = pets;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }
}
