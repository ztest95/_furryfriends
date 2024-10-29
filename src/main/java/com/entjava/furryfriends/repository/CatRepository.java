package com.entjava.furryfriends.repository;

import com.entjava.furryfriends.model.Cat;
import org.hibernate.annotations.CollectionTypeRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface CatRepository extends JpaRepository<Cat, Long> {
    // Add custom query methods specific to Cat
}
