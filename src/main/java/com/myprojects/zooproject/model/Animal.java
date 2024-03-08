package com.myprojects.zooproject.model;

public class Animal {
    private String name;
    private int age;
    private String country;


    public Animal(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toCsv() {
        return this.name + "," + this.age + "," + this.country;
    }


    public String toString() {
        return "Animal(name=" + this.name + ", age=" + this.age + ", country=" + this.country + ")";
    }
}
