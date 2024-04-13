package com.cthiebaud.yaml;

// Define a Java Bean class
public class Person {
    private String name;
    private int age;

    public Person() {
        // Default constructor required for JavaBeans convention
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString method for printing
    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
