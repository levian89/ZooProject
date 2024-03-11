package com.myprojects.zooproject.model;

public class Felina extends Animal {
    public Felina(String name, int age, String country) {
        super(name, age, country);
    }



    public String toString() {
        return "Felina(super=" + super.toString() + ")";
    }
}
