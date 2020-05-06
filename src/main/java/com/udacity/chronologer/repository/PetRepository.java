package com.udacity.chronologer.repository;

import com.udacity.chronologer.entity.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pets, Long> {

    @Query("SELECT t FROM Pets t where t.name = :name")
    Optional<Pets> findByName(@Param("name") String name);
}
