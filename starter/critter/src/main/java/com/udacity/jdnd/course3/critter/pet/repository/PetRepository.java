package com.udacity.jdnd.course3.critter.pet.repository;

import com.udacity.jdnd.course3.critter.pet.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("SELECT p FROM Pet p WHERE p.id = ?1")
    Pet findPetById(Long id);
    @Query("SELECT p FROM Pet p")
    List<Pet> findAllPets();
    //@Query(value = "SELECT * FROM Pet where ownerid = :id", nativeQuery = true)
    List<Pet> findByCustomer(Long id);
}
