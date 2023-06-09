package com.myprojects.zooproject.model;

import com.myprojects.zooproject.model.Animal;

public class Felina extends Animal {
    public Felina(String name, int age, String country) {
        super(name, age, country);
    }



    public String toString() {
        return "Felina(super=" + super.toString() + ")";
    }
}
