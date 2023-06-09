package com.myprojects.zooproject.model;

import com.myprojects.zooproject.model.Animal;

public class Reptila extends Animal {
    private double surroundingTemp;

    public Reptila(String name, int age, String country, double surroundingTemp) {
        super(name, age, country);
        this.surroundingTemp = surroundingTemp;
    }

    public double getSurroundingTemp() {
        return surroundingTemp;
    }

    public void setSurroundingTemp(double surroundingTemp) {
        this.surroundingTemp = surroundingTemp;
    }

    public String toString() {
        return "Reptila(super=" + super.toString() + ", surroundingTemp=" + this.surroundingTemp + ")";
    }
}
