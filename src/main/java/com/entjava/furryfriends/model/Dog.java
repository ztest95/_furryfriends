package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Dog extends Pet {
    private String breed;
    private boolean trained;
}
