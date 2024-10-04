package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    // Add custom query methods here, if needed
}

