package com.example.elephantfx;

import java.util.Objects;

public class Human {
    String name;
    String prof;
    int age;

    public Human(String name, String prof, int age) {
        this.name = name;
        this.prof = prof;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getProf() {
        return prof;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && name.equals(human.name) && Objects.equals(prof, human.prof);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, prof, age);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", prof='" + prof + '\'' +
                ", age=" + age +
                '}';
    }
}
