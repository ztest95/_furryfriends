package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatRepository extends JpaRepository<Cat, Long> {
    // Add custom query methods specific to Cat
}
