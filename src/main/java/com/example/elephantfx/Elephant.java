package com.example.elephantfx;

import java.util.Objects;

public class Elephant {
    String name;
    int weight;
    String color;
    int length;

    public Elephant(String name, int weight, String color, int length) {
        this.name = name;
        this.weight = weight;
        this.color = color;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }
    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Elephant elephants = (Elephant) o;
        return weight == elephants.weight && length == elephants.length && Objects.equals(name, elephants.name) && Objects.equals(color, elephants.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, color, length);
    }

    @Override
    public String toString() {
        return "Elephant{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                ", length=" + length +
                '}';
    }
}
