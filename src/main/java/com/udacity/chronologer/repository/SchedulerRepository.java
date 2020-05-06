package com.udacity.chronologer.repository;


import com.udacity.chronologer.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler,Long> {


}
