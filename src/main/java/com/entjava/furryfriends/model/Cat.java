package com.entjava.furryfriends.model;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Cat extends Pet {
    private String color;
    private boolean indoor;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    public boolean getIndoor() {
        return indoor;
    }
}
