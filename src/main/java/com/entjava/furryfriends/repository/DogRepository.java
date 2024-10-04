package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Long> {
    // Add custom query methods specific to Dog
}

