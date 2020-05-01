package com.udacity.chronologer.DTO;

import com.udacity.chronologer.entity.Employee;
import com.udacity.chronologer.entity.Pets;

import java.time.LocalDateTime;
import java.util.List;

public class ScheduleDTO {
    LocalDateTime time;


    List<Pets> pets;

    List<Employee> employee;


}
