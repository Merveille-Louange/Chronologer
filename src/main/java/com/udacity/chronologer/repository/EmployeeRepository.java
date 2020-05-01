package com.udacity.chronologer.repository;

import com.udacity.chronologer.entity.Employee;
import com.udacity.chronologer.entity.Pets;
import com.udacity.chronologer.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT t FROM Employee t where t.name = :name")
    Optional<Employee> findByName(@Param("name") String name);

    @Query("SELECT t FROM Employee t where t.skills = :skills")
    List<Employee> findBySkills(String skills);
}
