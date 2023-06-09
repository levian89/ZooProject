package com.myprojects.zooproject.model;

import com.myprojects.zooproject.model.Animal;

public class Arahnida extends Animal {
    public Arahnida(String name, int age, String country) {
        super(name, age, country);
    }

    public String toString() {
        return "Arahnida(super=" + super.toString() + ")";
    }
}
