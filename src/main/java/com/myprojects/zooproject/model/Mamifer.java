package com.myprojects.zooproject.model;

import com.myprojects.zooproject.model.Animal;

public class Mamifer extends Animal {

    public Mamifer(String name, int age, String country) {
        super(name, age, country);
    }

    public String toString() {
        return "Mamifer(super=" + super.toString() + ")";
    }
}
