package com.udacity.chronologer.repository;


import com.udacity.chronologer.entity.Pets;
import com.udacity.chronologer.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler,Long> {


}
