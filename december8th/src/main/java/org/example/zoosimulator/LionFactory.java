package org.example.zoosimulator;

public class LionFactory extends AnimalFactory {
    @Override
    public Animal createAnimal(String type) {
        return new Lion();
    }
}