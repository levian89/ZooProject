package com.myprojects.zooproject.model;

import com.myprojects.zooproject.model.Animal;

public class Peste extends Animal {
    private double tankSize;

    public Peste(String name, int age, String country, double tankSize) {
        super(name, age, country);
        this.tankSize = tankSize;
    }

    public double getTankSize() {
        return tankSize;
    }

    public void setTankSize(double tankSize) {
        this.tankSize = tankSize;
    }

    public String toString() {
        return "Peste(super=" + super.toString() + ", tankSize=" + this.tankSize + ")";
    }
}
