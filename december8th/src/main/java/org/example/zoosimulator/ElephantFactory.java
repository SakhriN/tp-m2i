package org.example.zoosimulator;

public class ElephantFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(String type) {
        return new Elephant();
    }
}