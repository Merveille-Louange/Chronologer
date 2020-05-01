package com.udacity.chronologer.repository;

import com.udacity.chronologer.entity.Owner;
import com.udacity.chronologer.entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {

    @Query("SELECT t FROM Owner t where t.name = :name")
    Optional<Owner> findByName(@Param("name") String name);

}
